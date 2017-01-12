<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Goreal Planes</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<s:include value="/include/bootstrap.jsp"></s:include>
<link rel="stylesheet" href="css/navbar.css">
</head>
<body>

<s:include value="/include/navbar.jsp"></s:include>
  
<div class="container-fluid" id="mainContainer">

<s:if test="%{#session.loginError==true}">
	<div class="alert alert-danger alert-dismissable fade in">
		<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
	    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		Username or password incorrect.
	</div>
</s:if>

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
			<s:iterator var="flight" value="#session.flightList">
				<s:if test="#session.user.userType.description.equals('Passenger')">
					<s:set var="highlight" value = "%{false}" />
					<s:iterator var="ticket" value="#session.user.tickets">
						<s:if test="#ticket.flight.idFlight == #flight.idFlight">
							<s:set var="highlight" value = "%{true}"/>
						</s:if>
					</s:iterator>
					<s:if test="#highlight == true">
						<tr class="info">
					</s:if>
					<s:else>
						<tr>
					</s:else>
				</s:if>
				<s:else>
					<tr>
				</s:else>
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
	<s:if test="#session.user.userType.description.equals('Passenger')">
		<p>Pasajero</p>
	</s:if>
	<s:if test="#session.user.userType.description.equals('Airline')">
		<p>Airline</p>
	</s:if>
	<s:if test="#session.user.userType.description.equals('Airport_Controller')">
		<p>Airport_controller</p>
	</s:if>
	
</div>	

</body>
</html>