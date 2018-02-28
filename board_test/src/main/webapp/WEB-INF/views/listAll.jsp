<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session = "false" %>
<%@ page language = "java" contentType = "text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file = "include/header.jsp" %>


		<!-- general form elements -->
		
		<div class = "box">
			<div class = "box-header with-border">
				<h3 class = "box-title">LIST ALL PAGE</h3>
			</div>
		
			
			<div class = "box-body">
				<table class = "table table-bordered">
					<tr>
						<th style = "width: 10px">BNO</th> <!-- th태그 : 표 제목 -->
						<th>TITLE</th>
						<th>WRITER</th>
						<th>REGDATE</th>
						<th style = "width: 40px">VIEWCNT</th>
					</tr>
					
			
				    <c:forEach items = "${list}" var = "boardVO">
		
						<tr>
							<td>${boardVO.bno}</td>
							<td><a href = '/read?bno=${boardVO.bno}'>${boardVO.title}</a></td>
							<td>${boardVO.writer}</td>
							<td><fmt:formatDate pattern = "yyyy-MM-dd HH:mm" value = "${boardVO.regdate}"/></td>
							<td><span class = "badge bg-red">${boardVO.viewcnt}</span></td>
						</tr>

					</c:forEach>			
				</table>
			</div>
			<!-- /.box.body -->
			
			
			<div class = "box-footer">Footer</div>
			<!-- /.box.footer -->
		</div>
	</div>
	<!-- /.col (left) -->
	
	
	
	
	
	<!-- regist 성공 시 -->
	<script>
		var result = '${msg}';
		
		if(result == 'success'){
			alert("처리가 완료되었습니다.");
		}
	</script>
	
<%@ include file = "include/footer.jsp" %>
	