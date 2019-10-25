create table if not exists user
(
  id char(32) not null,
  username varchar(20) not null comment '用户名',
  nickname varchar(20) not null comment '用户昵称',
  password varchar(50) not null comment '用户密码',
  money double null comment '总金额',
  create_date datetime not null comment '创建日期',
  create_user char(32) not null comment '创建人',
  update_date datetime not null comment '更新日期',
  update_user char(32) not null comment '更新人',
  constraint user_id_uindex unique (id)
)
comment '用户表';
alter table user add primary key (id);