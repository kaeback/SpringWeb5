<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link rel="stylesheet" type="text/css" href="../resources/css/default.css">

<script type="text/javascript">
// 가입신청 후 서버에서의 오류로 현재 페이지로 되돌아온 경우 오류 메시지 출력
<c:if test="${errorMsg != null}">alert('${errorMsg}');</c:if>

// 가입 폼 확인
function formCheck() {
	var id = document.getElementById("custid");
	var pw = document.getElementById("password");
	var pw2 = document.getElementById("password2");
	var name = document.getElementById("name");

	if (id.value.length < 3 || id.value.length > 10) {
		alert("ID는 3~10자로 입력하세요");
		id.focus();
		id.select();

		return false;
	}

	if (pw.value.length < 3 || pw.value.length > 10) {
		alert("비밀번호는 3~10자로 입력하세요");
		pw.focus();
		pw.select();

		return false;
	}

	if (pw.value != pw2.value) {
		alert("비밀번호를 정확하게 입력하세요");
		pw.focus();
		pw.select();

		return false;
	}

	if (name.value == "") {
		alert("이름을 입력하세요");
		name.focus();
		name.select();

		return false;
	}

	return true;
}

// ID 중복확인 창 열기
function idcheckOpen() {
	window.open("idcheck", "newwin", "top=200, left=400, width=400, height=300, resizeable=no");
}
</script>
</head>
<body>
<div class="centerdiv">
<h1>[ 회원가입 ]</h1>
	<form id="joinForm" action="join" method="post" onsubmit="return formCheck();">
	<table>
		<tr>
			<th>ID</th>
			<td>
				<input type="text" name="custid" id="custid" maxlength="10" placeholder="ID 중복확인 이용" readonly="readonly" value="${customer.custid }" />
				<input type="button" value="ID 중복확인" onclick="idCheckOpen()">
			</td>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="password" id="passrod" placeholder="비밀번호 입력" value="${customer.password }">
				<input type="password" id="passrod2" placeholder="비밀번호 다시 입력" value="${customer.password }">
			</td>	
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" nam="name" id="name" placeholder="이름 입력" value="${customer.name }"></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>
				<input type="text" name="email" id="email" placeholder="이메일 입력" value="${customer.email }">
			</td>
		</tr>
		<tr>
			<th>성별</th>
			<td>
				<input type="radio" name="gender" value="male" checked>남자
				<input type="radio" name="gender" value="female" checked>여자
			</td>
		</tr>
		<tr>
			<th>주민번호</th>
			<td>
				<input type="text" name="ssn" placeholder="주민번호" value="${customer.ssn }">
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>
				<input type="texxt" name="address" placeholder="주소 입력" value="${customer.address }" style="width:300px;">
			</td>
		</tr>
	</table>
	<br>
	<input type="submit" value="가입">
	<input type="reset" value="다시 쓰기">
	</form>
</div>
</body>
</html>