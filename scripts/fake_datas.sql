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
