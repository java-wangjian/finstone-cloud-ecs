create schema orders_database collate utf8mb4_0900_ai_ci;

create table orders
(
	id char(32) not null,
	order_no varchar(50) not null comment '订单号',
	order_status char default '0' not null comment '0 创建 1 完成 2 删除',
	finish_date datetime null comment '完成日期',
	delete_date datetime null comment '删除日期',
	create_date datetime not null,
	create_user char(32) not null,
	update_date datetime not null,
	update_user char(32) not null,
	amount double not null,
	constraint orders_id_uindex unique (id)
)
comment '订单';
alter table orders add primary key (id);

create table orders_detail
(
	id char(32) not null,
	order_id char(32) null comment '订单id',
	commodity_id char(32) not null comment '商品ID',
	commodity_name varchar(50) not null comment '商品名称',
	price double not null comment '商品价格',
	quantity int not null comment '商品数量',
	amount double null comment '总金额',
	create_date datetime not null,
	create_user char(32) not null,
	update_date datetime not null,
	update_user char(32) null,
	constraint orders_detail_id_uindex unique (id),
	constraint orders_detail_orders_id_fk
		foreign key (orders_id) references orders (id)
			on update cascade on delete cascade
)
comment '订单明细';
alter table orders_detail add primary key (id);