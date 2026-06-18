INSERT INTO Type (Name)
VALUES ('Processor');

INSERT INTO Type (Name)
VALUES ('Graphics Card');

INSERT INTO Type (Name)
VALUES ('Mbo');

INSERT INTO Type (Name)
VALUES ('Memory');

INSERT INTO Type (Name)
VALUES ('HDD & SSD');

INSERT INTO Type (Name)
VALUES ('Other');

INSERT INTO Hardware (Code, Name, Price, Available, type_fk)
VALUES ('A1', 'AMD Ryzen', 180, 5, 1);

INSERT INTO Hardware (Code, Name, Price, Available, type_fk)
VALUES ('B2', 'NVIDIA GeForce', 350, 10, 2);

INSERT INTO Hardware (Code, Name, Price, Available, type_fk)
VALUES ('C3', 'Corsair Vengeance', 60, 50, 4);

INSERT INTO Hardware (Code, Name, Price, Available, type_fk)
VALUES ('D4', 'MSI B550', 130, 7, 3);

INSERT INTO Hardware (Code, Name, Price, Available, type_fk)
VALUES ('E5', 'Samsung 970 EVO', 90, 20, 5);

INSERT INTO Hardware (Code, Name, Price, Available, type_fk)
VALUES ('F6', 'Corsair CX650', 70, 28, 6);