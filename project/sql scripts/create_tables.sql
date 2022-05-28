use cars;

create table `user`(
user_id integer primary key not null,
name nvarchar(20) not null,
surname nvarchar(20) not null,
role nvarchar(15) not null
login nvarchar(20) not null
password nvarchar(20) not null
);

 create table `car`(
 car_id integer primary key not null,
 brand nvarchar(20) not null,
 model nvarchar(20) not null,
 available boolean not null,
 day_price float not null
 );
 
 create table `order`(
 order_id integer primary key not null,
 user_id integer not null references `user`,
 car_id integer not null references `car`,
 passport nvarchar(9) not null,
 date_start date not null,
 term integer not null,
 status nvarchar(15),
 reject_reason nvarchar(30),
 cost float NOT NULL
 );
 
 create table `refund`(
 refund_id integer primary key not null,
 order_id integer not null references `order`,
 damage nvarchar(50),
 repair float
 )
 