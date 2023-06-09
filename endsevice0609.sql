ENDSERVICE

SELECT end_service_no, ott_no, content_no, end_date
FROM tb_end_service;
where ott_no = #{ott_no}

SELECT end_service_no, ott_no, content_no, end_date
FROM tb_end_service;
where end_date = #{end_date}

INSERT INTO tb_end_service (ott_no, content_no, end_date) VALUES(1, 1, '2023-04-01');
INSERT INTO tb_end_service (ott_no, content_no, end_date) VALUES(2, 2, '2023-05-01');
INSERT INTO tb_end_service (ott_no, content_no, end_date) VALUES(3, 3, '2023-06-01');
INSERT INTO tb_end_service (ott_no, content_no, end_date) VALUES(4, 4, '2023-07-01');
INSERT INTO tb_end_service (ott_no, content_no, end_date) VALUES(4, 4, '2023-07-01');

SELECT *
FROM tb_end_service
where ott_no = 2;

SELECT * FROM tb_end_service
WHERE end_date
BETWEEN '2023-04-01' AND '2023-05-01';

insert into tb_end_service values(1, 1, 2023-04-01);
insert into tb_end_service values(2, 2, 2023-04-02);
insert into tb_end_service values(3, 3, '2023-04-03');
insert into tb_end_service values(4, 4, '2023-04-04');

drop table if exists tb_content_ott;
create table tb_content_ott
(
	content_no			bigint			not null
	,ott_no				bigint			not null
	,constraint content_ott primary key(content_no, ott_no)
);

drop table if exists tb_content;
create table tb_content
(
	content_no			bigint			generated always as identity primary key
	,content_nm			varchar(100)	not null
	,content_info		varchar(10000)	not null
	,content_runtime	int				not null
	,previewUrl			text			not null
	,thumbnail			text			not null
	,age				smallint		not null
	,ott_no				int				not null
	,rating				smallint		
	,country			varchar(50)		not null
);

alter table tb_content add rating smallint;
select * from tb_content;

--tb_content fk
alter table tb_content add constraint fk_ott_content
   foreign key (ott_no) references tb_ott (ott_no) on delete set null;

drop table if exists tb_content_category;
create table tb_content_category
(
	content_no		bigint		not null
	,category_no	smallint	not null
	,constraint content_category_pk primary key (content_no, category_no)
);

--tb_content_category fk
alter table tb_content_category add constraint fk_category_content_category
   foreign key (category_no) references tb_category (category_no) on delete set null;

alter table tb_content_category add constraint fk_content_content_category
   foreign key (content_no) references tb_content (content_no) on delete set null;
   
drop table if exists tb_end_service;
create table tb_end_service
(
	end_service_no	bigint		generated always as identity primary key
	,ott_no			smallint	not null
	,content_no		bigint		not null
	,end_date		date		not null
);

SELECT a.end_service_no, a.ott_no, a.content_no, b.content_nm, c.ott_nm
, extract('DAY' from a.end_date) as day
, extract('Month' from a.end_date) as Month
FROM tb_end_service a
join tb_content b
on a.content_no = b.content_no
join tb_ott c
on a.ott_no = c.ott_no
;
select  * from tb_end_service;


--tb_end_service fk
alter table tb_end_service add constraint fk_ott_end_service
   foreign key (ott_no) references tb_ott (ott_no) on delete set null;
  
alter table tb_end_service add constraint fk_content_end_service
   foreign key (content_no) references tb_content (content_no) on delete set null;
   

drop table if exists tb_ott;
create table tb_ott
(
	ott_no		smallint	primary key
	,ott_nm		varchar(50)	not null
	,ott_img	text		default null
);

-- 주요 쿼리문
SELECT a.end_service_no, a.ott_no, a.content_no, b.content_nm, c.ott_nm, a.end_date
	, extract('Year' from a.end_date) as year
	, extract('Month' from a.end_date) as month
	, extract('DAY' from a.end_date) as day		
	FROM tb_end_service a
	join tb_content b
	on a.content_no = b.content_no
	join tb_ott c
	on a.ott_no = c.ott_no
	;

select * from tb_content_ott;
insert into tb_content_ott values (1, 1);

SELECT *
FROM tb_end_service
where ott_no = 3;

SELECT * FROM tb_end_service 
WHERE end_date BETWEEN end_date_1 AND end_date_2 AND ott_no = ott_no

INSERT INTO tb_content
(content_no, content_nm, content_info, content_runtime
, previewurl, thumbnail, age, ott_no, rating, country)
VALUES(0, '', '', 0, '', '', 0, 0, 0, '');

