--Reset Table
DROP TABLE IF EXISTS transactions;
DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS users;

-- Account Roles
DROP TYPE IF EXISTS user_role;
CREATE TYPE user_role as ENUM ('user', 'staff', 'admin');

-- Create the users table
CREATE TABLE IF NOT EXISTS users  (
    user_id SERIAL PRIMARY KEY,  -- Unique identifier for each user
    first_name VARCHAR(100) NOT NULL,  -- First name of the user
    last_name VARCHAR(100) NOT NULL,  -- Last name of the user
    email VARCHAR(255) UNIQUE NOT NULL,  -- Email address of the user
	password varchar(255) NOT NULL,
    role user_role NOT NULL DEFAULT 'user',
    date_of_birth DATE,  -- Date of birth of the user
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Timestamp when the user was created
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- Timestamp for the last update
);

-- Create the accounts table
CREATE TABLE IF NOT EXISTS accounts (
    account_id SERIAL PRIMARY KEY,  -- Unique identifier for each account
    user_id INT NOT NULL,  -- Foreign key referencing the user who owns the account
    account_type VARCHAR(50) NOT NULL,  -- Type of the account (e.g., 'checking', 'savings')
    balance DECIMAL(15, 2) DEFAULT 0.00,  -- Balance of the account
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Timestamp when the account was created
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Timestamp for the last update
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE  -- Foreign key constraint
);

-- Create a table to track account transactions (optional, for auditing purposes)
CREATE TABLE IF NOT EXISTS transactions (
    transaction_id SERIAL PRIMARY KEY,  -- Unique identifier for each transaction
    account_id INT NOT NULL,  -- Foreign key referencing the account the transaction belongs to
    transaction_type VARCHAR(50) NOT NULL,  -- Type of transaction (e.g., 'deposit', 'withdrawal')
    amount DECIMAL(15, 2) NOT NULL,  -- Transaction amount
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Timestamp of the transaction
    balance_after DECIMAL(15, 2),  -- Account balance after the transaction
    description TEXT,  -- Description or notes about the transaction (optional)
    FOREIGN KEY (account_id) REFERENCES accounts (account_id) ON DELETE CASCADE  -- Foreign key constraint
);
