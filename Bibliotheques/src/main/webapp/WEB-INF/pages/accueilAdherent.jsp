<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
            <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


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
  <li class="nav-item">
    <a class="nav-link active" href="/adhController/rechercherAdhIdAffiche">Recherche adherent par numero</a>
  </li>
 
</ul>
</nav>


<h1 style="color: red; text-align: center">Liste des adherents</h1>


<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Ajouter</button>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">New message</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="nom" class="col-form-label">Nom :</label>
            <input type="text" class="form-control" id="nom">
          </div>
          <div class="form-group">
            <label for="prenom" class="col-form-label">Prenom :</label>
            <textarea class="form-control" id="prenom"></textarea>
          </div>
           <div class="form-group">
            <label for="email" class="col-form-label">Email :</label>
            <textarea class="form-control" id="email"></textarea>
          </div>
           <div class="form-group">
            <label for="password" class="col-form-label">Password :</label>
            <textarea class="form-control" id="password"></textarea>
          </div>
           <div class="form-group">
            <label for="adresse" class="col-form-label">Adresse :</label>
            <textarea class="form-control" id="adresse"></textarea>
          </div>
          <div class="form-group">
            <label for="ville" class="col-form-label">Ville :</label>
            <textarea class="form-control" id="adresse"></textarea>
          </div>
          <div class="form-group">
            <label for="telephone" class="col-form-label">Telephone :</label>
            <textarea class="form-control" id="telephone"></textarea>
          </div>
          
           <button type="button" class="btn btn-primary">Ajouter</button>
          
          
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>



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
	

<script>
$('#exampleModal').on('show.bs.modal', function (event) {
	  var button = $(event.relatedTarget) // Button that triggered the modal
	  var recipient = button.data('whatever') // Extract info from data-* attributes
	  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
	  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
	  var modal = $(this)
	  modal.find('.modal-title').text('New message to ' + recipient)
	  modal.find('.modal-body input').val(recipient)
	})
</script>

<script src="${pageContext.request.contextPath}/resources/js/jQuery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jQuery.dataTables.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>





</body>
</html>