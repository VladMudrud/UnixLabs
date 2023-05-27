create table if not exists suppliers (
    id uuid default uuid_generate_v4(),
    name varchar not null,
    email varchar not null,
    license_tax_registry varchar not null,
    primary key (id),
    foreign key(license_tax_registry) references licenses(tax_registry)
);