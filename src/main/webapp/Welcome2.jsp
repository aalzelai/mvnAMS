<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Welcome</title>
</head>
 
<body>
    <h1>Hola</h1>
    <s:iterator var="counter" begin="1" end="5" >
	   <!-- current iteration value (1, ... 5) -->
	   <s:property value="top" />
	</s:iterator>
    
    <table border="1px solid black">
    	<tr>
    		<th>Hola1</th>
    		<th>Hola2</th>
    		<th>Hola3</th>
    	</tr>
	    <s:iterator var="users" value="userList">
	    <tr>
			<td><s:property value="#users.idUser"/></td>
			<td><s:property value="#users.username"/></td>
			<td><s:property value="#users.password"/></td>
		</tr>
		</s:iterator>
    </table>
    
</body>
</html> 