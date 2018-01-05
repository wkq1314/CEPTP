<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加角色</title>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	//添加行
	function addTable() {
		var tab = document.getElementById("viewTabs"); //获得表格
		var colsNum = tab.rows.item(0).cells.length; //表格的列数
		//表格当前的行数 
		var num = document.getElementById("viewTabs").rows.length;
		var rownum = num;
		tab.insertRow(rownum);
		for (var i = 0; i < 4; i++) {
			tab.rows[rownum].insertCell(i);//插入列
			if (i == 0) {
				tab.rows[rownum].cells[i].innerHTML = '<input type="text" class="form-control" name="user_name"'
					+'value="">';
			} else if (i == 1) {
				tab.rows[rownum].cells[i].innerHTML = '<input type="text" class="form-control" name="user_number"'
					+'value="">';
			} else if (i == 2) {
				tab.rows[rownum].cells[i].innerHTML = '<input type="text" class="form-control"'
					+'name="user_gender" value="">';
			} else {
				tab.rows[rownum].cells[i].innerHTML = '<input type="text" class="form-control"'
					+'name="user_dept" value="">';
			}
		}
		tab.rows[rownum].insertCell(i);
		tab.rows[rownum].cells[i].innerHTML = '<a href="#" onclick="delRow(this)">删除行</a>';
	}
	//删除行
	function delRow(obj) {
		var Row = obj.parentNode;
		var Row = obj.parentNode; //tr
		while (Row.tagName.toLowerCase() != "tr") {
			Row = Row.parentNode;
		}
		Row.parentNode.removeChild(Row); //删除行
	}
</script>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"> 添加用户</a>
		</div>
	</div>
	</nav>

	<table class="table table-striped  bandTable" id="viewTabs">
		<thead>
			<tr>
				<th>姓名</th>
				<th>工号</th>
				<th>性别</th>
				<th>系部</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><input type="text" class="form-control" name="user_name"
					value=""></td>
				<td><input type="text" class="form-control" name="user_number"
					value=""></td>
				<td><input type="text" class="form-control"
					name="user_gender" value=""></td>
				<td><input type="text" class="form-control"
					name="user_dept" value=""></td>
				<td></td>
			</tr>
		</tbody>
		<table>
			<div style="text-align: center">
				<button type="button" class="btn btn-success" onclick="addTable();">添加用户</button>
			</div>
</body>
</html>