<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html >
<head>
<meta charset="ISO-8859-1"/>
<title>Insert title here</title>


<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

</head>
<body>


  
  
   <nav class="navbar navbar-dark bg-dark">
  <ul class="nav nav-pills">
  <li class="nav-item">
    <a class="nav-link active" href="/adhController/listeAdherent">Liste des Adherents</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">Formulaire d'ajout</a>
  </li>
 
</ul>
</nav>


<h1 style="color: red; text-align: center">Liste des adherents</h1>



	<div align="center">

		<table class="table table-striped">
		<thead>
			<tr>
				<th>id</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Mail</th>
				<th>Password</th>
			    <th>Adresse</th>
			    <th>Ville</th>
				<th>Numero de telephone</th>
				<th>Supprimer un adhérent</th>
				<th>Modifier un adhérent</th>
			</tr>
</thead>
<tbody id="myTable">

			<c:forEach var="e" items="${listeAdherent}">

				<tr>
					<td>${e.id_adh }</td>
					<td>${e.nom }</td>
					<td>${e.prenom }</td>
					<td>${e.email}</td>
					<td>${e.password}</td>
					<td>${e.adresse}</td>
					<td>${e.ville}</td>
					<td>${e.telephone}</td>
					<td><a href="${pageContext.request.contextPath}/adhController/deleteLinkAdh/${e.id_adh}">Supprimer</a></td>
					<td><a href="${pageContext.request.contextPath}/adhController/updateLinkAdh?pId=${e.id_adh}">Modifier</a></td>
				</tr>
			</c:forEach>
			
			</tbody>
		</table>
	</div>
	
	






</body>
</html>