package oop.constructor2;

public class Music {
	//멤버 필드
	String title;
	String singer;
	String album;
	int count;
	int like;
	
	//멤버 메소드
	
	void setTitle(String title) {
		this.title = title;
	}

	void setSinger(String singer) {
		this.singer = singer;
	}

	void setAlbum(String album) {
		this.album = album;
	}

	void setLike(int like) {
		this.like = like;
	}

	void setCount(int count) {
		if(this.count>=0){
			this.count=count;
		}
	}
	void setGood(int like) {
		if(like>=0) {
			this.like=like;
		}
	}
	
	
	String getTitle() {
		return this.title;
	}

	String getSinger() {
		return this.singer;
	}

	String getAlbum() {
		return this.album;
	}

	int getCount() {
		return this.count;
	}

	int getLike() {
		return this.like;
	}
	String getBest() {
		if(this.count>100000) {
			return"(베스트)";
		}
		else {
			return"";
		}
	}
	String getHot() {
		if(this.count>100000) {
			return"(인기곡)";
		}
		else {
			return"";
		}
	}
	
	
	int getRank() {
		return getCount() * 2 +getLike() /2;
	}
	
	Music(String title,String singer,String album){
		this(title, singer, album, 0, 0);
	}
	
	
	Music(String title,String singer,String album,int count,int like) {
		this.setTitle(title);
		this.setSinger(singer);
		this.setAlbum(album);
		this.setCount(count);
		this.setGood(like);
	}
	void show() {
		System.out.println("<음원차트>");
	
		System.out.println("제목 : " + this.getTitle() + this.getBest() + this.getHot());	
	
		System.out.println("가수 : " + this.getSinger());
		System.out.println("앨범 : " + this.getAlbum());
		System.out.println("재생 수 : " +this.getCount());
		System.out.println("좋아요 수 : " +this.getLike());
		System.out.println("랭킹 점수 : " +this.getRank());
		System.out.println();
		
	}

	
	
	
}
