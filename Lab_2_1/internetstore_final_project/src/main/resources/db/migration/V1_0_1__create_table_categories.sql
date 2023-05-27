create extension if not exists "uuid-ossp";

create table if not exists categories (
    id uuid default uuid_generate_v4(),
    name varchar not null,
    primary key (id)
);