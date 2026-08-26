DROP DATABASE IF EXISTS practice;
CREATE DATABASE practice;
USE practice;
CREATE TABLE waiting (
    phone     VARCHAR(20) NOT NULL,
    headcount INT NOT NULL,
    CONSTRAINT PRIMARY KEY( phone )
);