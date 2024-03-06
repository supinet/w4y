create table inventory (
    id bigint not null auto_increment,
    sku varchar(255) not null,
    quantity bigint not null,
    primary key(id)
);