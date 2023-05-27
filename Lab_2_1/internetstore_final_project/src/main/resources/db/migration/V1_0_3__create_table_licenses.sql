create table if not exists licenses (
    tax_registry varchar unique not null,
    name varchar not null,
    primary key (tax_registry)
);