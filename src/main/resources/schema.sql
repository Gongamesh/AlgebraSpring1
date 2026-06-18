/*DROP TABLE IF EXISTS Category;
DROP TABLE IF EXISTS Hardware;

CREATE TABLE Category (
    Id IDENTITY PRIMARY KEY,
    Name VARCHAR(50)
);

CREATE TABLE Hardware (
    Id IDENTITY PRIMARY KEY,
    Code VARCHAR(50) UNIQUE,
    Name VARCHAR(50),
    Price DECIMAL(10,2),
    Available INT,
    CategoryFK INT,
    FOREIGN KEY (CategoryFK) REFERENCES Category(Id)
);*/