CREATE TABLE category(
    id SERIAL PRIMARY KEY ,
    Name VARCHAR (100) NOT NULL

);
CREATE TABLE restaurant(
    id UUID NOT NULL PRIMARY KEY,
    Name VARCHAR (100) NOT NULL,
    CategoryId int NOT NULL,
    Average float NOT NULL ,
    Address VARCHAR (100) NOT NULL,
    PhoneNumber VARCHAR (100) NOT NULL,
    checked BOOLEAN DEFAULT false,
    check_at VARCHAR (100) NULL ,
    path VARCHAR (500) NOT NULL,

     FOREIGN KEY (CategoryId) REFERENCES category(id)
);


-- CREATE TABLE Checked(
--     id SERIAL PRIMARY KEY,
--     checked_at DATE DEFAULT CURRENT_DATE,
--     name VARCHAR (100) NOT NULL,
--       RestaurantID UUID NOT NULL,
--     FOREIGN KEY (RestaurantID) REFERENCES restaurant(id)
-- );




