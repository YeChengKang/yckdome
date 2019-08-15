<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basepath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function showbalance(accid) {
		
		$.post("uc/findbalance",{"accid":accid},function(data){
			console.log(data);
			$("#mybalance").html(data);
		},"json");
		
	}
</script>
</head>
<body>

<h3>这里是book_prebuy.jsp页面</h3>
<form action="uc/buybook" method="post">
	<input type="hidden" value="${book.bookid }" name="bookid" id="bookid" />
	书名：${book.bookName }<br />
	价格：${book.bookPrice }<br />
	请选择扣款账户：
		<select name="accid" onchange="showbalance(this.value);">
			<option value="0">--请选择扣款账户--</option>
			<c:forEach items="${acclist }" var="al">
				<option value="${al.accid }">${al.accid }</option>
			</c:forEach>
		</select>
		余额：<span id="mybalance"></span>
	<input type="submit" value="支 付" />
</form>

</body>
</html>