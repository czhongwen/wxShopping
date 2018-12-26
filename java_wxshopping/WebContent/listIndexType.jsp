<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="modle.*"%>
<%@ page import="modleDaoImpl.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>页面导航分类管理</title>
<%
IndexTypeDaoImpl itdi=new IndexTypeDaoImpl();
List<IndexType> indexTypeList = itdi.getAll(); 
%>
</head>
<body>
	<table style="border: 1px solid;">
		<%for(IndexType it:indexTypeList) {%>
		<tr>
			<td style="border: 1px solid;">编号:<%=it.getItId() %></td>
			<td style="border: 1px solid;">图片:<%=it.getItImage() %></td>
			<td style="border: 1px solid;">名称:<%=it.getItName()%></td>
		</tr>
		<%} %>
	</table>
</body>
</html>