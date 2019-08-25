<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"/>
<title>Insert title here</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/all.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sb-admin.css">


  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>


  
  
   <nav class="navbar navbar-dark bg-dark">
  <ul class="nav nav-pills">
  <li class="nav-item">
    <a class="nav-link active" href="/adhController/listeAdherent">Liste des Adherents</a>
  </li>
  <li class="nav-item">
     <a class="nav-link" href="/adhController/addAdhAffiche">Formulaire d'ajout</a>  
  </li>
  <li class="nav-item">
    <a class="nav-link active" href="/adhController/rechercherAdhIdAffiche">Recherche adherent par numero</a>
  </li>
 
</ul>
</nav>







<h1 style="color: red; text-align: center">Liste des adherents</h1>

 <div class="container">

  <h2>Champs de recherche</h2>
  <p>Filtrage réalisé sur tout les champs de la table</p>  
  <input class="form-control" id="myInput" type="text" placeholder="Search..">
  <br>




        <div class="card mb-3">
          <div class="card-header">
            Table d'adherents</div>
          <div class="card-body">
            <div class="table-responsive">
		<table id="dataTable" class="table table-bordered" cellspacing="0" width="100%" border="1">
		<thead class="thead-light">
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
				<tr class="table-active">
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
	</div>
</div>
</div>


<script>
/*$(document).ready(function() {
    $('#infos').show();
});*/

</script>




<script>
//recherche :
$(document).ready(function(){
	  $("#myInput").on("keyup", function() {
	    var value = $(this).val().toLowerCase();
	    $("#myTable tr").filter(function() {
	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
	  });
	});
</script>





<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/dataTables.bootstrap4.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.easing.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/sb-admin.min.js"></script>
 <script src="${pageContext.request.contextPath}/resources/js/datatables-demo.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/chart-area-demo.js"></script>


</body>
</html>