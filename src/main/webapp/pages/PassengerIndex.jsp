<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Goreal Planes</title>
</head>
<body>


	<table border="1px solid black">
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
	</table>
</body>
</html>