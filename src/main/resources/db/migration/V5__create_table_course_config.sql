CREATE TABLE IF NOT EXISTS course_config (
    id int NOT NULL AUTO_INCREMENT,
    course_id int NOT NULL,
    code VARCHAR(100),
    value  VARCHAR(100),
    PRIMARY KEY (id),
    FOREIGN KEY (course_id) REFERENCES course(id)
)