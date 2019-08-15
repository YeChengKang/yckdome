<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
</head>
<body>
	
	<h3>这里是reg.jsp页面</h3>
	<form action="bc/reg" method="post" enctype="multipart/form-data">
		书籍编号：<input type="text" name="bookid" value="1009"/><br />
		书籍名称：<input type="text" name="bookName" value="三国演义" /><br />
		出版社名称：<input type="text" name="publicDept" value="清华大学出版社" /><br />
		书籍价格：<input type="text" name="bookPrice" value="40.00" /><br />
		出版时间：<input type="text" name="publicDate" value="2019-8-10" /><br />
		书籍作者：<input type="text" name="bookAuth" value="罗贯中" /><br />
		图片路径：<input type="file" name="pic" /><br />
		内容简介：<input type="text" name="summary" value="公元三世纪东汉末年，以曹操、刘备、孙权为首的魏蜀吴三个政治、军事集团之间的矛盾和斗争。由于各国后主过于无能而亡国。" /><br />
		<input type="submit" value="添  加" /><br />
	</form>

</body>
</html>