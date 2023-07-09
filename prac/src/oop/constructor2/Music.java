package oop.constructor2;

public class Music {
	String title;
	String Singer;
	String album;
	int count;
	int like;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return Singer;
	}
	public void setSinger(String singer) {
		Singer = singer;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		if(count<0) return;
		this.count = count;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		if(this.count<0) return;
		this.like = like;
	}
	public String getBest() {
		if(this.count>100000) {
			return ("(베스트)");
		}
		else {
			return "";
		}
	}
	public String getHot() {
		if(this.like>100000) {
			return ("(인기곡)");
		}
		else {
			return "";
		}
	}
	public int getRank() {
		return this.getCount()*2+this.getLike()/2;
	}
	
	
	
	
	public Music(String title,String singer,String album) {
		this(title,singer,album,0,0);
	}
	public Music(String title,String singer, String album,int count,int like) {
		this.setTitle(title);
		this.setSinger(singer);
		this.setAlbum(album);
		this.setCount(count);
		this.setLike(like);
	}
	
	void show() {
		System.out.println("<음원차트>");
		System.out.println("제목 : " +this.getTitle() + this.getBest()+this.getHot());
		System.out.println("가수 : " +this.getSinger());
		System.out.println("앨범 : " +this.getAlbum());
		System.out.println("재생수 : " + this.getCount());
		System.out.println("좋아요수 : " + this.getLike());
		System.out.println("랭킹 점수 : " + this.getRank());
	}
	
}
