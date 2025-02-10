CREATE TABLE COURSES (
    id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    category VARCHAR(20) NOT NULL,
    rating INT NOT NULL,  -- 또는 TINYINT
    description TEXT NOT NULL,  -- 또는 VARCHAR(1000)
    PRIMARY KEY (id)
);