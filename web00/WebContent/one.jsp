<%@page import="multi.MemberDAO"%>
<%@page import="multi.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 브라우저가 보낸 데이터를 받는 부분, JAVA로 -->
<%
	//스크립트릿
String id = request.getParameter("id");

MemberDAO dao = new MemberDAO();
MemberVO bag = dao.one(id);
%>

<!-- 브라우저에게 결과를 알려주기 위한 html코드 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First Page</title>
<style>
.t1 {
	width: 150px;
	text-align: center;
}
</style>
</head>

<body>
	<div class="main">
		<div class="title">
			<h1>회원검색 성공</h1>
			<hr>
		</div>

		<div class="content">
			<table>
				<tr>
					<td class="t1">검색한 아이디</td>
					<td><%=id%></td>
				</tr>
				<tr>
					<td class="t1">검색한 비밀번호</td>
					<td><%=bag.getPw()%></td>
				</tr>
				<tr>
					<td class="t1">검색한 이름</td>
					<td><%=bag.getName()%></td>
				</tr>
				<tr>
					<td class="t1">검색한 전화번호</td>
					<td><%=bag.getTel()%></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>