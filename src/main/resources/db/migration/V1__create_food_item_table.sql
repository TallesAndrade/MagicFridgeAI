CREATE TABLE food_item(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(55) NOT NULL ,
    category VARCHAR(55),
    quantity INTEGER NOT NULL,
    expiration_date DATE NOT NULL
)