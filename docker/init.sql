CREATE TABLE IF NOT EXISTS student
(
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(50),
    major VARCHAR(50),
    year INT
);

CREATE TABLE IF NOT EXISTS course
(
    id SERIAL NOT NULL PRIMARY KEY,
    courseName VARCHAR(50),
    courseNumber VARCHAR(50),
    capacity INT
);
CREATE TABLE IF NOT EXISTS instructor
(
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(50),
    office VARCHAR(50),
    phone VARCHAR(50),
    email VARCHAR(50)
);
