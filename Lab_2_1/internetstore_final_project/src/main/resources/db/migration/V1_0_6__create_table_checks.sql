create table if not exists checks(
    id uuid default uuid_generate_v4(),
    vendor_code varchar not null,
    quantity integer not null,
    primary key (id),
    foreign key(vendor_code) references products(vendor_code)
);
