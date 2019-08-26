<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/livre.css">
<script src="${pageContext.request.contextPath}/resources/js/livre.js"></script>

<%@ include file="fragments/header.html"%>
<div class="container">
	<div class="row">
		<div class="col-sm-8">
			<h4 class="page-header">Entrer un livre</h4>

			<form role="form">
				<div class="form-group float-label-control">
					<label for="">Id livre</label> <input type="text"
						class="form-control" placeholder="Id livre" name="id_livre">
				</div>
				<div class="form-group float-label-control">
					<label for="">Titre</label> <input type="text" class="form-control"
						placeholder="Titre" name="titre">
				</div>
				<div class="form-group float-label-control">
					<label for="">Password</label> <input type="text"
						class="form-control" placeholder="Auteur" name="auteur">
				</div>
				<div class="form-group float-label-control">
					<label for="">Editeur</label> <input type="text"
						class="form-control" placeholder="Editeur" name="editeur">
					</textarea>
				</div>
				<div class="form-group float-label-control">
					<label for="">Image</label> <input type="text" class="form-control"
						placeholder="Image" name="image">
					</textarea>
				</div>
				<div class="form-group float-label-control">
					<label for="">Description</label> <input type="text"
						class="form-control" placeholder="Description" name="description">
					</textarea>
				</div>
				<div class="form-group float-label-control">
					<label for="">Catégorie</label> <input type="text"
						class="form-control" placeholder="Catégorie" name="categorie">
					</textarea>
				</div>
			</form>
		</div>
	</div>


	<div>
		<table class="table">
				<tr>
					<th>Id</th>
					<th>Titre</th>
					<th>Auteur</th>
					<th>Editeur</th>
					<th>Image</th>
					<th>Description</th>
					<th>Catégorie</th>

				</tr>
				<c:forEach var="liv" items="${livres}">
					<tr>
						<td>${liv.id_liv}</td>
						<td>${liv.titre}</td>
						<td>${liv.auteur}</td>
						<td>${liv.editeur}</td>
						<td>${liv.imgLivre}</td>
						<td>${liv.description}</td>
						<td>${liv.categorie.libelle}</td>
					</tr>
				</c:forEach>
		</table>
	</div>
	<%@ include file="fragments/footer.html"%>
	</body>