CREATE TABLE products (
    product_id INTEGER PRIMARY KEY,
    product_name VARCHAR2(30),
    category VARCHAR2(30),
    quantity_left INTEGER,
    price NUMBER
);

DROP TABLE PRODUCTS;
DROP TABLE SHOPUSER;

CREATE TABLE SHOPUSER (
    username VARCHAR2(30) PRIMARY KEY,
    firstname VARCHAR2(30),
    lastname VARCHAR2(30),
    password VARCHAR2(30)
);
CREATE TABLE totest(
u varchar2(20)
);

INSERT INTO PRODUCTS VALUES(1, 'PRODUCT1', 'CAT1', 20, 1);
INSERT INTO PRODUCTS VALUES(2, 'PRODUCT2', 'CAT1', 20, 1);
INSERT INTO PRODUCTS VALUES(3, 'PRODUCT3', 'CAT2', 20, 1);
INSERT INTO PRODUCTS VALUES(4, 'PRODUCT4', 'CAT3', 20, 1);

commit;

select  category from products where product_id = 1;

