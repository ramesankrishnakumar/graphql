CREATE TABLE student
(
    id         bigint      NOT NULL AUTO_INCREMENT,
    first_name varchar(50) NOT NULL,
    last_name  varchar(50) DEFAULT NULL,
    email      varchar(30) DEFAULT NULL,
    address_id bigint      DEFAULT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE address
(
    id     bigint NOT NULL AUTO_INCREMENT,
    street varchar(100) NOT NULL,
    city   varchar(45)  NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE subject
(
    id             bigint NOT NULL AUTO_INCREMENT,
    subject_name   varchar(45)    DEFAULT NULL,
    marks_obtained numeric(10, 6) DEFAULT NULL,
    student_id     bigint         DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (student_id) REFERENCES student (id)
);

CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 10 INCREMENT BY 1;