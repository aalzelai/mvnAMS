<%@ page language="java"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>   
<%@page import="java.util.List"%>
<%@page import="domain.model.Airline"%>
<%@page import="domain.model.Airport"%>
<%@page import="struts.action.RegisterAction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%
    	RegisterAction ra = new RegisterAction();
    	List<Airline> listAirlines = null;
    	List<Airport> listAirport = null;
    
    	if (request.getParameter("type").equals("Airline")){
    		listAirlines = ra.getAirlines();
    	} else if (request.getParameter("type").equals("Control")){
    		listAirport = ra.getAirports();
    	}
    %>

    <s:if test="%{#parameters.type[0] == 'Airline'}">
    	<select class="selectpicker" name="airline" id="selectAirline">
   		
   		<% for(Airline line : listAirlines) { %>
   			<option value="<%=line.getIdAirline() %>">
				<%=line.getName() %>
			</option>
   		<% } %>
	
   		</select>
    </s:if>
    <s:else>
    	<select class="selectpicker" name="airport" id="selectAirport">
   		
   		<% for(Airport port : listAirport) { %>
   			<option value="<%=port.getIdAirport() %>">
				<%=port.getName() %>
			</option>
   		<% } %>
	
   		</select>
    </s:else>
   	
