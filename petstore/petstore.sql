create table Category( 	# 类型
	category_id int primary key auto_increment,
	category_name varchar(50)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;
insert into Category(category_name) values
('狗'),('猫'),('鸟'),('鱼')
select*from Category;

create table Tag(			# 标签
	tag_id int primary key auto_increment,
	tag_name varchar(50)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;
insert into Tag(tag_name) values
('可爱'),('讨人喜欢'),('凶猛');

create table Pet(
	pet_id int primary key auto_increment,
	category_id int references Category(category_id),
	pet_name varchar(50),
	pet_photo varchar(100),
	tag_id int references Tag(tag_id),
	pet_status enum('可用','待定','已售出')
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;
insert into Pet(category_id,pet_name,pet_photo,tag_id,pet_status) values
(1,'旺财','1.jpg',1,'可用'),
(1,'大黄','2.jpg',1,'可用'),
(1,'啸天','3.jpg',3,'待定'),
(2,'喵喵','4.jpg',2,'可用'),
(3,'泡泡','5.jpg',3,'已售出')
select*from Pet;

create table `Order`(
	order_id int primary key auto_increment,
	pet_id int references Pet(pet_id),
	order_quantity int,	# 数量
	order_shipDate varchar(100),
	order_status enum('放置','批准','交付'),
	order_complete tinyint(1) default false
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;
insert into `Order`(pet_id,order_quantity,order_shipDate,order_status,order_complete) values
(1,1,'2017-10-09','批准',false),
(2,1,'2017-10-10','放置',false),
(3,1,'2017-11-10','放置',false);
select*from `Order`;

create table `User`(
	user_id int primary key auto_increment,
	user_name varchar(50),
	user_first_name varchar(50),
	user_last_name varchar(50),
	user_email varchar(50),
	user_password varchar(50),
	user_phone varchar(20),
	user_status int
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;
insert into `User`(user_name,user_first_name,user_last_name,user_email,user_password,user_phone,user_status) values
('郭富城','富城','郭','2934293423@qq.com','123456','15093482349',0),
('刘德华','德华','刘','9234213623@qq.com','123456','13393482349',0);
select*from `User`;
create table ApiResponse(
	apiResponse_code int primary key auto_increment,
	apiResponse_type varchar(50),
	apiResponse_message varchar(50)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;
insert into ApiResponse(apiResponse_type,apiResponse_message) values
('001','001');