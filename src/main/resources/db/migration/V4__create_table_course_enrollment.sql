CREATE TABLE IF NOT EXISTS course_enrollment (
    id int NOT NULL AUTO_INCREMENT,
    course_id int NOT NULL,
    student_id int NOT NULL,
    tutor_id int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (course_id) REFERENCES course(id),
    FOREIGN KEY (student_id) REFERENCES student(id),
    FOREIGN KEY (tutor_id) REFERENCES tutor(id)
)