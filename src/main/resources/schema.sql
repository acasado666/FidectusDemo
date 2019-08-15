CREATE TABLE fi (
     id BIGINT PRIMARY KEY auto_increment,
     fi_name VARCHAR(255),
     fi_description VARCHAR(255),
     market VARCHAR(255)
);

CREATE TABLE order_book (
     id BIGINT PRIMARY KEY auto_increment,
     fi_id BIGINT REFERENCES fi (id),
     title VARCHAR(255),
     description VARCHAR(255)
);
