-- 创建数据库
create database LabBookSysJava default character set utf8 collate utf8_general_ci;
-- 使用数据库
use LabBookSysJava;
-- 创建用户表
create table users(
    users_id varchar(20) primary key,
    users_pwd varchar(20) not null,
    users_role varchar(10) not null,
    users_token longtext not null
);

-- 存储轮播图
create table swiper(
    id int primary key auto_increment,
    imgUrl varchar(50) not null,
    detail varchar(50)
);

insert into swiper(imgUrl, detail)values(
    '/img/swiper1.png',
    '钟表广告'
),(
    '/img/swiper2.png',
    '湖工相亲'
),(
    '/img/swiper3.png',
    '夏季新品'
),(
    '/img/swiper4.png',
    '瑜伽宣传'
),(
    '/img/swiper5.png',
    '护肤品'
);

-- 存储标题
create table cat(
    cat_id int primary key auto_increment,
    role varchar(10) not null,
    first_title varchar(20) not null,
    second_title varchar(20) not null
);

insert into cat(role, first_title, second_title)values(
    "管理员", "个人信息管理", "查看个人信息，修改个人信息"
),(
    "管理员", "实验室管理", "查看实验室信息，修改实验室信息"
),(
    "管理员", "预约管理", "查看预约记录，审核预约请求"
),(
    "管理员", "教师管理", "查看教师信息，修改教师信息"
),(
    "管理员", "班级管理", "查看班级信息，修改班级信息"
),(
    "教师", "个人信息管理", "查看个人信息，修改个人信息"
),(
    "教师", "查看实验室", "查看预约实验室"
),(
    "教师", "进行预约", "查看已预约记录，修改预约请求"
),(
    "教师", "查看班级", "查看班级信息"
),(
    "班长", "班级信息管理", "查看班级信息，修改班级信息"
),(
    "班长", "查看实验室", "查看实验室信息"
),(
    "班长", "查看预约", "查看预约信息"
);


-- 管理员信息表
create table manager_msg(
    id int primary key auto_increment comment '自增主键',
    mtId varchar(20) not null comment '工号' unique,
    mtName varchar(20) not null comment '姓名' unique,
    mtPhone varchar(20) not null comment '电话',
    mtEmail varchar(20) not null comment '邮箱',
    mOffice varchar(20) not null comment '办公室',
    mLabs varchar(20) not null comment '负责的实验室'
);

-- 教师信息表
create table teacher_msg(
    id int primary key auto_increment comment '自增主键',
    mtId varchar(20) not null comment '工号' unique,
    mtName varchar(20) not null comment '姓名' unique,
    tProject varchar(20) not null comment '任教课程',
    tClasses varchar(20) not null comment '任教班级',
    tcDept varchar(20) not null comment '所在学院',
    mtPhone varchar(20) not null comment '电话',
    mtEmail varchar(20) not null comment '邮箱'
);

-- 班级信息表
create table class_msg(
    id int primary key auto_increment comment '自增主键',
    cId varchar(20) not null comment '工号' unique,
    cName varchar(20) not null comment '班级名' unique,
    cNum int not null comment '班级人数',
    cMonitor varchar(20) not null comment '班长姓名',
    cProfession varchar(20) not null comment '专业',
    tcDept varchar(20) not null comment '学院'
);

-- 实验室信息表
create table lab(
    id int primary key auto_increment comment '自增主键',
    labs_id varchar(20) not null unique comment '实验室号',
    labs_num int not null comment '实验室容纳人数',
    labs_equipment varchar(40) not null comment '实验室设施',
    labs_status varchar(15) not null comment '实验室状态',
    manager_id varchar(20) not null comment '管理员id'
);

-- 创建预约信息表
create table book(
    books_id int primary key auto_increment comment '自增主键',
    labs_id varchar(20) not null comment '预约实验室号',
    books_time varchar(30) not null comment '预约时间',
    teachers_name varchar(30) comment '预约老师姓名',
    classes_name varchar(30) comment '预约班级名称',
    project varchar(20) comment '预约课程',
    books_status varchar(15) comment '预约状态',
    create_time timestamp not null default CURRENT_TIMESTAMP() comment '预约创建时间',
    success_time timestamp not null default '20210101000000' comment '预约成功时间',
    unique index(labs_id, books_time)
);

-- 初始化测试数据
insert into users values (
    'M2101', 'M21012101', '管理员', 'test no token'
), (
    'T2101', 'T21012101', '教师', 'test no token'
), (
    'S2101', 'S21012101', '班长', 'test no token'
), (
    'S2102', 'S21022102', '班长', 'test no token'
);

insert into manager_msg(mtid, mtname, mtphone, mtemail, moffice, mlabs)
values('M2101', '李大牛', '19967294656', '123@qq.com', 'E111', 'E511 E513');

insert into lab(labs_id, labs_num, labs_equipment, labs_status, manager_id)
value('E511', 100, '若干电脑', '可预约', 'M2101'),(
      'E513', 105, '若干电脑', '可预约', 'M2101'
    );

insert into teacher_msg(mtId, mtName, tProject, tClasses, tcDept, mtPhone, mtEmail)
values('T2101', '王老黑', 'JavaWeb', '软件工程1班 软件工程2班', '计算机与通信学院','19964781245', '456@qq.com');

insert into class_msg(cId, cName, cNum, cMonitor, cProfession, tcDept)
values('S2101', '软件工程1班', 47, '王大牛', '软件工程', '计算机与通信学院'),
      ('S2102', '软件工程2班', 45, '李明', '软件工程', '计算机与通信学院');

