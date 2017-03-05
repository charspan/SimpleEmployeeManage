<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<link type="text/css"  rel="stylesheet"  href="dtree.css" >
</head>
<body bgColor="#DDF0FB" leftMargin="0" topMargin="0"  marginwidth="0" marginheight="0">
<div class="dtree">
<script type="text/javascript" src="dtree.js"></script>
<script type="text/javascript">
	d=new dTree('d');
	d.add('01','-1','员工管理系统');
	d.add('0101','01','人力资源部');
	d.add('010101','0101','部门管理','${pageContext.request.contextPath}/department_findAll.action','','right');
	d.add('010102','0101','员工管理','${pageContext.request.contextPath}/employee_findAll.action','','right');
	document.write(d);
</script>
</div>
</body>
</html>