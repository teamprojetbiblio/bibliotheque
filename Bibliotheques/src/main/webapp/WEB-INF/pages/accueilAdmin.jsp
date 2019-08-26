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


<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal2">
 Ajouter un administrateur
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel2" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Ajouter un admin</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form:form modelAttribute="admAdd"   method="POST" action="submitAddAdmin">


<br/>

<br/>
<div >
<form:label path="nom" id="nom">Nom :  </form:label>
<form:input path="nom" required="required"/>
</div>
<div >
<form:label path="prenom" id="prenom">Prenom : </form:label>
<form:input path="prenom" required="required"/>
</div>
<br/>
<br/>

<div >
<form:label path="email" id="email">Email :  </form:label>
<form:input path="email" required="required"/>
</div>

<div>
<form:label path="mdp" id="password">Mdp :</form:label>
<form:input path="mdp" required="required"/>
</div>

<br/>
<br/>
<br/>
<div>
<button type="submit" class="btn btn-primary" value="Ajouter">Ajouter un administrateur</button>
</div>

</form:form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

  <br>

<!--  <form action="afficherAddAdmin" method="get">
<button type="submit" class="btn btn-secondary">Aller au formulaire d'ajout</button>
</form> -->
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