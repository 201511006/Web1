<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session = "false" %>
<%@ page language = "java" contentType = "text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file = "header.jsp" %>


		<!-- general form elements -->
		
		<div class = "box">
			<div class = "box-header with-border">
				<h3 class = "box-title">LIST ALL PAGE</h3>
			</div>
		
			
			<div class = "box-body">
			
				
				<select name = "searchType">
					<!-- 검색 조건 없음 -->
					<option value = "n"
						<c:out value = "${cri.searchType == null?'selected':''}"/>>
						---</option>
						
					<!-- 제목 검색-->	
					<option value = "t"
						<c:out value = "${cri.searchType == null?'selected':''}"/>>
						Title</option>
						
					<!-- 내용 검색 -->	
					<option value = "c"
						<c:out value = "${cri.searchType == null?'selected':''}"/>>
						Content</option>
						
					<!-- 작성자 검색	 -->
					<option value = "w"
						<c:out value = "${cri.searchType == null?'selected':''}"/>>
						Writer</option>
						
					<option value = "tc"
						<c:out value = "${cri.searchType == null?'selected':''}"/>>
						Title OR Content</option>
						
					<option value = "cw"
						<c:out value = "${cri.searchType == null?'selected':''}"/>>
						Content OR Writer</option>
						
					<option value = "tcw"
						<c:out value = "${cri.searchType == null?'selected':''}"/>>
						Title OR Content OR Writer</option>						
				</select>
				
				<input type = "text" name = 'keyword' id = 'keywordInput' value = '${cri.keyword}'>
				<button id = 'searchBtn'>Search</button>
				<button id = 'newBtn'>New Board</button>
			
			
			
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
							 <td>
								<a href = "/sboard/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&bno=${boardVO.bno}">${boardVO.title}</a>
							</td> 
							<td>${boardVO.writer}</td>
							<td><fmt:formatDate pattern = "yyyy-MM-dd HH:mm" value = "${boardVO.regdate}"/></td>
							<td><span class = "badge bg-red">${boardVO.viewcnt}</span></td>
						</tr>

					</c:forEach>			
				</table>
				
				
				<div class = "text-center">
					<ul class = "pagination">
						
						<c:if test = "${pageMaker.prev}">
							<li><a href = "list${pageMaker.makeSearch(pageMaker.startPage - 1)}">&laquo;</a></li>
						</c:if>
						
						<c:forEach begin = "${pageMaker.startPage}" end = "${pageMaker.endPage}" var = "idx">
							<li
								<c:out value = "${pageMaker.cri.page == idx?'class=active':''}"/>>
								<a href = "list${pageMaker.makeSearch(idx)}">${idx}</a>
							</li>
						</c:forEach>

						<c:if test = "${pageMaker.next && pageMaker.endPage > 0}">
							<li><a href = "list${pageMaker.makeSearch(pageMaker.endPage + 1)}">&raquo;</a>
						</c:if>						
					</ul>
				</div>
				
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
	
<%@ include file = "footer.jsp" %>
	