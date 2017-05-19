CREATE DATABASE lol_api;
USE lol_api;
ALTER DATABASE lol_api CHARACTER SET UTF8;
CREATE TABLE t_admin (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	username VARCHAR(255) COMMENT '用户名',
	nickname VARCHAR(255) COMMENT '昵称',
	password VARCHAR(255) COMMENT '密码',
	salt VARCHAR(50) COMMENT '盐值'
)COMMENT '后台管理员表';
INSERT INTO t_admin VALUES('1', 'admin', '超级管理员', 'e45738bf3eabe042f871fbd8c63cd37a', '51carry');
CREATE TABLE t_area (
	id INT COMMENT '大区ID',
	isp VARCHAR(255) COMMENT '互联网服务提供商',
	name VARCHAR(255) COMMENT '大区名称'
)COMMENT '游戏大区表';
INSERT INTO t_area VALUES('1', '电信一', '艾欧尼亚');
INSERT INTO t_area VALUES('2', '网通一', '比尔吉沃特');
INSERT INTO t_area VALUES('3', '电信二', '祖安');
INSERT INTO t_area VALUES('4', '电信三', '诺克萨斯');
INSERT INTO t_area VALUES('5', '电信四', '班德尔城');
INSERT INTO t_area VALUES('6', '网通二', '德玛西亚');
INSERT INTO t_area VALUES('7', '电信五', '皮尔特沃夫');
INSERT INTO t_area VALUES('8', '电信六', '战争学院');
INSERT INTO t_area VALUES('9', '网通三', '弗雷尔卓德');
INSERT INTO t_area VALUES('10', '电信七', '巨神峰');
INSERT INTO t_area VALUES('11', '电信八', '雷瑟守备');
INSERT INTO t_area VALUES('12', '网通四', '无畏先锋');
INSERT INTO t_area VALUES('13', '电信九', '裁决之地');
INSERT INTO t_area VALUES('14', '电信十', '黑色玫瑰');
INSERT INTO t_area VALUES('15', '电信十一', '暗影岛');
INSERT INTO t_area VALUES('16', '网通五', '恕瑞玛');
INSERT INTO t_area VALUES('17', '电信十二', '钢铁烈阳');
INSERT INTO t_area VALUES('18', '电信十三', '水晶之痕');
INSERT INTO t_area VALUES('19', '电信十四', '均衡教派');
INSERT INTO t_area VALUES('20', '网通六', '扭曲丛林');
INSERT INTO t_area VALUES('21', '教育网', '教育网专区');
INSERT INTO t_area VALUES('22', '电信十五', '影流');
INSERT INTO t_area VALUES('23', '电信十六', '守望之海');
INSERT INTO t_area VALUES('24', '电信十七', '征服之海');
INSERT INTO t_area VALUES('25', '电信十八', '卡拉曼达');
INSERT INTO t_area VALUES('26', '网通七', '巨龙之巢');
INSERT INTO t_area VALUES('27', '电信十九', '皮城警备');
INSERT INTO t_area VALUES('30', '全网络大区一' , '男爵领域');

CREATE TABLE t_champion (
	id INT PRIMARY KEY COMMENT '英雄ID',
	ename VARCHAR(255) COMMENT '英文名',
	title VARCHAR(255) COMMENT '英雄名称',
	cname VARCHAR(255) COMMENT '中文名',
	rmb INT COMMENT '英雄点卷价格',
	gold INT COMMENT '英雄金币价格',
	tags VARCHAR(255) COMMENT '英雄标签',
	free TINYINT(1) COMMENT '是否周免'
)COMMENT '英雄表';

CREATE TABLE t_info (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	attack INT COMMENT '攻击值',
	defense INT COMMENT '防御值',
	difficulty INT COMMENT '难度值',
	magic INT COMMENT '魔法值',
	champion_id INT COMMENT '英雄ID',
	CONSTRAINT FOREIGN KEY (champion_id) REFERENCES t_champion(id) ON DELETE CASCADE ON UPDATE CASCADE
)COMMENT '英雄属性表';

CREATE TABLE t_spell (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	spell_id VARCHAR(255) COMMENT '技能ID',
	spell_key VARCHAR(255) COMMENT '技能键',
	name VARCHAR(255) COMMENT '技能名称',
	description TEXT COMMENT '技能描述',
	image VARCHAR(255) COMMENT '技能图标',
	champion_id INT COMMENT '英雄ID',
	CONSTRAINT FOREIGN KEY (champion_id) REFERENCES t_champion(id) ON DELETE CASCADE ON UPDATE CASCADE
)COMMENT '英雄技能表';

