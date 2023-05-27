create table if not exists orders (
    client_id uuid not null,
    check_id uuid not null,
    order_date timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    primary key (client_id, check_id)
 );