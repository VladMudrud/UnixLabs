-- encrypt data postgres extension
CREATE EXTENSION pgcrypto;

-- categories
insert into categories(name) values
('electronics'), ('household'), ('food'), ('toys'), ('appliances');

-- clients
insert into clients(name, birth_date, email, password) values
('Ihor', '1991-12-22'::timestamp,'work.bibi4kov@gmail.com', crypt('password_default', gen_salt('bf'))),
('Tom',  '1993-11-24'::timestamp,'tom.fun@gmail.com', crypt('some_password', gen_salt('bf'))),
('Garry','1989-1-1'::timestamp,'some.email@gmail.com', crypt('password_default_123', gen_salt('bf'))),
('Jeremy', '2000-2-20'::timestamp,'email@gmail.com', crypt('password_default_321', gen_salt('bf'))),
('Mark', '1979-7-5'::timestamp,'work@gmail.com', crypt('password_default_445', gen_salt('bf')));

-- licenses
insert into licenses(name, tax_registry) values
('regular', 'AB45788541156'),
('freemium', 'FM8548785555'),
('commerce', 'CR8774588644');

-- suppliers
insert into suppliers(name, email, license_tax_registry) values
('John Doe', 'john.doe@gmail.com', 'AB45788541156'),
('Sam Simple', 'sam.simple@gmail.com', 'AB45788541156'),
('Steve Grain', 'steve.grain@gmail.com', 'FM8548785555'),
('Gen Ant', 'gen.ant@gmail.com', 'CR8774588644'),
('Tim Tom', 'tim.tom@gmail.com', 'CR8774588644');

-- create function for getting data from bounded tables
CREATE OR REPLACE FUNCTION get_id_from_table(element_number integer, table_name regclass)
RETURNS uuid AS $$
DECLARE result_id uuid;
BEGIN
    EXECUTE format('SELECT (SELECT id FROM %s LIMIT 1 OFFSET $1)::uuid', table_name)
    INTO result_id
    USING element_number;
    RETURN result_id;
END;
$$ LANGUAGE plpgsql IMMUTABLE;


-- products
insert into products(vendor_code, name, description, availability, price, supplier_id) values
('V157898556', 'Laptop', 'Some powerful laptop', true, 15547.15,
(SELECT * FROM get_id_from_table(0, 'suppliers'))),
('R178885426', 'Personal Computer', 'Some powerful PC', true, 10854.15,
(SELECT * FROM get_id_from_table(1, 'suppliers')));

insert into products(vendor_code, name, description, availability, price, supplier_id) values
('SP58898556', 'Hoover', 'Some good hoover', true, 6547.0,
(SELECT get_id_from_table(2, 'suppliers'))),
('RR78954726', 'Fridge', 'Some cheap fridge', true, 12854.55,
(SELECT get_id_from_table(2, 'suppliers')));

insert into products(vendor_code, name, description, availability, price, supplier_id) values
('TT85471169', 'Juice', 'Orange juice', true, 50.5,
(SELECT get_id_from_table(3, 'suppliers'))),
('BB98456638', 'Bread', 'wheat bread', true, 25.7,
(SELECT get_id_from_table(3, 'suppliers')));

-- checks
insert into checks(vendor_code, quantity) values
('SP58898556', 3),
('BB98456638', 4),
('TT85471169', 1),
('RR78954726', 2);


-- orders
insert into orders(client_id, check_id, order_date) values
((SELECT get_id_from_table(0, 'clients')),
 (SELECT get_id_from_table(0, 'checks')),
  NOW()::timestamp);

insert into orders(client_id, check_id, order_date) values
((SELECT get_id_from_table(1, 'clients')),
 (SELECT get_id_from_table(1, 'checks')),
 NOW()::timestamp);

insert into orders(client_id, check_id, order_date) values
((SELECT get_id_from_table(2, 'clients')),
 (SELECT get_id_from_table(2, 'checks')),
 NOW()::timestamp);

-- categories_products
insert into categories_products(category_id, product_id) values
((SELECT get_id_from_table(0, 'categories')), (SELECT get_id_from_table(0, 'products'))),
((SELECT get_id_from_table(0, 'categories')), (SELECT get_id_from_table(1, 'products'))),
((SELECT get_id_from_table(1, 'categories')), (SELECT get_id_from_table(1, 'products'))),
((SELECT get_id_from_table(4, 'categories')), (SELECT get_id_from_table(2, 'products')));