DELETE FROM tb_content;
insert into public.tb_content (content_no, content_nm,content_info,content_runtime,previewurl,thumbnail,age,ott_no,rating,country) VALUES
(1,'동감','1999년, 용은 첫눈에 반하게 된 한솔을 사로잡기 위해 친구에게 HAM 무전기를 빌린다. 2022년, ‘무늬’는 인터뷰 과제를 위해 오래된 HAM 무전기를 작동시킨다. "씨큐... 씨큐... 제 목소리 들리세요?" 개기 월식이 일어난 날, 시간을 뛰어넘어 기적처럼 연결된 ‘용’과 ‘무늬’는 서로의 사랑과 우정을 이야기하며 특별한 감정을 쌓아가는데...',114,'https://youtu.be/y-G3NoCHChg','https://myottt.s3.ap-northeast-2.amazonaws.com/poster/ditto.jpg',12,1,3.5,'한국'),
(2,'짱구는못말려','오징어는 말릴 수 있지만 짱구는 못말린다.',120,'https://www.youtube.com/watch?v=nT1eSDDvhxs','www.naver.com',12,2,3.5,'한국'),
(3,'스파이더맨','거미줄로 사람을 구하는 영웅, 마블의 시초로 불리우는 스파이더맨 그의 전성기는 어디까지인가 개봉박두',123,'https://www.youtube.com/watch?v=S9-UzUD2VBw','www.naver.com',12,3,4.0,'한국'),
(4,'아이언맨','아이언의 갑옷을 입고 탄생한 우리들의 영웅 아이어맨, 악당과의 전투에서 승리한다.',132,'https://www.youtube.com/watch?v=Q9OT3kEClMw','www.naver.com',12,4,4.5,'한국'),
(5,'배트맨','배트맨의 박쥐는 사납고 위험하다. 그의 행적은 강도들도 무서워하니, 인간세상의 숨은 영웅 배트맨의 이야기 드디어 시작합니다.',132,'https://www.youtube.com/watch?v=BcnkSnnan50','www.naver.com',12,5,3,'한국'),
(6,'수퍼맨리턴즈','근육빵빵 올빽머리 하늘을 나는 영웅 슈퍼맨, 힘이 세어 세상의 모든 불가피한 일들을 마다하지 않고 도움을 주기위해 나선다.',130,'https://www.youtube.com/watch?v=I1c5tSv8D9s','www.naver.com',12,6,2,'한국'),
(7,'첫키스만50번째','하루가 지나면 기억상실증이 걸리는 주인공, 하루하루 메모를 해놓지만 행복했던 첫키스의 기억을 메모해놓진 않는데... 매일 첫키스를 해주는 남자친구와의 슬프고 로맨틱한 러브스토리.',99,'https://www.youtube.com/watch?v=l4pf5ZDELXg','www.naver.com',15,2,4.5,'미국'),
(8,'정글랜드','정글같은 케이지 안에서 벌어지는 두형제의 복싱 대결 스토리. 긴장감을 늦출수가 없는데...',90,'https://www.youtube.com/watch?v=Zctb2RB4sDM','www.naver.com',12,2,3.5,'영국,미국'),
(9,'기묘한가족','기묘한가족들의 생계 스토리 뭐여?라는 소리가 절로 나온다.',112,'https://www.youtube.com/watch?v=TOvDxkPtszc','www.naver.com',15,4,3.5,'오스트레일리아,콜롬비아'),
(10,'정글','모든 것이 베일에 싸인 칼이라는 이방인의 가이드로 예측할 수 없는 정글 여행을 떠나는데… ',115,'https://www.youtube.com/watch?v=6wgssMwVlWQ','www.naver.com',12,4,4.5,'한국'),
(11,'우리들의일기','1980년대, 부유한 가정에서 자랐지만 온갖 사고는 도맡아 치고 다니던 ‘현수’는 간신히 중학교를 졸업하고 고등학교에 입학하지만 또다시 첫 날부터 불량써클 ‘허리케인’의 눈밖에 제대로 나고 만다.',94,'https://www.youtube.com/watch?v=InyUrgWWdx8','www.naver.com',19,6,2.5,'한국'),
(12,'사이코남자친구','똑똑하고 사교적인 여주인공이 치어리더 팀에 들어가 남자친구가 생기면서 벌어지는 일들을 다룬 극영화',87,'https://www.youtube.com/watch?v=97IWpB-MZ_I','www.naver.com',12,2,3,'미국')
;
select * from tb_content;
