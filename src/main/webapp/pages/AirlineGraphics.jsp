<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Airline Information</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/index.css">
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>

	<script type="text/javascript" src= "js/d3/d3.js"></script>
	<%--<script src="http://d3js.org/d3.v3.min.js" charset="utf-8"></script> --%>
	
</head>
<style>
 #chart {
        height: 360px;
        margin: 0 auto;                                         
        position: relative;
        width: 360px;
        margin-top:10px;
        margin-bottom:50px;
      }
      .tooltip {
        background: #eee;
        box-shadow: 0 0 5px #999999;
        color: #333;
        display: none;
        font-size: 12px;
        left: 130px;
        padding: 10px;
        position: absolute;
        text-align: center;
        top: 95px;
        width: 80px;
        z-index: 10;
      }
      .legend {
        font-size: 12px;
      }
      rect {
        cursor: pointer;                                          
        stroke-width: 2;
      }
      rect.disabled {                                               
        fill: transparent !important;                          
      }                                                         
      h1 {                                                   
        font-size: 14px;                                        
        text-align: center;                                      
      } 

</style>
<body>
<div id="chart">
		<h2>Percentage of flight timing</h2>
	</div>
	<script src="js/pieChart.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
});
</script>

</body>
</html>