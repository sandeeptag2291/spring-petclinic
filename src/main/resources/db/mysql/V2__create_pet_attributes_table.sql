CREATE TABLE pet_attributes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    pet_id INT NOT NULL,
    temperament VARCHAR(100),
    length DECIMAL(5,2),
    weight DECIMAL(5,2),
    FOREIGN KEY (pet_id) REFERENCES pets(id)
);
