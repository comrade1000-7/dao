package org.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class DAORepository {

    //private static final String scriptFile = "select_product_name.sql";
    private final String scriptFile;
    @Autowired
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public DAORepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.scriptFile = read("select_product_name.sql");
    }

    private static String read(String scriptFile) {
        try (InputStream is = new ClassPathResource(scriptFile).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*public List<String> getProductName(String name) {
        return jdbcTemplate.query(scriptFile, Map.of("name", name),
                ((rs, rowNum) -> rs.getString("product_name")));
    }*/

    public List<String> getProductName(String name) {
        return jdbcTemplate.queryForList(scriptFile, Map.of("name", name), String.class);
    }
}
