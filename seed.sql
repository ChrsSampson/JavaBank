-- seed some test data into the tables

-- user seed
INSERT INTO users (user_id, first_name, last_name, email, password) 
VALUES 
    (1, 'John', 'Doe', 'john.doe@example.com', 'password123'),
    (2, 'Jane', 'Smith', 'jane.smith@example.com', 'securepassword'),
    (3, 'Michael', 'Brown', 'michael.brown@example.com', 'passw0rd'),
    (4, 'Emily', 'Davis', 'emily.davis@example.com', 'mypassword'),
    (5, 'William', 'Johnson', 'william.johnson@example.com', 'letmein123');
