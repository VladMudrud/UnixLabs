create table if not exists products (
    id uuid default uuid_generate_v4(),
    vendor_code varchar unique not null,
    name varchar not null,
    description varchar,
    availability boolean DEFAULT FALSE,
    price numeric not null,
    supplier_id uuid not null,
    primary key (id),
    foreign key(supplier_id) references suppliers(id)
);