drop database if exists AlexandriaDB;
create database if not exists AlexandriaDB character set utf8 collate utf8_general_ci;
use AlexandriaDB;
create table user_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) unique not null comment "ユーザーID",
password varchar(16) not null comment "パスワード",
last_name varchar(32) not null comment "姓",
first_name varchar(32) not null comment "名",
last_name_kana varchar(32) not null comment "姓カナ",
first_name_kana varchar(32) not null comment "名カナ",
email varchar(32) not null comment "メールアドレス",
birthday varchar(10) not null comment "生年月日",
head_shots varchar(100) comment "顔写真",
status tinyint not null default 0 comment "ステータス",
login_Flg tinyint not null default 0 comment "ログインフラグ",
point int not null default 0 comment "ポイント",
insert_date datetime not null comment "登録日",
update_date datetime comment "更新日"
);

insert into user_info values (1,"sample","sample","hida","takaaki","ヒダ","タカアキ","sample@sample.jp","1993-11-25",null,0,0,0,now(),null);

create table address_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) not null comment "ユーザーID",
last_name varchar(32) not null comment "姓",
first_name varchar(32) not null comment "名",
last_name_kana varchar(32) not null comment "姓カナ",
first_name_kana varchar(32) not null comment "名カナ",
email varchar(32) not null comment "メールアドレス",
tel_number varchar(13) not null comment "電話番号",
postal varchar(8) not null comment "郵便番号",
address varchar(50) not null comment "住所",
insert_date datetime not null comment "登録日",
update_date datetime comment "更新日"
);

insert into address_info values(1,"sample","田中","太郎","タナカ","タロウ","sample@sample.jp","080-3244-3433","343-8843","東京都新宿区西新宿2-8-1",now(),now());
insert into address_info values(2,"sample","田中","太郎","タナカ","タロウ","sample@sample.jp","080-3244-3433","123-7543","神奈川県新宿区西新宿2-8-1",now(),now());

