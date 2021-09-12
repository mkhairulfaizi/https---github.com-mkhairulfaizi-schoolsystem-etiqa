CREATE TABLE IF NOT EXISTS tutor (
    id INT NOT NULL AUTO_INCREMENT,
    card_id VARCHAR(100),
    name VARCHAR(100),
    phone_no VARCHAR(20),
    ic_no VARCHAR(20),
    PRIMARY KEY (id)
)