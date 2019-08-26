<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" --%>
<%--     pageEncoding="ISO-8859-1"%> --%>
    
<%--     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<!-- <!DOCTYPE html> -->
<!-- <html > -->
<!-- <head> -->
<!-- <meta charset="ISO-8859-1"/> -->
<!-- <title>Insert title here</title> -->


<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css"> --%>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css"> --%>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"> --%>

<!-- </head> -->
<!-- <body> -->
<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
	 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	 <c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="pagina" value="${requestScope['javax.servlet.forward.request_uri']}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Ma Biblio</title>
</head>
<body>
<header class="container-fluid">
<nav class=" container navbar navbar-light bg-light justify-content-start">
		<a class="navbar-brand" href="#">Navbar</a>
		<ul class="nav nav-tabs">
			<li class="nav-item"><a class="nav-link  active" href="#">Tableau
					de bord</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Gestion des livres</a></li>
			<li class="nav-item"><a class="nav-link   ${pagina.endsWith('/adhController/listeAdherent') ? 'active' : ''}" href="/adhController/listeAdherent">Gestion des adhérents</a></li>
			
			<li class="nav-item"><a class="nav-link" href="#"
				tabindex="-1" aria-disabled="true">Disabled</a></li>
		</ul>
	</nav>
</header>

  
  
<!--    <nav class="navbar navbar-dark bg-dark"> -->
<!--   <ul class="nav nav-pills"> -->
<!--   <li class="nav-item"> -->
<!--     <a class="nav-link active" href="/adhController/listeAdherent">Liste des Adherents test</a> -->
<!--   </li> -->
<!--   <li class="nav-item"> -->
<!--     <a class="nav-link" href="#">Formulaire d'ajout</a> -->
<!--   </li> -->
 
<!-- </ul> -->
<!-- </nav> -->


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
	
	




<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

</body>
</html>