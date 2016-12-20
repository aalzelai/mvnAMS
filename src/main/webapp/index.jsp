<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Struts 2 - Login Application </title>
</head>
 
<body>

<nav>
<a href="#">Goreal Planes</a>
<s:if test="%{#session.user==null}">
	<a href="#">Log in</a>
</s:if>
<s:else>
	<a href="#">Log out</a>
</s:else>
</nav>

<h2>Struts 2 - Login Application</h2>
<s:actionerror />
<s:form action="login.action" method="post">
    <s:textfield name="user.username" key="label.username" size="20" />
    <s:password name="user.password" key="label.password" size="20" />
    <s:submit method="execute" key="label.login" align="center" />
</s:form>
<s:form action="passenger" method="post">
<s:submit method="execute" key="label.passenger" align="center" />
</s:form>
</body>
</html>