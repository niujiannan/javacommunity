# 项目分析

## 需求分析
1. 登录和注册的功能，密码使用MD5加密
2. 用户登录后可以选择上传头像
3. 用户可以发布问题并可以对已发布的问题进行更新
4. 用户发布问题时可上传对应问题的图片，可以选择问题的标签
5. 游客可以查看发布的问题，但不能回复问题和查看发布问题的作者信息
6. 当有人浏览问题，该问题浏览数+1，有人评语评论数+1，也可以对问题点赞
7. 用户可以收到对发布问题的评论并可回复该评论者
8. 当游客点击评论，会出现弹出框，让游客选择是否登录

## 所用到的技术

### 核心技术
1. 后端: SpringBoot + SpringMVC + Thymeleaf + maven + MyBatis + junit
2. 前端: Bootstrap + layui + jQuery + Ajax + JSON
   
### 工具类
1. logback: 日志 
2. lombok: 自动生成get/set方法
3. spring-boot-devtools: 热布署

## 数据库的设计
+ 数据库名: javacommunity
  
+ 用户表
```sql
create table users(
    id int(11) primary key auto_increment comment '主键',
    nick_name varchar(30) not null comment '昵称',
    password varchar(30) not null comment '密码',
    email varchar(30) not null comment '邮箱',
    head_portrait_url varchar(1000) comment '头像',
    create_time bigint
);
```

+ 问题表
```sql
create table question(
    id int(11) primary key auto_increment comment '主键',
    title varchar(50) not null comment '问题标题',
    content varchar(2000) not null comment '问题内容',
    browse_number int(10) default 0 comment '浏览数', 
    comment_number int(10) default 0 comment '评论数',
    like_number int(10) default 0 comment '点赞数',
    publisher int(11) not null comment '发布者',
    publish_time bigint comment '发布时间',
    update_time bigint comment '修改时间'
);
```

+ 回复表
```sql
create table comment
(
	id int(11) auto_increment,
	content varchar(1000) comment '评论内容',
	parent_id int(11) not null comment '父类id',
	type int(11) null comment '父类类型',
	commentator int(11) null comment '评论人的id',
	create_time bigint null comment '创建时间',
	update_time bigint null comment '更新时间',
	like_number int(11) default 0 null comment '点赞数',
	constraint comment_pk
		primary key (id)
);

```
...待续