drop table if exists product_info;
create table product_info(
id int primary key not null auto_increment comment "ID",
product_id int unique not null comment "商品ID",
product_name varchar(100) unique not null comment "商品名",
product_short_description varchar(100) not null comment "商品簡易説明",
product_description varchar(255) not null comment "商品詳細説明",
category_id int not null comment "カテゴリID",
price int not null comment "価格",
product_image varchar(100) comment "画像ファイル",
release_company varchar(50) not null comment "発売会社",
release_date datetime not null comment "発売年月",
rank int not null comment "購入回数",
status tinyint not null default 0 comment "ステータス",
insert_date datetime not null comment "登録日",
update_date datetime comment "更新日"
);
insert into product_info values (1,1,"sample1","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",1,650,"./img/book.jpg","sample文庫",now(),1,0,now(),now()),
(2,2,"sample2","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",1,1208,"./img/book.jpg","sample文庫",now(),2,0,now(),now()),
(3,3,"sample3","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",1,1111,"./img/book.jpg","sample文庫",now(),3,0,now(),now()),
(4,4,"sample4","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",1,2343,"./img/book.jpg","sample文庫",now(),4,0,now(),now()),
(5,5,"sample5","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",1,648,"./img/book.jpg","sample文庫",now(),5,0,now(),now()),
(6,6,"sample6","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",1,634,"./img/book.jpg","sample文庫",now(),6,0,now(),now()),
(7,7,"sample7","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",1,4348,"./img/book.jpg","sample文庫",now(),7,0,now(),now()),
(8,8,"sample8","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",1,754,"./img/book.jpg","sample文庫",now(),8,0,now(),now()),
(9,9,"sample9","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",1,9453,"./img/book.jpg","sample文庫",now(),9,0,now(),now()),
(10,10,"sample10","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",1,353,"./img/book.jpg","sample文庫",now(),10,0,now(),now()),
(11,11,"sample11","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",2,650,"./img/book.jpg","sample文庫",now(),16,0,now(),now()),
(12,12,"sample12","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",2,1208,"./img/book.jpg","sample文庫",now(),2,0,now(),now()),
(13,13,"sample13","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",2,1111,"./img/book.jpg","sample文庫",now(),6,0,now(),now()),
(14,14,"sample14","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",2,2343,"./img/book.jpg","sample文庫",now(),3,0,now(),now()),
(15,15,"sample15","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",2,648,"./img/book.jpg","sample文庫",now(),9,0,now(),now()),
(16,16,"sample16","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",2,634,"./img/book.jpg","sample文庫",now(),4,0,now(),now()),
(17,17,"sample17","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",2,4348,"./img/book.jpg","sample文庫",now(),1,0,now(),now()),
(18,18,"sample18","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",2,754,"./img/book.jpg","sample文庫",now(),4,0,now(),now()),
(19,19,"sample19","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",2,9453,"./img/book.jpg","sample文庫",now(),9,0,now(),now()),
(20,20,"sample20","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",2,353,"./img/book.jpg","sample文庫",now(),10,0,now(),now()),
(21,21,"sample21","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",3,650,"./img/book.jpg","sample文庫",now(),1,0,now(),now()),
(22,22,"sample22","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",3,1208,"./img/book.jpg","sample文庫",now(),2,0,now(),now()),
(23,23,"sample23","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",3,1111,"./img/book.jpg","sample文庫",now(),3,0,now(),now()),
(24,24,"sample24","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",3,2343,"./img/book.jpg","sample文庫",now(),4,0,now(),now()),
(25,25,"sample25","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",3,648,"./img/book.jpg","sample文庫",now(),5,0,now(),now()),
(26,26,"sample26","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",3,634,"./img/book.jpg","sample文庫",now(),6,0,now(),now()),
(27,27,"sample27","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",3,4348,"./img/book.jpg","sample文庫",now(),7,0,now(),now()),
(28,28,"sample28","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",3,754,"./img/book.jpg","sample文庫",now(),8,0,now(),now()),
(29,29,"sample29","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",3,9453,"./img/book.jpg","sample文庫",now(),9,0,now(),now()),
(30,30,"sample30","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",3,353,"./img/book.jpg","sample文庫",now(),10,0,now(),now()),
(31,31,"sample31","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",4,650,"./img/book.jpg","sample文庫",now(),1,0,now(),now()),
(32,32,"sample32","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",4,1208,"./img/book.jpg","sample文庫",now(),2,0,now(),now()),
(33,33,"sample33","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",4,1111,"./img/book.jpg","sample文庫",now(),3,0,now(),now()),
(34,34,"sample34","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",4,2343,"./img/book.jpg","sample文庫",now(),4,0,now(),now()),
(35,35,"sample35","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",4,648,"./img/book.jpg","sample文庫",now(),5,0,now(),now()),
(36,36,"sample36","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",4,634,"./img/book.jpg","sample文庫",now(),6,0,now(),now()),
(37,37,"sample37","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",4,4348,"./img/book.jpg","sample文庫",now(),7,0,now(),now()),
(38,38,"sample38","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",4,754,"./img/book.jpg","sample文庫",now(),8,0,now(),now()),
(39,39,"sample39","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",4,9453,"./img/book.jpg","sample文庫",now(),9,0,now(),now()),
(40,40,"sample40","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",4,353,"./img/book.jpg","sample文庫",now(),10,0,now(),now()),
(41,41,"sample41","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",5,650,"./img/book.jpg","sample文庫",now(),1,0,now(),now()),
(42,42,"sample42","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",5,1208,"./img/book.jpg","sample文庫",now(),2,0,now(),now()),
(43,43,"sample43","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",5,1111,"./img/book.jpg","sample文庫",now(),3,0,now(),now()),
(44,44,"sample44","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",5,2343,"./img/book.jpg","sample文庫",now(),4,0,now(),now()),
(45,45,"sample45","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",5,648,"./img/book.jpg","sample文庫",now(),5,0,now(),now()),
(46,46,"sample46","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",5,634,"./img/book.jpg","sample文庫",now(),6,0,now(),now()),
(47,47,"sample47","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",5,4348,"./img/book.jpg","sample文庫",now(),7,0,now(),now()),
(48,48,"sample48","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",5,754,"./img/book.jpg","sample文庫",now(),8,0,now(),now()),
(49,49,"sample49","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",5,9453,"./img/book.jpg","sample文庫",now(),9,0,now(),now()),
(50,50,"sample50","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",5,353,"./img/book.jpg","sample文庫",now(),10,0,now(),now()),
(51,51,"sample51","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",6,650,"./img/book.jpg","sample文庫",now(),1,0,now(),now()),
(52,52,"sample52","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",6,1208,"./img/book.jpg","sample文庫",now(),2,0,now(),now()),
(53,53,"sample53","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",6,1111,"./img/book.jpg","sample文庫",now(),3,0,now(),now()),
(54,54,"sample54","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",6,2343,"./img/book.jpg","sample文庫",now(),4,0,now(),now()),
(55,55,"sample55","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",6,648,"./img/book.jpg","sample文庫",now(),5,0,now(),now()),
(56,56,"sample56","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",6,634,"./img/book.jpg","sample文庫",now(),6,0,now(),now()),
(57,57,"sample57","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",6,4348,"./img/book.jpg","sample文庫",now(),7,0,now(),now()),
(58,58,"sample58","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",6,754,"./img/book.jpg","sample文庫",now(),8,0,now(),now()),
(59,59,"sample59","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",6,9453,"./img/book.jpg","sample文庫",now(),9,0,now(),now()),
(60,60,"sample60","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",6,353,"./img/book.jpg","sample文庫",now(),10,0,now(),now()),
(61,61,"sample61","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",7,650,"./img/book.jpg","sample文庫",now(),1,0,now(),now()),
(62,62,"sample62","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",7,1208,"./img/book.jpg","sample文庫",now(),2,0,now(),now()),
(63,63,"sample63","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",7,1111,"./img/book.jpg","sample文庫",now(),3,0,now(),now()),
(64,64,"sample64","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",7,2343,"./img/book.jpg","sample文庫",now(),4,0,now(),now()),
(65,65,"sample65","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",7,648,"./img/book.jpg","sample文庫",now(),5,0,now(),now()),
(66,66,"sample66","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",7,634,"./img/book.jpg","sample文庫",now(),6,0,now(),now()),
(67,67,"sample67","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",7,4348,"./img/book.jpg","sample文庫",now(),7,0,now(),now()),
(68,68,"sample68","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",7,754,"./img/book.jpg","sample文庫",now(),8,0,now(),now()),
(69,69,"sample69","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",7,9453,"./img/book.jpg","sample文庫",now(),9,0,now(),now()),
(70,70,"sample70","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",7,353,"./img/book.jpg","sample文庫",now(),10,0,now(),now()),
(71,71,"sample71","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",8,650,"./img/book.jpg","sample文庫",now(),1,0,now(),now()),
(72,72,"sample72","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",8,1208,"./img/book.jpg","sample文庫",now(),2,0,now(),now()),
(73,73,"sample73","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",8,1111,"./img/book.jpg","sample文庫",now(),3,0,now(),now()),
(74,74,"sample74","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",8,2343,"./img/book.jpg","sample文庫",now(),4,0,now(),now()),
(75,75,"sample75","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",8,648,"./img/book.jpg","sample文庫",now(),5,0,now(),now()),
(76,76,"sample76","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",8,634,"./img/book.jpg","sample文庫",now(),6,0,now(),now()),
(77,77,"sample77","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",8,4348,"./img/book.jpg","sample文庫",now(),7,0,now(),now()),
(78,78,"sample78","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",8,754,"./img/book.jpg","sample文庫",now(),8,0,now(),now()),
(79,79,"sample79","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",8,9453,"./img/book.jpg","sample文庫",now(),9,0,now(),now()),
(80,80,"sample80","sample sample sample sample sample sample sample","sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample sample",8,353,"./img/book.jpg","sample文庫",now(),10,0,now(),now());

