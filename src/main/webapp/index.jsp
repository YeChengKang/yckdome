<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basepath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
function prebuybook(bookid,bookPrice) {
	location = "uc/findAccount?bookid="+bookid+",bookPrice="+bookPrice;
}

</script>
</head>
<body>

	<h3>这里是index.jsp页面</h3>
	<table>
		<tr>
			<td>编号</td>
			<td>${bookname.bookid }</td>
		</tr>
		<tr>
			<td>名字</td>
			<td>${bookname.bookName }</td>
		</tr>
		<tr>
			<td>出版社</td>
			<td>${bookname.publicDept }</td>
		</tr>
		<tr>
			<td>价格</td>
			<td>${bookname.bookPrice }</td>
		</tr>
		<tr>
			<td>出版日期</td>
			<td>${bookname.publicDate }</td>
		</tr>
		<tr>
			<td>作者</td>
			<td>${bookname.bookAuth }</td>
		</tr>
		<tr>
			<td>图片</td>
			<td><img src="${bookname.imgPath }" width="200"></td>
		</tr>
		<tr>
			<td>内容简介</td>
			<td>${bookname.summary }</td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="直接购买" onclick="prebuybook('${bookname.bookid}','${bookname.bookPrice }');" /></td>
		</tr>
	</table>

</body>
</html>