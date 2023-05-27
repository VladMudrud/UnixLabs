create table if not exists clients (
    id uuid default uuid_generate_v4(),
    name varchar not null,
--  timestamp means that date will be converted to milliseconds
--  it store milliseconds count from January 1, 1970 to given data
    birth_date timestamp with time zone,
    email varchar not null,
    password varchar not null,
    primary key (id)
);