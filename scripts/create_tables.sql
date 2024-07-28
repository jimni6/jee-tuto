-- Supprimer la base de données existante
DROP DATABASE IF EXISTS jee_tuto;

-- Créer une nouvelle base de données
CREATE DATABASE jee_tuto;

-- Create the 'customers' table
CREATE TABLE customers (
                           customer_id SERIAL PRIMARY KEY,
                           first_name VARCHAR(50) NOT NULL,
                           last_name VARCHAR(50) NOT NULL,
                           email VARCHAR(100) UNIQUE NOT NULL,
                           password VARCHAR(100) NOT NULL,
                           phone VARCHAR(20),
                           address TEXT,
                           city VARCHAR(50),
                           state VARCHAR(50),
                           zip_code VARCHAR(20),
                           created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
                           updated_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);

-- Create the 'vendors' table
CREATE TABLE vendors (
                         vendor_id SERIAL PRIMARY KEY,
                         vendor_name VARCHAR(100) NOT NULL,
                         contact_person VARCHAR(100),
                         email VARCHAR(100) UNIQUE NOT NULL,
                         phone VARCHAR(20),
                         address TEXT,
                         city VARCHAR(50),
                         state VARCHAR(50),
                         zip_code VARCHAR(20),
                         created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);

-- Create the 'products' table
CREATE TABLE products (
                          product_id SERIAL PRIMARY KEY,
                          product_name VARCHAR(100) NOT NULL,
                          description TEXT,
                          price NUMERIC(10, 2) NOT NULL, -- Price with 2 decimal places
                          stock_quantity INT NOT NULL DEFAULT 0,
                          vendor_id INT NOT NULL,
                          created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
                          FOREIGN KEY (vendor_id) REFERENCES vendors (vendor_id) ON DELETE CASCADE
);

-- Optional: Create an index on product_name for faster searches
CREATE INDEX idx_product_name ON products (product_name);

-- Optional: Create an index on email for faster searches
CREATE INDEX idx_customer_email ON customers (email);
CREATE INDEX idx_vendor_email ON vendors (email);

-- Insert data into 'vendors' table
INSERT INTO vendors (vendor_name, contact_person, email, phone, address, city, state, zip_code)
VALUES
    ('Tech Supplies Co.', 'Alice Johnson', 'alice.johnson@techsupplies.com', '555-0101', '123 Tech Road', 'Techville', 'CA', '90001'),
    ('Gadget World', 'Bob Smith', 'bob.smith@gadgetworld.com', '555-0202', '456 Gadget Lane', 'Gadget City', 'NY', '10001');

-- Insert data into 'customers' table
INSERT INTO customers (first_name, last_name, email, password, phone, address, city, state, zip_code)
VALUES
    ('John', 'Doe', 'john.doe@example.com', 'password', '555-1001', '789 Elm Street', 'Springfield', 'IL', '62701'),
    ('Jane', 'Smith', 'jane.smith@example.com', 'password', '555-1002', '101 Maple Avenue', 'Greenfield', 'WI', '53201'),
    ('Emily', 'Davis', 'emily.davis@example.com', 'password', '555-1003', '202 Oak Drive', 'Lakeside', 'FL', '33101'),
    ('Michael', 'Brown', 'michael.brown@example.com', 'password', '555-1004', '303 Pine Road', 'Hometown', 'TX', '75001'),
    ('Sarah', 'Wilson', 'sarah.wilson@example.com', 'password', '555-1005', '404 Cedar Boulevard', 'Metro City', 'WA', '98101');

-- Insert data into 'products' table
INSERT INTO products (product_name, description, price, stock_quantity, vendor_id)
VALUES
    ('Smartphone XYZ', 'Latest model with 128GB storage', 699.99, 50, 1),
    ('Laptop Pro', 'High-performance laptop with 16GB RAM', 1299.99, 30, 1),
    ('Bluetooth Headphones', 'Noise-cancelling over-ear headphones', 149.99, 100, 2),
    ('4K Ultra HD TV', '55-inch 4K resolution TV', 799.99, 20, 2),
    ('Wireless Charger', 'Fast wireless charger for smartphones', 49.99, 75, 1),
    ('Smartwatch Series 5', 'Smartwatch with fitness tracking', 299.99, 40, 2);
