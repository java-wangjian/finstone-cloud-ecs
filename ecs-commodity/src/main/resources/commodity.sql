create table commodity
(
  id char(32) not null,
  commodity_name varchar(50) null,
  commodity_stock int null comment '库存',
  commodity_price double not null comment '价格',
  create_date datetime not null,
  create_user char(32) not null,
  update_date datetime not null,
  update_user char(32) not null,
  constraint commodity_id_uindex unique (id)
)
comment '商品';
alter table commodity add primary key (id);