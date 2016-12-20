<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Passenger</title>
</head>
<body>
	<s:label>Passenger info</s:label>
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
				<td><s:property value="#flight.plane" /></td>
				<td><s:property value="#flight.flightStatus" /></td>
				<td><s:property value="#a" /></td>
				<td><s:property value="#flight.dateTimeFrom" /></td>
				<td><s:property value="#flight.airport1" /></td>
				<td><s:property value="#flight.dateTimeTo" /></td>
				<td><s:property value="#flight.airport2" /></td>
				<td><s:property value="#flight.delay" /></td>
				<td><s:property value="#flight.gateNumber" /></td>
				<td><s:property value="#flight.baggageNumber" /></td>
			</tr>
		</s:iterator>
	</table>
	<form action="pages/map.jsp" method="get" >
	<button type="submit">Map</button>
	</form>
</body>
</html>