package oop.poly1;

public class GalaxyBook extends NoteBook{

	@Override
	public void power() {
		System.out.println("갤럭시북으로 전원을 실행합니다.");
		
	}

	@Override
	public void video() {
		System.out.println("갤럭시북으로 동영상 재생을 실행합니다.");		
	}

	@Override
	public void typing() {
		System.out.println("갤럭시북으로 타이핑을 실행합니다.");
		
	}

}
