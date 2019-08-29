<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" --%>
<%--     pageEncoding="ISO-8859-1"%> --%>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="ISO-8859-1"> -->
<!-- <title>Insert title here</title> -->
<!-- </head> -->
<!-- <body> -->

<!-- </body> -->
<!-- </html> -->

<%@ include file="fragments/header.html"%>
 


<br/>
<br/>

<div class="card mb-3">
          <div class="card-header">
            Table d'adherents</div>
          <div class="card-body">
            <div class="table-responsive">
		<table id="dataTable" class="table table-bordered" cellspacing="0" width="100%" border="1">
		<thead class="thead-light">
			<tr>
			    <th>num_emprunt</th>			
				<th>num_adherent</th>
				<th>Nom</th>
				<th>Prenom</th>				
				<th>num_exemplaire</th>
				<th>num_livre</th>
			    <th>titre</th>
			</tr>
</thead>
<tbody id="myTable">
			<c:forEach var="e" items="${listeRetardataire}">
				<tr class="table-active">
					<td>${e.id_emp}</td>
					<td>${e.adherent.id_adh }</td>
					<td>${e.adherent.nom }</td>
					<td>${e.adherent.prenom }</td>
					<td>${e.exemplaire.id_exe}</td>
					<td>${e.exemplaire.livre.id_liv}</td>
					<td>${e.exemplaire.livre.titre}</td>
				</tr>
			</c:forEach>			
			</tbody>
		</table>
	</div>
	</div>
</div>
</div>
