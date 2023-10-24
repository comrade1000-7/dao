SELECT o.product_name AS product
FROM ORDERS o
         JOIN CUSTOMERS c ON o.customer_id = c.id
WHERE c.name = :name;