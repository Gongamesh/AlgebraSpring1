INSERT INTO Category (Name)
VALUES ('Processor');

INSERT INTO Category (Name)
VALUES ('Graphics Card');

INSERT INTO Category (Name)
VALUES ('Mbo');

INSERT INTO Category (Name)
VALUES ('Memory');

INSERT INTO Category (Name)
VALUES ('HDD & SSD');

INSERT INTO Category (Name)
VALUES ('Other');

INSERT INTO Hardware (Code, Name, Price, Available, CategoryFK)
VALUES ('A1', 'AMD Ryzen', 180, 5, 1);

INSERT INTO Hardware (Code, Name, Price, Available, CategoryFK)
VALUES ('B2', 'NVIDIA GeForce', 350, 10, 2);

INSERT INTO Hardware (Code, Name, Price, Available, CategoryFK)
VALUES ('C3', 'Corsair Vengeance', 60, 50, 4);

INSERT INTO Hardware (Code, Name, Price, Available, CategoryFK)
VALUES ('D4', 'MSI B550', 130, 7, 3);

INSERT INTO Hardware (Code, Name, Price, Available, CategoryFK)
VALUES ('E5', 'Samsung 970 EVO', 90, 20, 5);

INSERT INTO Hardware (Code, Name, Price, Available, CategoryFK)
VALUES ('F6', 'Corsair CX650', 70, 28, 6);