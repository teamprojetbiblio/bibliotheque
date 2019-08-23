<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
       <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body>

<h1 style="text-align: center;color: blue;">Formulaire de modification</h1>
  
  <div align="center">


<form:form modelAttribute="adhModif"   method="POST" action="adhController/updateAdhSubmit">

<br/>
<form:label path="firstName">nom</form:label>
<form:input path="firstName" required="required"/>
<br/>
<form:label path="lastName">prenom</form:label>
<form:input path="lastName" required="required"/>
<br/>
<form:label path="email">email</form:label>
<form:input path="email" required="required"/>
<br/>
<form:label path="password">mdp</form:label>
<form:input path="password" required="required"/>
<br/>
<input type="submit" value="Register">



</form:form>

</div>

</body>
</html>