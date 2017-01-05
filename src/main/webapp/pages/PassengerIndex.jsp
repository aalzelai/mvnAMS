<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Goreal Planes</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/index.css">
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>

<s:include value="/include/navbar.jsp"></s:include>
  
<div class="container-fluid" id="mainContainer">

	<table class="table table-striped table-hover table-bordered">
		<thead class="thead-default">
			<tr>
				<th>Id</th>
				<th>Type</th>
				<th>State</th>
				<th>Company</th>
				<th>Time out</th>
				<th>Place out</th>
				<th>Time arrive</th>
				<th>Place arrive</th>
				<th>Delay</th>
				<th>Gate number</th>
				<th>Baggage number</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator var="flight" value="flightList">
				<tr>
					<td><s:property value="#flight.idFlight" /></td>
					<td><s:property value="#flight.plane.planeType.description" /></td>
					<td><s:property value="#flight.flightStatus.description" /></td>
					<td><s:property value="#flight.plane.airline.name" /></td>
					<td><s:property value="#flight.timeFrom" /></td>
					<td><s:property value="#flight.airport1.name" /></td>
					<td><s:property value="#flight.timeTo" /></td>
					<td><s:property value="#flight.airport2.name" /></td>
					<td><s:property value="#flight.delay" /></td>
					<td><s:property value="#flight.gateNumber" /></td>
					<td><s:property value="#flight.baggageNumber" /></td>
				</tr>
			</s:iterator>
		</tbody>
		
	</table>
  
</div>
</body>
</html>