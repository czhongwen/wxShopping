<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="modle.*"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.*"%>
<%@ page import="factory.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
<script src="ckeditor/ckeditor.js"></script>
<script src="ckfinder/ckfinder.js"></script>
<%
	IndexTypeDao itd = IndexTypeFactory.getInstance();
	List<IndexType> indexList = itd.getAll();
	int pType=0;
	if(session.getAttribute("pType")!=null){
		pType=(int)session.getAttribute("pType");
	}
%>
<script type="text/javascript">
	function getSelect() {
		var s = document.getElementById("type").value;
		alert(s)
	}
	function BrowseServer(inputId) {
		var finder = new CKFinder();
		finder.BasePath = 'ckfinder/';
		finder.selectActionFunction = SetFileField;
		finder.selectActionData = inputId;
		finder.popup();
	}
	function SetFileField(fileUrl, data) {
		document.getElementById(data["selectActionData"]).value = fileUrl;
	}
	function Juge(updateform) {
		if (updateform.pName.value == "") {
			window.alert("请输入商品名称！");
			updateform.pName.focus();
			return (false);
		}
		if (updateform.pDetail.value == "") {
			window.alert("请输入商品描述！");
			updateform.pDetail.focus();
			return (false);
		}
		if (updateform.pType.value == "") {
			window.alert("请选择商品类型！");
			updateform.pType.focus();
			return (false);
		}
		if (updateform.pic1.value == "") {
			window.alert("请选择商品图片一！");
			updateform.pic1.focus();
			return (false);
		}
		if (updateform.pic2.value == "") {
			window.alert("请选择商品图片二！");
			updateform.pic2.focus();
			return (false);
		}
		if (updateform.pic3.value == "") {
			window.alert("请选择商品图片三！");
			updateform.pic3.focus();
			return (false);
		}
		if (updateform.pic4.value == "") {
			window.alert("请选择商品图片四！");
			updateform.pic4.focus();
			return (false);
		}
		if (updateform.pic5.value == "") {
			window.alert("请选择商品图片五！");
			updateform.pic5.focus();
			return (false);
		}
		if (updateform.pPrice.value == "") {
			window.alert("请输入商品价格！");
			updateform.pPrice.focus();
			return (false);
		}
		if (isNaN(updateform.pPrice.value)) {
			alert("价格不能是字符!");
			updateform.pPrice.focus();
			return false;
		}
		if (updateform.pNum.value == "") {
			window.alert("请输入商品数量！");
			updateform.pNum.focus();
			return (false);
		}
		if (isNaN(updateform.pNum.value)) {
			alert("商品数量不能是字符!");
			updateform.pNum.focus();
			return false;
		}
		if (updateform.intro.value == "") {
			window.alert("请编辑商品介绍信息！");
			updateform.intro.focus();
			return (false);
		}
	}
</script>
</head>
<body>
	<div>
	<form action="./AddProductServlet" name="updateform" onsubmit="return Juge(this)" style="margin-left:15%;">
		<table>
			<tr>
				<td>商品名称: <input type="text" name='pName' /><font color="red">*</font>
				</td>

				<td>商品描述: <input type="text" name='pInfo' /><font color="red">*</font>
				</td>

				<td>商品种类: <select onChange="getSelect()" id='type'>
						<option value="大分类">请选择大分类</option>
						<%
							int i = 0;
							for (IndexType it : indexList) {
								List<IndexDetail> indexDetail = it.getListId();
						%>
						<option value="<%=it.getItId()%>"><%=it.getItName()%></option>
						<%
							i++;
							}
						%>
				</select> <select name="pType">
						<option value="">请选择小分类</option>
						<%
							for (IndexType it : indexList) {
								List<IndexDetail> indexDetail = it.getListId();
								for (IndexDetail id : indexDetail) {
									if(id.getIdId()==pType){
									%>
										<option value="<%=id.getIdId()%>" selected = "selected"><%=id.getIdName()%></option>	
									<%
									}else{
									%>
										<option value="<%=id.getIdId()%>"><%=id.getIdName()%></option>
									<%
									}
								}
							}
						%>
				</select>
				</td>
			</tr>
			<tr>
				<td>商品图一: <input type="text" name="pic1" id="pic1"
					onclick="BrowseServer('pic1');"><font color="red">*</font>
				</td>
				<td>商品图二: <input type="text" name="pic2" id="pic2"
					onclick="BrowseServer('pic2');"><font color="red">*</font>
				</td>
				<td>商品图三: <input type="text" name="pic3" id="pic3"
					onclick="BrowseServer('pic3');"><font color="red">*</font>
				</td>
			</tr>
			<tr>
				<td>商品图四: <input type="text" name="pic4" id="pic4"
					onclick="BrowseServer('pic4');"><font color="red">*</font>
				</td>
				<td>商品图五: <input type="text" name="pic5" id="pic5"
					onclick="BrowseServer('pic5');"><font color="red">*</font>
				</td>
				<td>商品价格: <input type="text" name='pPrice' ></input><font
					color="red">*</font>
				</td>
			</tr>
			<tr>
				<td>商品数量: <input type="text" name='pNum' value="99"></input><font
					color="red">*</font>
				</td>
				<td><input type="submit" value='保存'></input> <input
					type="reset" value='取消'></input></td>
			</tr>
		</table>
		<textarea name="intro" id="editor"></textarea>
	</form>
	<script type="text/javascript">
		CKEDITOR.replace('intro');
	</script>
	</div>
</body>
</html>