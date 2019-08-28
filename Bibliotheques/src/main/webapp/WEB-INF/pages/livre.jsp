<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
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

			<form method="POST" action="saveMyLivres">
				<div class="form-group float-label-control">
					<label for="">Titre</label> <input type="text" class="form-control"
						placeholder="Titre" name="titre">
				</div>

				<div class="form-group float-label-control">
					<label for="">Auteur</label> <input type="text"
						class="form-control" placeholder="Auteur" name="auteur">
				</div>

				<div class="form-group float-label-control">
					<label for="">Editeur</label> <input type="text"
						class="form-control" placeholder="Editeur" name="editeur">
				</div>

				<div class="form-group float-label-control">
					<label for="">Image</label> <input type="text" class="form-control"
						placeholder="Image" name="imgLivre">
				</div>

				  <div class="form-group float-label-control">
                        <label for="">Description</label>
                        <textarea class="form-control" placeholder="Description" name = "description" rows="1"></textarea>
                    </div>


				<div class="form-group float-label-control">
					<label for="categorie">Categories</label> 		
					<select style ="background: transparent" 
						class="form-control" name="categorie" id="categorie">
						<option value="">Choisissez Cat</option>
						<c:forEach items="${categories}" var="category">
							<option value="${category.id_cat}">${category.libelle }</option>
						</c:forEach>
					</select>
				</div>
				
				<div>
				<button>Sauvegarder le livre</button>
				</div>
			</form>
		</div>
	</div>

	<div>
		<table class="table table-striped table-responsive-md btn-table">
			<tr>
				<th>Code ISBN</th>
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
					<td><div><img id="images" src="${liv.imgLivre}" ></div></td>
					<td>${liv.description}</td>
					<td>${liv.categorie.libelle}</td>
				</tr>
			</c:forEach>
		</table> 
	</div>
	<%@ include file="fragments/footer.html"%>
