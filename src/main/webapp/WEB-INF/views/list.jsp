<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전화번호부</h1>

	<h2>전화번호-리스트</h2>

	<p>등록된 전화번호 리스트 입니다.</p>

	<c:forEach items="${requestScope.personList}" var="personVo">
		<table border="1">
			<tbody>
				<tr>
					<th>이름(name)</th>
					<td>${personVo.name}</td>
				</tr>
				<tr>
					<th>핸드폰(hp)</th>
					<td>${personVo.hp}</td>
				</tr>
				<tr>
					<th>회사(company)</th>
					<td>${personVo.company}</td>
				</tr>
				<tr>
					<td><a href="/phonebook3/delete?no=${personVo.personId}">[삭제]</a></td>
					<td><a href="/phonebook3/editform?no=${personVo.personId}">[수정폼으로 이동]</a></td>
				</tr>

			</tbody>
		</table>
		<br>

		<br>
		<a href="/phonebook3/writeform">추가번호 등록</a>
	</c:forEach>

</body>
</html>