CREATE TABLE t_skin (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	skin_id VARCHAR(255) COMMENT '皮肤ID',
	name VARCHAR(255) COMMENT '皮肤名字',
	num INT COMMENT '序号',
	display_URL VARCHAR(255) COMMENT '皮肤对应的腾讯视频网页',
	source VARCHAR(255) COMMENT '皮肤对应的Flash视频',
	champion_id INT COMMENT '英雄ID',
	CONSTRAINT FOREIGN KEY (champion_id) REFERENCES t_champion(id) ON DELETE CASCADE ON UPDATE CASCADE
)COMMENT '英雄皮肤表';

CREATE TABLE t_tier (
	tier INT COMMENT '等级',
	queue INT COMMENT '级别',
	title VARCHAR(255) COMMENT '相对应的段位信息'
)COMMENT '段位表';
INSERT INTO t_tier VALUES('5', '0', '青铜Ⅰ');
INSERT INTO t_tier VALUES('5', '1', '青铜Ⅱ');
INSERT INTO t_tier VALUES('5', '2', '青铜Ⅲ');
INSERT INTO t_tier VALUES('5', '3', '青铜Ⅳ');
INSERT INTO t_tier VALUES('5', '4', '青铜Ⅴ');
INSERT INTO t_tier VALUES('4', '0', '白银Ⅰ');
INSERT INTO t_tier VALUES('4', '1', '白银Ⅱ');
INSERT INTO t_tier VALUES('4', '2', '白银Ⅲ');
INSERT INTO t_tier VALUES('4', '3', '白银Ⅳ');
INSERT INTO t_tier VALUES('4', '4', '白银Ⅴ');
INSERT INTO t_tier VALUES('3', '0', '黄金Ⅰ');
INSERT INTO t_tier VALUES('3', '1', '黄金Ⅱ');
INSERT INTO t_tier VALUES('3', '2', '黄金Ⅲ');
INSERT INTO t_tier VALUES('3', '3', '黄金Ⅳ');
INSERT INTO t_tier VALUES('3', '4', '黄金Ⅴ');
INSERT INTO t_tier VALUES('2', '0', '铂金Ⅰ');
INSERT INTO t_tier VALUES('2', '1', '铂金Ⅱ');
INSERT INTO t_tier VALUES('2', '2', '铂金Ⅲ');
INSERT INTO t_tier VALUES('2', '3', '铂金Ⅳ');
INSERT INTO t_tier VALUES('2', '4', '铂金Ⅴ');
INSERT INTO t_tier VALUES('1', '0', '钻石Ⅰ');
INSERT INTO t_tier VALUES('1', '1', '钻石Ⅱ');
INSERT INTO t_tier VALUES('1', '2', '钻石Ⅲ');
INSERT INTO t_tier VALUES('1', '3', '钻石Ⅳ');
INSERT INTO t_tier VALUES('1', '4', '钻石Ⅴ');
INSERT INTO t_tier VALUES('0', '0', '最强王者');
INSERT INTO t_tier VALUES('6', '0', '超凡大师');
INSERT INTO t_tier VALUES('255', '255', '无段位');

CREATE TABLE t_item (
	id INT COMMENT '物品ID',
	name VARCHAR(255) COMMENT '物品名字',
	plaintext TEXT COMMENT '物品介绍',
	`from` VARCHAR(255) COMMENT '从什么物品合成',
	`into` VARCHAR(255) COMMENT '可以合成的物品',
	tags VARCHAR(255) COMMENT '标签',
	base_price INT COMMENT '合成价格',
	total_price INT COMMENT '总价',
	sell_price INT COMMENT '售价'
)COMMENT '游戏物品表';

CREATE TABLE t_summoner_spell (
	id VARCHAR(255) COMMENT '技能ID',
	name VARCHAR(255) COMMENT '技能名字',
	description TEXT COMMENT '技能描述',
	image VARCHAR(255) COMMENT '技能图片'
)COMMENT '召唤师技能表';

CREATE TABLE t_count (
	id int(11) PRIMARY KEY AUTO_INCREMENT,
	api_nums INT COMMENT 'API请求总数',
	date VARCHAR(255) COMMENT '记录时间'
)COMMENT 'API请求记录表';