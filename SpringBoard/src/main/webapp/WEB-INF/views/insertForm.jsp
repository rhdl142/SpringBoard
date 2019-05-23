<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>INSERT</title>
		<style>
		
			body{ 
				padding-top:200px;
			}
			
			#tbl, #title {
				width: 1200px;
				margin: 0px auto 20px auto;
			}
		
			#tbl th {
				width: 400px; 
				text-align: center;
				vertical-align: middle;
				background-color: #eee;
			}
			
			#tbl {
				height: 250px;
			}
			
			input[type=text], textarea {
				width: 800px;
			}
			
			#btns {
				width: 1200px;
				margin: 0px auto;
			}
			
			#tbl tr:nth-child(3) td {
				height: 250px;
			}
			
			
		</style>
	</head>
	<body>
		<div id="main">
			<div id="contents">
				<section>
				<h1 id="title">INSERT</h1>
					<form action="/SpringBoard/board/insert" method="post">
						<table id="tbl" class="table">
							<tr>
								<th>이름</th>
								<td>
									<input type="text" name="name" required />
								</td>
							</tr>
							<tr>
								<th>제목</th>
								<td>
									<input type="text" name="title" required />
								</td>
							</tr>
							<tr>
								<th>내용</th>
								<td><textarea name="content" rows="12" required></textarea></td>
							</tr>
							<tr>
								<th>비밀번호</th>
								<td>
									<input type="text" name="passwd" required />
								</td>
							</tr>
						</table>
						
						<div id="btns">
							<input type="submit" value="작성 완료" class="btn btn-success">
							<input type="button" value="뒤로 가기" class="btn btn-danger"onclick="history.back();">
						</div>
					</form>
				</section>
			</div>
		</div>
	</body>
</html>