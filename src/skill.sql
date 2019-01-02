SET NAMES uft8;
set foreign_key_checks = 0;
drop table if exists `skill_user`;
create table `skill_user` (
  `id` int(11) not null auto_increment comment 'user table id',
  `username` varchar(50) not null comment '用户名',
  `password` varchar(50) not null comment '用户密码，md5加密',
  `create_time` datetime not null comment '创建时间',
  `update_time` datetime not null comment '更新时间',
  primary key (`id`),
  unique key `user_name_unique` (`username`) using btree
) ENGINE=innoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


drop table if exists `allSkill`;
create table `allSkill` (
  `id` int(11) not null auto_increment comment 'skill id',
  `user_id` int(11) not null comment '用户id',
  `skill_name` varchar(50) default null comment '技能名',
  `grade` int(11) default null comment '技能等级',
  `create_time` datetime default null comment '创建时间',
  `update_time` datetime default null comment '更新时间',
  primary key (`id`),
  key `user_id_index` (`user_id`) using btree
) ENGINE=innoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;