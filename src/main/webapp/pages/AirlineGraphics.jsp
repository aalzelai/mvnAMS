<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Goreal Planes</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/pieChart.css">
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/d3/d3.js"></script>
<s:include value="/include/bootstrap.jsp"></s:include>
<link rel="stylesheet" href="css/navbar.css">
</head>

<body>
<s:include value="/include/navbar.jsp"></s:include>
	<div id="chart">
		<h2>Percentage of flight timing</h2>
	</div>
	<script src="js/pieChart.js"></script>
</body>
</html>