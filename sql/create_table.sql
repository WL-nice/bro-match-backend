create table tag
(
    id           bigint auto_increment comment 'id' primary key,
    tagName     varchar(256)                       null comment '标签名',
    userId      bigint                             null comment '用户id',
    parentId    bigint                              null comment '父标签id',
    isParent     tinyint                            null comment '0-不是父标签 1-是父标签',
    createTime   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime   datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '修改时间',
    isDelete     int      default 0                 not null comment '是否删除'
)
    comment '标签';

create table user
(
    id           bigint auto_increment comment '用户id'
        primary key,
    username     varchar(256)                       null comment '用户名',
    userAccount  varchar(256)                       null comment '账号',
    avatarUrl    varchar(1024)                      null comment '头像',
    gender       tinyint                            null comment '性别',
    userPassword varchar(512)                       not null comment '密码',
    phone        varchar(128)                       null comment '手机号',
    email        varchar(512)                       null comment '邮箱',
    userStatus   int      default 0                 null comment '用户状态',
    createTime   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime   datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '修改时间',
    isDelete     int      default 0                 not null comment '是否删除',
    userRole     int      default 0                 not null comment '用户身份',
    acptCode     varchar(512)                       null comment '校验编号',
    tags         varchar(1024)                      null comment '标签列表 [json]'
)
  comment '用户';