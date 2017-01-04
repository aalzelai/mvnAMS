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

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#collapseNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-plane"></span> Goreal planes</a>
    </div>
    <div class="collapse navbar-collapse" id="collapseNavbar">
      <ul class="nav navbar-nav">
        <li><a href="#">Home</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
     	<s:if test="%{#session.user==null}">
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-log-in"></span> Log in</a>
				<ul class="dropdown-menu" id="loginMenu">
	            	<li>
	            		<div class="row">
								<div class="col-md-12">
									 <form class="form" role="form" method="post" action="login.action" accept-charset="UTF-8" id="login-nav">
										 <div class="form-group input-group">
										    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
										    <input id="username" type="text" class="form-control" name="username" placeholder="Username" required>
										  </div>
										  <div class="form-group input-group">
										    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
										    <input id="password" type="password" class="form-control" name="password" placeholder="Password" required>
										  </div>
											<div class="checkbox">
												 <label><input type="checkbox"> Remember me</label>
											</div>
											<div class="form-group">
												 <button type="submit" class="btn btn-primary btn-block">Sign in</button>
											</div>
									 </form>
								</div>
						 </div>
						 <div class="row">
						  	<div class="bottomText text-center">
									No account? <a href="#"><b>Register here</b></a>
							</div>
						 </div>
	            	</li>
	          	</ul>
	         </li>
		</s:if>
		<s:else>
			<li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
		</s:else>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid" style="margin-top:60px">

	<table class="table table-striped table-hover">
		<tr>
			<th>Id</th>
			<th>Type B</th>
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
	
	
<s:actionerror />
<s:form action="login.action" method="post" theme="simple">
    <s:textfield name="user.username" key="error.login" size="20"/>
    <s:password name="user.password" key="label.password" size="20" />
    <s:submit method="execute" key="label.login" align="center" />
</s:form>

  
</div>
</body>
</html>