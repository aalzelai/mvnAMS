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
			<th>Hangar</th>
			<th>Pista</th>
			<th>Puerta</th>
		</tr>
		<s:iterator var="flight" value="lstFlights">
			<tr>
				<td><s:property value="flight.id" /></td>
				<td><s:property value="flight.airplane" /></td>
				<td><s:property value="flight.estate" /></td>
				<td><s:property value="flight.id" /></td>
				<td><s:property value="flight.time_In" /></td>
				<td><s:property value="flight.airport_In" /></td>
				<td><s:property value="flight.time_Out" /></td>
				<td><s:property value="flight.airport_Out" /></td>
				<td><s:property value="flight.id" /></td>
				<td><s:property value="flight.id" /></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>