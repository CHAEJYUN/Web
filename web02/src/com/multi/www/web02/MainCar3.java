package com.multi.www.web02;

public class MainCar3 {

	public static void main(String[] args) {
		
		Car2 car2; //12개의 방
		for (int i = 0; i < 1000; i++) {
			car2 = Car2.getInstance();
			System.out.println(car2); //주소확인 ==> 싱글톤은 주소 하나만 ==> 서버가 편안?
		}
//		System.out.println("메모리크기>> " + 12 *1000);
	}

}
