<%@page import="multi.MockDAO2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bag" class="multi.MockVO2"></jsp:useBean>
<jsp:setProperty property="*" name="bag"/>
<%
	MockDAO2 dao = new MockDAO2();
	dao.insert(bag);
%>