<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>LIST</title>
		<style>
			body{ 
				padding-top:200px;
			}
			
			#tbl, #title {
				width: 1400px;
				margin:0px auto 20px auto;
			}
		
			#tbl th:nth-child(1) {width:50px;}
			#tbl th:nth-child(2) {width:180px;}
			#tbl th:nth-child(3) {width:620px;}
			#tbl th:nth-child(4) {width:50px;}
			#tbl th:nth-child(5) {width:300px;}
			#tbl th:nth-child(6) {width:100px;}
			#tbl th:nth-child(7) {width:100px;}
		
			#btns {
				width: 1400px;
				margin:0px auto;
			}
			
			#tbl th,#tbl td {
				text-align:center;
			}
		
			#tbl th {
				background-color: #eee;
			}
			
		</style>
		<script>
			function checkEdit(passwd,seq) {
				var pw = prompt('암호를 입력하세요');
				
				if(pw == passwd) {
					location.href='/SpringBoard/board/updateForm?seq='+seq;
				} else {
					alter('falied');
				}
			}
			
			function checkDel(passwd,seq) {
				var pw = prompt('암호를 입력하세요');
				
				if(pw == passwd) {
					location.href='/SpringBoard/board/delete?seq='+seq;
				} else {
					alter('falied');
				}
			}
		</script>
	</head>
	<body>
		<div id="main">
			<div id="contents">
				<section>	
					<h1 id="title">LIST</h1>
					
					<table id="tbl">
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>내용</th>
							<th>글쓴이</th>
							<th>날짜</th>
							<th>수정</th>
							<th>삭제</th>
						</tr>
						<c:if test="${list.size() == 0}">
						<tr>
							<td colspan="4">현재 게시물이 없습니다.</td>
						</tr>
						</c:if>
						<c:if test="${list.size() != 0}">
							<c:forEach items="${list }" var="dto">
		 						<tr>
									<td>${dto.getSeq()}</td>
									<td>${dto.getTitle() }</td>
									<td>${dto.getContent() }</td>
									<td>${dto.getName() }</td>
									<td>${dto.getRegdate() }</td>
									<td><input type="button" value="수정" onclick="checkEdit(${dto.getPasswd() },${dto.getSeq() });"></td>
									<td><input type="button" value="삭제" onclick="checkDel(${dto.getPasswd() },${dto.getSeq() });"></td>
								</tr>
							</c:forEach>
						</c:if>
					</table>
					
					<div id="btns">
						<input type="button" value="쓰기" onclick="location.href='/SpringBoard/board/insertForm';">
					</div>
				</section>
			</div>
		</div>
	</body>
</html>