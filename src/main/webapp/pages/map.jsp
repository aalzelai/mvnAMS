<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="js/map.js"></script>
<link rel="stylesheet" href="https://openlayers.org/en/v3.20.1/css/ol.css" type="text/css">
<link rel="stylesheet" href="css/map.css" type="text/css">
    <!-- The line below is only needed for old environments like Internet Explorer and Android 4.x -->
    <script src="https://cdn.polyfill.io/v2/polyfill.min.js?features=requestAnimationFrame,Element.prototype.classList,URL"></script>
    <script src="https://openlayers.org/en/v3.20.1/build/ol.js"></script>
<title>Current Flight</title>

</head>
<body>
   <s:if test="#session.user.userType.description.equals('Airline')">
		<s:set var="sessionType" value = "#session.user.airline.idAirline" />
		</s:if>
		<script type="text/JavaScript">
	$(document).ready(function() {
	    var flights = <s:property value="data"/>;
	    document.getElementById('hiddenData').value = flights;
	    createMap(<s:property value="#sessionType"/>);
	    });
  </script>
  <script type="text/JavaScript">
  	window.setInterval(function(){
  		$('#dataDiv').load('./load/loadMap.jsp', function(){
    		reloadMap(<s:property value="#sessionType"/>);
    	});
		}, 300);
  </script>
   <div id="map" class="map"></div>
   <div id="dataDiv">

   		<input type="hidden" id="hiddenData" value="0"/>
   </div>
</body>
</html>