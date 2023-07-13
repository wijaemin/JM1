package api.collection3;

import java.util.Map;
import java.util.TreeMap;

public class Test01 {
	public static void main(String[] args) {
		//Map
		//=세트 저장조(key-value 저장소)
		//=List, Set은 한개의 데이터를 저장하는 반면에 Map은 두 개를 세트로 저장
		//=Key는 이름 , Value는 값의 역할을 수행
		//=Set에 value가 붙어있는 형태로 봐도 무방
		
//		Map<String,Integer> map = new HashMap<>();
		Map<String,Integer> map = new TreeMap<>();

		//추가 -add가 아니라 put이다(데이터 개수가 달라서 이름이 다름)
		map.put("유재석", 50);
		map.put("강호동",53);
		map.put("유재석", 51);//key중복(기존 항목의 value가 수정됨)
		map.put("박명수", 52);
		map.put("정준하", 52);//value 중복 가능
		
		//검색 - key/value 용 contains가 따로 있다
		System.out.println(map.containsKey("유재석"))	;
		System.out.println(map.containsValue(62));
		
		//삭제 - remove
//		map.remove("노홍철");
//		map.remove("박명수");
		
		//추출
		System.out.println(map.get("노홍철"));//null
		System.out.println(map.get("박명수"));//52
		//출력
		System.out.println(map);
		System.out.println(map.size());
	
	}
}
