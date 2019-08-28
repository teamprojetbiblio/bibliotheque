<%--  <%@ page language="java" contentType="text/html; charset=ISO-8859-1" --%>
<%--     pageEncoding="ISO-8859-1"%> --%>
    
<%--     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%--     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  --%>
    

<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="utf-8"/> -->
<!-- <title>Insert title here</title> -->


<%-- 	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adherentCss/all.min.css"> --%>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrapFile/bootstrap.css"> --%>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrapFile/bootstrap-theme.css"> --%>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrapFile/bootstrap.min.css">  --%>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adherentCss/sb-admin.css"> --%>


<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"> -->
  
<%--   <link href="${pageContext.request.contextPath}/resources/css/adherentCss/ionicons.min.css" rel="stylesheet"> --%>
  
<%--   <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/livre.css"> --%>
  

<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
<!--   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> -->

<!-- </head> -->
<!-- <body>  -->


  
  
 <%@ include file="fragments/header.html"%>
 


<br/>
<br/>




<h1 style="color: blue; text-align: center">Liste des adherents</h1>

 <div class="container">


  <br>

<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
 Ajouter un adherent
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Formulaire d'ajout d'un adherent</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      
     
<br/>
       <form:form modelAttribute="adhAjout"   method="POST" action="addAdhSubmit" class="formU">


<br/>
<div >
<form:label path="nom" class="labelU">Nom :  </form:label>
<form:input path="nom" class="inputU" required="required"/>
</div>
<br/>
<br/>
<div >
<form:label path="prenom" class="labelU" style="clear:left">Prenom : </form:label>
<form:input path="prenom" class="inputU" required="required"/>
</div>
<br/>
<div >
<form:label path="email" class="labelU">Email :  </form:label>
<form:input path="email" class="inputU" required="required"/>
</div>
<br/>
<br/>
<div>
<form:label path="password" class="labelU">Password :</form:label>
<form:input path="password" class="inputU" required="required"/>
</div>
<br/>
<div>
<form:label path="adresse" class="labelU">Adresse :</form:label>
<form:input path="adresse" class="inputU" required="required"/>
</div>
<br/>
<br/>
<div>
<form:label path="ville" style="clear:left;" class="labelU">Ville :</form:label>
<form:input path="ville" class="inputU" required="required"/>
</div>
<br/>
<div>
<form:label path="telephone" class="labelU">Telephone :</form:label>
<form:input path="telephone" class="inputU" required="required"/>
</div>
<br/>
<br/>
<br/>
<div>
<button type="submit" class="btn btn-primary" value="Ajouter">Ajouter un adhérent</button>
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
				<th>id</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Mail</th>
				<th>Password</th>
			    <th>Adresse</th>
			    <th>Ville</th>
				<th> telephone</th>
				<th>Supprimer</th>
				<th>Editer</th>
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
					<td><a href="${pageContext.request.contextPath}/adhController/deleteLinkAdh/${e.id_adh}"><i class="fas fa-archive" ></i></a></td>
					<td><a href="${pageContext.request.contextPath}/adhController/updateLinkAdh?pId=${e.id_adh}"><i class="fas fa-edit"></i></a></td>					
				</tr>
			</c:forEach>			
			</tbody>
		</table>
	</div>
	</div>
</div>
</div>









<%@ include file="fragments/footer.html"%>


<%-- <script src="${pageContext.request.contextPath}/resources/js/jQueryFile/jquery.min.js"></script> --%>
<%-- <script src="${pageContext.request.contextPath}/resources/js/bootstrapFile/bootstrap.js"></script> --%>



</body>
</html>