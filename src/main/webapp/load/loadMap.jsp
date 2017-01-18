<%@ page language="java"%>
<%@ page import="struts.action.MapAction" %>

    
    <% MapAction ma = new MapAction(); 
       String data = ma.getFlightData();
    %>
    
    <input type="hidden" id="hiddenData" value="<%=data%>"/>