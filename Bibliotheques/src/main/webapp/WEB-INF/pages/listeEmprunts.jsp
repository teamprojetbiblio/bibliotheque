<%@ include file="fragments/header.html"%>

<h2 class="mt-4 mb-3">Emprunts</h2>

<form action="index" method="GET">
	<div class="d-flex justify-content-around">

		<div class="form-group">
			<label>Rechercher : </label> <select class="form-control"
				name="filtre">
				<option value="all">Tous</option>
				<option value="idEmp">N° emprunt</option>
				<option value="idAdh">N° adhérent</option>
				<option value="nomAdh">Nom adhérent</option>
				<option value="titreLiv">Titre livre</option>
				<option value="idExem">N° exemplaire</option>
				<option value="dateEmp">Date emprunt</option>
			</select>
		</div>

		<div class="form-group">
			<label>Mot clé : </label> <input class="form-control" type="text"
				name="mc" id="search" />
		</div>
		<div class="form-group">
			<button type="submit">Chercher</button>
		</div>
	</div>
</form>

<fieldset>
	<legend class="ml-2 pl-2 pr-2"> Liste des emprunts </legend>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>N° emprunt</th>
				<th>N°adhérent</th>
				<th>Nom adhérent</th>
				<th>Titre livre</th>
				<th>N° exemplaire</th>
				<th>Etat</th>
				<th>Date emprunt</th>
				<th>Date retour</th>
			</tr>
		</thead>
		<tbody id="myTable">
			<c:forEach var="e" items="${listeEmprunts}">
				<tr data-toggle="modal" data-target="#retourModal">

					<td>${e.id_emp}</td>
					<td>${e.adherent.id_adh}</td>
					<td>${e.adherent.nom}</td>
					<td>${e.exemplaire.livre.titre}</td>
					<td>${e.exemplaire.id_exe}</td>
					<td>${e.exemplaire.etat}</td>
					<td>${e.dateEmprunt}</td>
					<td>${e.dateRetour}</td>

				</tr>
				
				

				<!-- Modal -->
				<div class="modal fade" id="retourModal" tabindex="-1" role="dialog"
					aria-labelledby="exampleModalLabel" aria-hidden="false">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Retour
									emprunt</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<form>
									<div class="d-flex">
										<div class="form-group">
											<label for="idEmp">N° emprunt : </label> <input type="number"
												class="form-control" name="idEmp" value="${e.id_emp}">
										</div>
										<div class="form-group">
											<label for="exemplaire">N°exemplaire : </label> <input
												type="number" class="form-control" name="exemplaire"
												value="${e.exemplaire.id_exe}">
										</div>
									</div>

									<div class="form-group">
										<label for="titreLiv">Titre du livre : </label> <input
											type="text" class="form-control" name="titreLiv" value="${e.exemplaire.livre.titre}">
									</div>
									<div class="d-flex">
										<div class="form-group">
											<label for="nomAdh">Nom adhérent : </label> <input
												type="text" class="form-control" name="nomAdh">
										</div>

										<div class="form-group">
											<label for="idAdh">Numéro adhérent : </label> <input
												type="number" class="form-control" name="idAdh" value="${e.adherent.id_adh}">
										</div>
									</div>
									<div class="d-flex">
										<div class="form-group">
											<label for="dateEmp">Date emprunt : </label> <input
												type="date" class="form-control" name="dateEmp" vlaue="${e.dateEmprunt}">
										</div>
										<div class="form-group">
											<label for="dateRetour">Date retour : </label> <input
												type="date" class="form-control" name="dateRetour" value="">
										</div>
									</div>
									<div class="form-group">
										<label for="etat">Etat livre : </label> <select
											class="form-control" name="etat">
											<option value="neuf">Neuf</option>
											<option value="bon">Bont</option>
											<option value="use">Usé</option>
											<option value="mauvais">Mauvais</option>
										</select>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Close</button>
										<button type="button" class="btn btn-primary">Save
											changes</button>
									</div>
								</form>

							</div>

						</div>
					</div>
				</div>
			</c:forEach>
		</tbody>
	</table>

</fieldset>


<%@ include file="fragments/footer.html"%>