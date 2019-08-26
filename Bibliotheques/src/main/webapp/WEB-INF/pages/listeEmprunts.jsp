<%@ include file="fragments/header.html"%>

<h2 class="mt-4 mb-3">Emprunts</h2>

		<form action="index" method="GET">
			<div class="d-flex justify-content-around">
			
			<div class="form-group">
					<label>Rechercher : </label>
					<select class="form-control" name="filtre">
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
					<label>Mot clé : </label>
					<input class="form-control" type="text" name="mc" id="search"/>
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
			<c:forEach var="e" items="${listeEmprunts}" >
				<tr >
					<td>${e.id_emp}</td>
					<td>${e.adherent.id_adh}</td>
					<td>${e.adherent.nom}</td>
					<td>${e.exemplaire.livre.titre}</td>
					<td>${e.exemplaire.id_exe}</td>
					<td>${e.exemplaire.etat}</td>
					<td>${e.dateEmprunt}</td>
					<td>${e.dateRetour}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		</fieldset>
		

<%@ include file="fragments/footer.html"%>