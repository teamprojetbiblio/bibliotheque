<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<ul class="">
  <li role="presentation" ><a href="<c:url value='/adhController/listeAdherent'/>">Accueil </a></li>        <!-- il faut appeler dans href l'url des methodes des Controllers et non la page -->
  <li role="presentation"><a href="<c:url value=''/>">Ajouter </a></li>
  <li role="presentation"><a href="<c:url value=''/>">Modifier </a></li>
  <li role="presentation"><a href="<c:url value=''/>">Rechercher </a></li>
  <li role="presentation"><a href="<c:url value=''/>">Supprimer </a></li>
</ul>

<h1 style="color: red; text-align: center">Liste des adherents</h1>

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
					
				</tr>
			</c:forEach>
		</table>
	</div>





</body>
</html>