drop table if exists review_info;
create table review_info(
id int primary key not null auto_increment comment "ID",
product_id int not null comment "商品ID",
user_id varchar(16) not null comment "ユーザーID",
review_title varchar(30) not null comment "レビュータイトル",
review_text varchar(255) not null comment "レビュー本文",
star int not null comment "評価",
reference_count int not null default 0 comment "評価数",
status tinyint not null default 0 comment "ステータス",
insert_date datetime not null comment "登録日",
update_date datetime comment "更新日"
);
insert into review_info values (1,1,"sample","執筆に9年！？","これはあかん。電車内で涙が垂れた。最近、涙もろくてね。早くに夫をなくしてギフとともに住み続ける女性。といってもお涙頂戴の話では全然なくて、どちらかと言うとコミカルな感じです。なんとなく肩の力が緩む感じの一冊ですね。",3,0,0,now(),now());
insert into review_info values (2,1,"taro","器用に生きられない方へ","もやもやした女性の気持ちが細かく描かれて、まわりの優しい不器用な人たちにも共感。",2,0,0,now(),now());
insert into review_info values (3,1,"hanako","積み重なって大きな表現になる","木皿さん、独特のテイストが好きです。積み重なって大きなものが表現されていく。この方々にしかだせない味を持っています。",5,0,0,now(),now());

create table master_category(
id int primary key not null comment "ID",
category_id int not null unique comment "カテゴリID",
category_name varchar(20) not null unique comment "カテゴリ名",
category_description varchar(100) comment "カテゴリ詳細",
insert_date datetime not null comment "登録日",
update_date datetime comment "更新日"
);

insert into master_category values (1,1,"文学","文学評論です",now(), null),
(2,2,"コミック","コミックです",now(), null),
(3,3,"趣味","趣味です",now(), null),
(4,4,"資格","資格です",now(), null),
(5,5,"社会","社会です",now(), null),
(6,6,"児童書","児童書です",now(), null),
(7,7,"歴史","歴史です",now(), null),
(8,8,"経済","経済です",now(), null);

create table cart_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) not null comment "ユーザーID",
temp_user_id varchar(16) comment "仮ユーザーID",
product_id int not null comment "商品ID",
product_count int not null comment "商品個数",
price int not null comment "金額",
insert_date datetime not null comment "登録日",
update_date datetime comment "更新日"
);

create table history_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) not null comment "ユーザーID",
product_id int not null comment "商品ID",
product_count int not null comment "個数",
price int not null comment "金額",
address_id int not null comment "宛先情報ID",
insert_date datetime not null comment "登録日",
update_date datetime not null comment "更新日",
foreign key(user_id) references user_info(user_id),
foreign key(product_id) references product_info(product_id)
);