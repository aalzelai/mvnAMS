<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

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
        <s:if test="%{#session.user.userType.description.equals('Airline') || #session.user.userType.description.equals('Airport_Controller')}">
			<li><a href="map.action"><span class="glyphicon glyphicon-map-marker"></span> Map</a></li>
		</s:if>
      </ul>
      <ul class="nav navbar-nav navbar-right">
     	<s:if test="%{#session.user==null}">
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-log-in"></span> Log in</a>
				<ul class="dropdown-menu" id="loginMenu">
	            	<li>
	            		<div class="row">
								<div class="col-md-12">
									 <form action="login.action" method="post" >
										 <div class="form-group input-group">
										    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
										    <s:textfield name="user.username" cssClass="form-control" placeholder="%{getText('label.username')}" required="required"/>
										  </div>
										  <div class="form-group input-group">
										    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
										    <s:password name="user.password" cssClass="form-control" placeholder="%{getText('label.password')}" required="required"/>
										  </div>
											<div class="checkbox">
												 <label><input type="checkbox"> Remember me</label>
											</div>
											<div class="form-group">
												 <s:submit method="execute" cssClass="btn btn-primary btn-block" key="label.singin"/>
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
			<li><a href="logout.action"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
		</s:else>
      </ul>
    </div>
  </div>
</nav>