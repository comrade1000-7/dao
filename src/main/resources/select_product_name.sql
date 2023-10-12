SELECT product_name, name FROM ORDERS ord JOIN CUSTOMERS C ON C.id = ord.customer_id
WHERE name = :name;