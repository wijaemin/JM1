/*
종합문제

다음 요구사항에 맞는 테이블과 시퀀스를 생성하고 샘플데이터를 추가한 뒤 다음을 조회하시오.
--------------------------------------------------------------------------------------
<시퀀스> - kpop_song_seq
<테이블> - kpop_song
- kpop_song_no - 곡번호, 시퀀스로 부여
- kpop_song_title - 곡제목, 한글 100자 크기로 생성, 필수
- kpop_song_artist - 가수, 한글 100자 크기로 생성, 필수
- kpop_song_album - 앨범, 한글 100자 크기로 생성, 필수
- kpop_song_playcount - 재생횟수, 0이상 숫자로 생성, 기본값 0
- kpop_song_likecount - 좋아요횟수, 0이상 숫자로 생성, 기본값 0
*/
-- 데이터 추가 구문은 제공해 드립니다.
drop table kpop_song;
create table kpop_song(
kpop_song_no number primary key,
kpop_song_title varchar2(300) not null,
kpop_song_artist varchar2(300) not null,
kpop_song_album varchar2(300) not null,
kpop_song_playcount number default 0 check(kpop_song_playcount >=0),
kpop_song_likecount number default 0 check(kpop_song_likecount >=0)
);
drop sequence kpop_song_ seq;
create sequence kpop_song_seq;




BEGIN
  FOR i IN 1..1000 LOOP
    INSERT INTO kpop_song (
      kpop_song_no,
      kpop_song_title,
      kpop_song_artist,
      kpop_song_album,
      kpop_song_playcount,
      kpop_song_likecount
    ) VALUES (
      kpop_song_seq.NEXTVAL,
      'Sample Title ' || i,
      'Sample Artist ' || i,
      'Sample Album ' || i,
      ROUND(DBMS_RANDOM.VALUE(10, 99999)), -- 재생 횟수 (10 이상 10만 미만)
      ROUND(DBMS_RANDOM.VALUE(10, 49999)) -- 좋아요 수 (10 이상 5만 미만)
    );
  END LOOP;
  COMMIT;
END;

select * from kpop_song;
-- 위 구문을 실행하면 1000개의 데이터가 들어갑니다.

-- (1) 좋아요를 가장 많이 받은 곡 Top 100을 출력
select * from(
	select rownum rn, TMP.* from(
		select *from kpop_song order by kpop_song_likecount desc)TMP
)where rn between 1 and 100;

-- (2) 재생을 가장 많이 한 곡 Top 100을 출력
select * from(
	select rownum rn, TMP.*from(
		select * from kpop_song order by kpop_song_playcount desc)TMP
)where rn between 1 and 100;



-- (3) 랭킹포인트를 계산하여 Top 100을 출력
--      랭킹포인트는 재생수*0.6 + 좋아요*0.4 로 계산합니다
select * from(
	select rownum rn, TMP.*from(
		select kpop_song.*,
		kpop_song_playcount * 0.6 +kpop_song_likecount *0.4 랭킹포인트
		from kpop_song
		order by 랭킹포인트 desc)TMP
)where rn between 1 and 100;

