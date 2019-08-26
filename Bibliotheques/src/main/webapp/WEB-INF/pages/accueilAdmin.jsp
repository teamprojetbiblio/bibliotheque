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




<h1 style="color: blue; text-align: center">Liste des administrateurs</h1>

 <div class="container">


  <br>

<form action="afficherAddAdmin" method="get">
<button type="submit" class="btn btn-secondary">Aller au formulaire d'ajout</button>
</form>
<br/>
<br/>
        <div class="card mb-3">
          <div class="card-header">
            Table d'administrateur</div>
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
				<th>Supprimer</th>
				<th>Editer</th>
			</tr>
</thead>
<tbody id="myTable">
			<c:forEach var="e" items="${listeAdmin}">
				<tr class="table-active">
					<td>${e.id_adm}</td>
					<td>${e.nom}</td>
					<td>${e.prenom }</td>
					<td>${e.email}</td>
					<td>${e.mdp}</td>
					<td><a href="${pageContext.request.contextPath}/admController/deleteLinkAdm/${e.id_adm}">Supprimer</a></td>
					<td><a href="${pageContext.request.contextPath}/admController/updateLinkAdmin?pId=${e.id_adm}">Editer</a></td>					
				</tr>
			</c:forEach>			
			</tbody>
		</table>
	</div>
	</div>
</div>
</div>


<%@ include file="fragments/footer.html"%>