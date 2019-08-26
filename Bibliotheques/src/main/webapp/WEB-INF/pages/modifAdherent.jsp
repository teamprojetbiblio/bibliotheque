<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
       <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adherentCss/all.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrapFile/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrapFile/bootstrap-theme.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrapFile/bootstrap.min.css"> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adherentCss/sb-admin.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adherentCss/adherentCSS.css">

</head>
<body>


<div class="box">
<br/>
<br/>
<h1 style="text-align: center;color: blue;">Formulaire de modification</h1>
  
  <div align="center">


<form:form modelAttribute="adhModif"   method="POST" action="updateAdhSubmit">

<br/>
<div >
<form:label path="id_adh" id="id" >Id :</form:label>
<form:input path="id_adh" />
</div>
<br/>
<br/>
<div>
<form:label path="nom" id="nom">Nom :</form:label>
<form:input path="nom" required="required"/>
</div>
<div>
<form:label path="prenom" id="prenom">Prenom :</form:label>
<form:input path="prenom" required="required"/>
</div>
<br/>
<br/>
<div>
<form:label path="email" id="email">Email :</form:label>
<form:input path="email" required="required"/>
</div>
<div>
<form:label path="password" id="password">Password :</form:label>
<form:input path="password" required="required"/>
</div>
<br/>
<br/>
<div>
<form:label path="adresse" id="adresse">Adresse :</form:label>
<form:input path="adresse" required="required"/>
</div>
<div>
<form:label path="ville" id="ville">Ville :</form:label>
<form:input path="ville" required="required"/>
</div>
<br/>
<div>
<form:label path="telephone" id="telephone">Telephone :</form:label>
<form:input path="telephone" required="required"/>
</div>
<br/>
<br/>
<div>
<button type="submit" class="btn btn-primary" value="Modifier">Modifier un adhérent</button>
</div>

</form:form>
<br/>
<br/>
</div>
</div>

</body>
</html>