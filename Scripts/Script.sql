-- 게임
CREATE TABLE game (
	gno       INT(20)     NOT NULL AUTO_INCREMENT, -- 게임번호
	title     VARCHAR(50) NULL,     -- 게임명
	saleprice INT(20)     NULL,     -- 판매가격
	discount  INT(2)      NULL,     -- 할인율
	issale    TINYINT(2)  NULL,     -- 판매여부
	platform  VARCHAR(20) NULL,     -- 기종
	start     date   NULL,     -- 발매일
	titleimg  varchar(200) null,-- 타이틀 이미지ㅠ
	PRIMARY KEY (gno)
);

CREATE TABLE gamedetail (
	gno       INT(20)     NOT NULL, -- 게임번호
	gcomp     VARCHAR(20) NULL,     -- 개발사
	category  VARCHAR(20) NULL,     -- 게임장르
	saleyear  INT(3)      NULL,     -- 판매연령
	gcontent  TEXT        NULL,     -- 게임설명
	downcnt   INT(20)     NULL,      -- 다운로드횟수
	PRIMARY KEY (gno)
);


-- 게임업로드
CREATE TABLE gamefile (
	gno   INT(20)      NULL,     -- 게임번호
	gpath VARCHAR(200) NULL      -- 게임파일주소
);


-- 스크린샷업로드
CREATE TABLE screenshot (
	gno   INT(20)      NULL,     -- 게임번호
	spath VARCHAR(200) NULL      -- 스크린샷주소
);

-- 라이브러리
CREATE TABLE library (
	libno INT(20)     NOT NULL AUTO_INCREMENT, -- 라이브러리번호
	isbuy TINYINT(2)  NULL,     -- 구입여부
	gno   INT(20)     NULL,     -- 게임번호
	id    VARCHAR(50) NULL ,     -- 아이디
	PRIMARY KEY (libno)
);


-- 멤버
CREATE TABLE member (
	id       VARCHAR(50)  NOT NULL, -- 아이디
	password VARCHAR(50)  NULL,     -- 비밀번호
	name     VARCHAR(20)  NULL,
	email    VARCHAR(50)  NULL,     -- 이메일
	phone    VARCHAR(20)  NULL,     -- 전화번호
	regdate  TIMESTAMP    NULL,     -- 가입일자
	old      INT(3)       NULL,     -- 연령
	PRIMARY KEY (id)
);


-- 평점
CREATE TABLE grade (
	rateno  INT(20)     NOT NULL AUTO_INCREMENT, -- 평점번호
	gno     INT(20)     NULL,     -- 게임번호
	id      VARCHAR(50) NULL,     -- 아이디
	good    INT(20)     NULL,     -- 좋아요
	bad     INT(20)     NULL,     -- 나빠요
	rate    INT(20)     NULL,     -- 총평점
	isgrade TINYINT(2)  NULL,    -- 평가여부
	PRIMARY KEY (rateno)
);

		

-- 게임댓글
CREATE TABLE greply (
	cno      INT(20)     NOT NULL AUTO_INCREMENT, -- 코멘트번호
	id       VARCHAR(50) NULL,     -- 작성자
	gno      INT(20)     NULL,     -- 게임번호
	content  TEXT        NULL,     -- 코멘트내용
	regdate  TIMESTAMP   NULL,     -- 작성일자
	modidate TIMESTAMP   NULL,    -- 수정일자
	PRIMARY KEY (cno)
);


-- 게시판
CREATE TABLE board (
	bno        INT(20)      NOT NULL AUTO_INCREMENT, -- 게시물번호
	id         VARCHAR(50)  NULL,     -- 작성자
	btitle     VARCHAR(100) NULL,     -- 제목
	readcount  INT(20)      NULL,     -- 조회수
	replycount INT(20)      NULL,     -- 댓글수
	regdate    TIMESTAMP    NULL,     -- 작성일자
	modidate   TIMESTAMP    NULL,     -- 수정일자
	PRIMARY KEY (bno)
);

-- 게시물내용
CREATE TABLE boardcontent (
	bno      INT(20) NOT NULL , -- 게시물번호
	bcontent TEXT    NULL,     -- 게시물내용
	PRIMARY KEY (bno)
);

-- 유저스크린샷
CREATE TABLE userscreen (
	bno      INT(20)      NULL, -- 게시물번호
	userpath VARCHAR(200) NULL  -- 스크린샷주소
);

-- 댓글
CREATE TABLE reply (
	rno      INT(20)     NOT NULL AUTO_INCREMENT, -- 댓글번호
	id       VARCHAR(50) NULL,     -- 아이디
	bno      INT(20)     NULL,     -- 게시물번호
	rcontent TEXT        NULL,     -- 댓글내용
	regdate  TIMESTAMP   NULL,     -- 작성일자
	modidate TIMESTAMP   NULL,    -- 수정일자
	PRIMARY KEY (rno)
);




/*샘플데이터 */
insert into game(title,saleprice,discount,issale,`start`,platform) values
('파이널판타지15',50000,20,0,'2017-07-11','PS4'),
('인왕',60000,10,0,'2017-07-13','PS4'),
('스타크래프트리마스터',40000,0,0,'2017-07-18','PC'),
('디아블로3',10000,10,0,'2017-07-20','PC'),
('아이마스',30000,20,0,'2017-07-24','PS4'),
('드래곤퀘스트11',60000,20,0,'2017-07-28','PS4'),
('슈퍼로봇대전',90000,20,0,'2017-07-24','PS4'),
('제네레이션',30000,20,0,'2017-07-24','PS4'),
('데스티니',50000,20,0,'2017-07-24','PS4'),
('디아블로3',50000,20,0,'2017-07-24','PC'),
('디아블로3',50000,20,0,'2017-07-24','XBOX'),
('디아블로3',50000,20,0,'2017-07-24','PC'),
('디아블로3',50000,20,0,'2017-07-24','PC'),
('디아블로3',50000,20,0,'2017-07-24','PS4'),
('디아블로3',50000,20,0,'2017-07-24','PS4'),
('디아블로3',50000,20,0,'2017-07-24','XBOX'),
('디아블로3',50000,20,0,'2017-07-24','PS4');

insert into gamedetail(gno,gcomp,category,saleyear,gcontent,downcnt) values
(1,'스퀘어에닉스','롤플레잉',0,'파이널판타지15탄 폭망게임',0),
(2,'프롬소프트웨어','액션롤플레잉',18,'개어렵..',0),
(3,'블리자드','실시간전략시뮬레이션',15,'옛날게임',0),
(4,'블리자드','액션롤플레잉',12,'수면제',0),
(5,'스퀘어에닉스','롤플레잉',0,'파이널판타지15탄 폭망게임',0),
(6,'스퀘어에닉스','롤플레잉',0,'파이널판타지15탄 폭망게임',0);

insert into library(isbuy,gno,id) values
(0,1,'dididas'),
(0,2,'dididas'),
(0,3,'dididas'),
(0,4,'dididas');


select * from library;

SELECT * FROM game where gno=1;

SELECT * FROM game;
