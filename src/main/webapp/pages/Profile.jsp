<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Goreal planes</title>
<s:include value="/include/bootstrap.jsp"></s:include>
<link rel="stylesheet" href="css/navbar.css">
</head>
<body>
<s:include value="/include/navbar.jsp"></s:include>

<div class="container">
	<h1>Profile</h1>
		<s:if test="#request.edit == true">
		 	<form action="saveEditedUser" method="post">
				<div class="form-group">
				<label>Username: </label>
				<input type="text" class="form-control" name="username" value='<s:text name="#session.user.username"></s:text>'>
				</div>
				<div class="form-group">
				<label>Password: </label>
				<input type="password" class="form-control" name="password" value='<s:text name="#session.user.password"></s:text>'>
				</div>
				<s:if test="#session.user.userType.description.equals('Passenger')">
					<div class="form-group">
					<label>Telephone: </label>
					<input type="tel" class="form-control" name="telephone" value='<s:text name="#session.user.telephone"></s:text>'>
					</div>
					<div class="form-group">
					<label>E-mail: </label>
					<input type="email" class="form-control" name="email" value='<s:text name="#session.user.email"></s:text>'>
					</div>
				</s:if>
				<input type="submit" class="btn btn-success" value="Save">
				<a href="seeProfile" class="btn btn-default" role="button">Cancel</a>
		 	</form>
		</s:if>
		
		<s:else>
			<div class="form-group">
			<label>Username: </label>
			<input type="text" class="form-control" name="username" value='<s:text name="#session.user.username"></s:text>' disabled>
			</div>
			<div class="form-group">
			<label>Password: </label>
			<input type="password" class="form-control" name="password" value='<s:text name="#session.user.password"></s:text>' disabled>
			</div>
			<s:if test="#session.user.userType.description.equals('Passenger')">
				<div class="form-group">
				<label>Telephone: </label>
				<input type="tel" class="form-control" name="telephone" value='<s:text name="#session.user.telephone"></s:text>' disabled>
				</div>
				<div class="form-group">
				<label>E-mail: </label>
				<input type="email" class="form-control" name="email" value='<s:text name="#session.user.email"></s:text>' disabled>
				</div>
			</s:if>
			
			<a href="editUser" class="btn btn-warning" role="button">Edit</a>
			<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">Delete</button>
			
			<div id="deleteModal" class="modal fade" role="dialog">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">Delete your user</h4>
			      </div>
			      <div class="modal-body">
			        <p>Are sure do you want to delete your user?</p>
			      </div>
			      <div class="modal-footer">
			     	<a href="deleteUser" class="btn btn-danger" role="button">Delete</a>
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			      </div>
			    </div>
			
			  </div>
			</div>
		
		</s:else>
		
</div>
</body>
</html>
