// 버튼 하나 당 함수 하나
function 로그인() {
	id2 = 'root'; // 세미콜론(;) 생략가능, ""/'' 상관없음, let/var 생략가능
	id = prompt('아이디 입력')
	if (id == id2) {
		alert('로그인 성공')
	} else {
		alert('로그인 실패')
	}

	function 비교() {
		n1 = 10;
		n2 = 100;
		if (n1 == n2) {
			alert('같습니다')
		} else
			alert('다릅니다')
	}
	
}
