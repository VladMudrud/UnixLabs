create table if not exists categories_products (
    category_id uuid not null,
    product_id uuid not null,
    primary key (category_id, product_id)
 );