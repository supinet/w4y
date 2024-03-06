create table sales_order_item (
    id bigint not null auto_increment,
    sales_order_id bigint not null,
    sku varchar(255) not null,
    price bigint not null,
    quantity bigint not null,
    primary key(id),
    constraint fk_order_item_sales_order_id foreign key(sales_order_id) references sales_order(id)
);