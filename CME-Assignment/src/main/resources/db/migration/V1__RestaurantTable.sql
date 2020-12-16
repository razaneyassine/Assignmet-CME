CREATE TABLE category(
    Id SERIAL PRIMARY KEY ,
    Name VARCHAR (100) NOT NULL

);
CREATE TABLE restaurant(
    Id UUID NOT NULL PRIMARY KEY,
    Name VARCHAR (100) NOT NULL,
    CategoryId int NOT NULL,
    Average float NOT NULL ,
    Address VARCHAR (100) NOT NULL,
    PhoneNumber VARCHAR (100) NOT NULL,
    Checked BOOLEAN DEFAULT false,
    Check_at VARCHAR (100) NULL ,
    Path VARCHAR (500) NOT NULL,

     FOREIGN KEY (CategoryId) REFERENCES category(Id)
);






