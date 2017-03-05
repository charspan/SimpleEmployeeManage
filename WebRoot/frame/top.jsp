<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html>
<head>
<style type="text/css">
.div1 {
	margin-top: 10px;
	margin-left: 20px;
	font-size: 14px;
	color: white;
	float: right;
	font-size: 14px;
}
</style>
</head>
<body bgcolor="#0099FF">
	<div class="div1">
		欢迎您：
		<s:property value="#session.existEmployee.ename" />
	</div>
</body>
</html>