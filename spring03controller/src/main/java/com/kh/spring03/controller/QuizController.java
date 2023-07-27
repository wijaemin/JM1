package com.kh.spring03.controller;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //애노테이션(Annotation)-역할 정의
public class QuizController {
@RequestMapping("/dice")
public String dice() {
	Random r=new Random();
	int dice=r.nextInt(6)+1;
	return "주사위 : " +dice;
}
@RequestMapping("/lotto")
public String lotto() {
	Random r=new Random();
	int lotto=r.nextInt(45)+1;
	return "로또 번호 : " +lotto;
}
//===============================

//(추가)스프링은 역할을 명시하는 것을 선호한다
//-@RequestParam을 변수 앞에 붙여 파라미터임을 표시
@RequestMapping("/square")
public String square(@RequestParam int num){
	int square=num*num;
	return num + "의 제곱 : " + square;
	
}
//(추가)연도가 주어지지 않으면 실행을 안할건가?
//-파라미터가 없어도 실행되어야 하는 상황(ex:기본값)
//-만약 birth가 제공되지 않는다면 성인 요금을 부여
//-@RequestParam에 required=false옵션을 넣어주면 없어도 됨 //값이 없어도 된다는 뜻
//-@RequestParam에 defaultValue를 설정하여 기본값을 지정(문자열)
@RequestMapping("/subway")
public String subway(
		@RequestParam(required = false,defaultValue = "2000") int birth) {
	int age=LocalDate.now().getYear()-birth+1;
	int price;
	if(age>=65 && age<8)  price=0;
	else if(age>=20) price=1250;
	else if(age>=14) price =720;
	else  price=450;
	return "요금은 " + price + "원 입니다"; 
}
@RequestMapping("/leap")
public String leapYear(@RequestParam int year) {
	boolean leapYear =year%400==0 || year%4==0 && year%100!=0;
	if(leapYear) return year + "은 윤년입니다";
	else return year + "년은 윤년이 아닙니다.";
}
@RequestMapping("/circle")
public String circle(@RequestParam int radius) {
	double circleArea=radius *radius *Math.PI;
	return "반지름이 " +radius +"인 원의 넓이 = " +circleArea;
}

}
