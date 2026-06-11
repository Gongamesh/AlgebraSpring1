CREATE TABLE Category (
    Id int PRIMARY KEY IDENTITY,
    Name VARCHAR(50)
)

CREATE TABLE Hardware (
    Id int PRIMARY KEY IDENTITY,
    Code VARCHAR(50) UNIQUE,
    Name VARCHAR(50),
    Price DECIMAL(10,2),
    Available INT,
    CategoryFK INT,
    FOREIGN KEY (CategoryFK) REFERENCES Category(Id)
)