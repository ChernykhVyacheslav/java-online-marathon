DROP ALL OBJECTS;

CREATE SCHEMA IF NOT EXISTS newSchema;
DROP SCHEMA IF EXISTS newSchema2;

CREATE TABLE roles
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    roleName VARCHAR(15) NOT NULL UNIQUE
);

CREATE TABLE directions
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    directionName VARCHAR(15) NOT NULL
);

CREATE TABLE projects
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    projectName VARCHAR(15) NOT NULL,
    directionId INT,
    FOREIGN KEY (directionId) REFERENCES directions (id)
);

CREATE TABLE Employee
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(15) NOT NULL,
    roleId    INT,
    FOREIGN KEY (roleId) REFERENCES roles (id),
    projectId INT,
    FOREIGN KEY (projectId) REFERENCES projects (id)
);

INSERT INTO directions VALUES (1, 'Java');

SELECT id FROM directions WHERE directionName = 'Java';

SELECT firstName from Employee