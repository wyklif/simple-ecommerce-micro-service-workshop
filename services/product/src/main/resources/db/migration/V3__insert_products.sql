-- Insert dummy products

insert into product (id, name, description, available_quantity, price, category_id) values
-- Electronics (category_id = 251)
(1001, 'Smartphone X', 'High-end smartphone with 128GB storage and 5G connectivity', 120, 699.99, 251),
(1002, 'LED TV 55-inch', '4K Ultra HD Smart TV with HDR support', 45, 899.50, 251),
(1003, 'Wireless Headphones', 'Noise-cancelling Bluetooth headphones', 80, 149.99, 251),

-- Groceries (category_id = 301)
(1004, 'Organic Rice 5kg', 'Premium long-grain rice', 200, 12.49, 301),
(1005, 'Olive Oil 1L', 'Extra virgin cold-pressed olive oil', 150, 9.99, 301),
(1006, 'Instant Coffee 200g', 'Rich aroma instant coffee blend', 300, 4.75, 301),

-- Furniture (category_id = 351)
(1007, 'Office Chair', 'Ergonomic mesh chair with lumbar support', 60, 89.99, 351),
(1008, 'Wooden Dining Table', '6-seater hardwood dining table', 20, 499.00, 351),
(1009, 'Sofa Set', '3-piece modern fabric sofa set', 15, 999.00, 351),

-- Clothing (category_id = 401)
(1010, 'Men T-Shirt', 'Cotton round-neck t-shirt available in multiple colors', 250, 14.99, 401),
(1011, 'Women Jeans', 'Slim-fit blue jeans with stretch fabric', 180, 39.99, 401),
(1012, 'Kids Hoodie', 'Warm fleece hoodie for kids', 100, 24.99, 401),

-- Books (category_id = 451)
(1013, 'The Pragmatic Programmer', 'Classic book on software craftsmanship', 80, 44.95, 451),
(1014, 'Atomic Habits', 'A guide to building good habits and breaking bad ones', 90, 19.99, 451),
(1015, 'Clean Code', 'A handbook of agile software craftsmanship', 70, 49.99, 451);


