<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
            <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 style="text-align: center;color: blue;">Formulaire d'ajout</h1>
  
  <div align="center">


<form:form modelAttribute="adhAjout"   method="POST" action="addAdhSubmit">


<br/>
<form:label path="nom">nom</form:label>
<form:input path="nom" required="required"/>
<br/>
<form:label path="prenom">prenom</form:label>
<form:input path="prenom" required="required"/>
<br/>
<form:label path="email">email</form:label>
<form:input path="email" required="required"/>
<br/>
<form:label path="password">password</form:label>
<form:input path="password" required="required"/>
<br/>
<form:label path="adresse">adresse</form:label>
<form:input path="adresse" required="required"/>
<br/>
<form:label path="ville">ville</form:label>
<form:input path="ville" required="required"/>
<br/>
<form:label path="telephone">telephone</form:label>
<form:input path="telephone" required="required"/>
<br/>
<input type="submit" value="Ajouter">

</form:form>

</div>


</body>
</html>