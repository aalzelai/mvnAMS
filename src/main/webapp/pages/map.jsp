<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="struts.action.MapAction" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://openlayers.org/en/v3.20.1/css/ol.css" type="text/css">
<link rel="stylesheet" href="css/map.css" type="text/css">
<!-- The line below is only needed for old environments like Internet Explorer and Android 4.x -->
<script src="https://cdn.polyfill.io/v2/polyfill.min.js?features=requestAnimationFrame,Element.prototype.classList,URL"></script>
<script type="text/javascript" charset="UTF-8" src="js/map.js"></script>
<script src="https://openlayers.org/en/v3.20.1/build/ol.js"></script>
<title>Current Flight</title>


  <script type="text/JavaScript">
  		setInterval(function(){
	  	var flights = <s:property value="data"/>;
	    document.getElementById('hiddenData').value = flights;
	   //reloadMap();
		}, 5000);
  </script>
</head>
<body>
   <div id="map" class="map"></div>
   <input type="text" id="hiddenData" value="0"/>
   <script type="text/JavaScript">
	$(document).ready(function() {
	    var flights = <s:property value="data"/>;
	    document.getElementById('hiddenData').value = flights;
	    
	    createMap();
	    });
  </script>
  		<% MapAction action = new MapAction();
  		System.out.println("Voy a hacer cosas");
	  	action.execute();	%>
</body>
</html>