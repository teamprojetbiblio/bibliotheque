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


<h1 style="text-align: center;color: blue;">Formulaire de recherche</h1>
  
  <div align="center">


<form:form modelAttribute="adhRech"   method="POST" action="rechercherAdhIdSubmit">

<br/>
<form:label path="id_adh">id_adh</form:label>
<form:input path="id_adh" required="required"/>

<br/>
<input type="submit" value="Rechercher">

</form:form>

</div>

<div align="center">

		<table class="table table-bordered">
			<tr>
			<th>id</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Mail</th>
				<th>Password</th>
			    <th>Adresse</th>
			    <th>Ville</th>
				<th>Numero de telephone</th>
			</tr>



				<tr>
					<td>${adhFind.id_adh }</td>
					<td>${adhFind.nom }</td>
					<td>${adhFind.prenom }</td>
					<td>${adhFind.email}</td>
					<td>${adhFind.password}</td>
					<td>${adhFind.adresse}</td>
					<td>${adhFind.ville}</td>
					<td>${adhFind.telephone}</td>
					
				</tr>		
		</table>
		
		
				
	</div>



</body>
</html>