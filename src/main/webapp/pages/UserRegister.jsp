<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Goreal planes</title>
<s:include value="/include/bootstrap.jsp"></s:include>
<script src="js/register.js"></script></head>
<link rel="stylesheet" href="css/navbar.css">
<body>
<s:include value="/include/navbar.jsp"></s:include>
<div class="container">
	<h1>Register</h1>
	<form action="register.action" method="post">
		<div class="form-group">
		<select class="selectpicker" id="userTypeSel" name="typeSelect">
		   <option value="0">-- Choose One --</option>       
		   <option value="Passenger">Passenger</option>
		   <option value="Airline">Airline</option>
		   <option value="Control">Airport controller</option>
		</select>
		</div>
		<div class="form-group">
		<label>Username: </label>
		<input type="text" class="form-control" name="username" placeholder="Insert your username" required>
		</div>
		<div class="form-group">
		<label>Password: </label>
		<input type="password" class="form-control" name="password" placeholder="Insert your password" required>
		</div>
		<div class="form-group selHide selPassenger">
		<label>Telephone: </label>
		<input type="tel" class="form-control" name="telephone" placeholder="Insert your telephone" required>
		</div>
		<div class="form-group selHide selPassenger">
		<label>E-mail: </label>
		<input type="email" class="form-control" name="email" placeholder="Insert your email" required>
		</div>
		<div class="form-group selHide selAirline">
		<label>Airline: </label>
			<div id="airlineSel">
			</div>
		</div>
		<div class="form-group selHide selControl">
		<label>Airport: </label>
			<div id="airportSel">
			</div>
		</div>
		<input type="submit" class="btn btn-success" id="submit" name="method:register" value="Register" disabled>
	</form>
</div>

</body>
</html>