# Etiqa -School Module System

Stack use : Spring Boot + Flyway + JPA + Lombok + MySQL + Vue

## Setup Docker Local Container MySQL

docker pull mysql

docker run --name=local-mysql -p 3306 -p 33060 -e MYSQL_ROOT_PASSWORD=root -d mysql

docker exec -it local-mysql bash

mysql -u root -p

create database MYSQLTEST;

## MySQL Client DBEAVER setting

"useSSL" : false 

 "allowPublicKeyRetrieval" : true

### BackEnd Spring boot start in

[http://localhost:808](http://localhost:8081/)0

[http://localhost:808](http://localhost:8081/)0/v1/school/student/list 

→ GET getStudents

[http://localhost:808](http://localhost:8081/)0/v1/school/student/{id} 

→ GET getStudentDetail

[http://localhost:808](http://localhost:8081/)0/v1/school/student/{id} 

→ DELETE deleteStudent

[http://localhost:808](http://localhost:8081/)0/v1/school/student

→ POST add/editStudent

[http://localhost:808](http://localhost:8081/)0/v1/school/course-enrollment/student/{student-id}

→ GET getCoursesEnrollByStudent

[http://localhost:808](http://localhost:8081/)0/v1/school/course-enrollment

→ POST add/editCoursesEnrollByStudent

[http://localhost:808](http://localhost:8081/)0/v1/school/course-enrollment/{id}

→ DELETE  courseEnrollByStudent

[http://localhost:808](http://localhost:8081/)0/v1/school/course/{id}

→ GET getCourseDetail

h[ttp://localhost:808](http://localhost:8081/)0/v1/school/course

→ POST add/editCourse

h[ttp://localhost:808](http://localhost:8081/)0/v1/school/course/{id}

→ DELETE course

[http://localhost:808](http://localhost:8081/)0/v1/school/course-config/{course-id}

→ GET getCourse Config Detail

### FrontEnd Vue start in

[http://localhost:](http://localhost:8081/)3000

### Script in

school/src/main/resources/db/migration