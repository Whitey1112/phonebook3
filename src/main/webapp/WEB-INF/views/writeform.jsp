<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>등록폼
</body>
<body>
	<h1>전화번호부</h1>

	<h2>전화번호-등록폼</h2>

	<p>아래의 항목을 입력한 후 등록버튼을 클릭해 주세요</p>
	<!-- method="get" 개발자를 위한(글자 수 제한 O),request문서의 head -->
	<!-- method="post"사이트 사용자를위한(주소에 나와있는 개인정보를 나타내지않음)(글자 수 제한 X), request문서의 body -->
	<!-- method="get" = http://localhost:8888/phonebook3/write?name=김선우hp=010&company=02 -->
	<!-- method="post" = http://localhost:8888/phonebook3/write-->
	<form action="/phonebook3/write" method="get">
		<div>
			<label for="txt-name">이름(name):</label> 
			<input id="txt-name" type="text" name="name" value="" placeholder="이름">
		</div>
		
		<div>
			<label for="txt-hp">핸드폰(hp):</label> 
			<input id="txt-hp" type="text" name="hp" value="" placeholder="핸드폰">
		</div>
		
		<div>
			<label for="txt-company">회사(company):</label> 
			<input id="txt-company" type="text" name="company" value="" placeholder="회사">
		</div>
		<br>
		<button type="submit">등록(전송)</button>
	</form>
	
	
	<br><br>
	<a href="/phonebook2/pbc?action=list">리스트로 가기</a>
	
	
</body>
</html>