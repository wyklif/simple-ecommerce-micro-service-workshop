-- Insert dummy categories
insert into category (id, name, description) values
(nextval('category_seq'), 'Electronics', 'Devices and gadgets like phones, TVs, and laptops'),
(nextval('category_seq'), 'Groceries', 'Daily food and beverage items'),
(nextval('category_seq'), 'Furniture', 'Home and office furniture'),
(nextval('category_seq'), 'Clothing', 'Men, women, and kids wear'),
(nextval('category_seq'), 'Books', 'Educational and leisure reading materials');

