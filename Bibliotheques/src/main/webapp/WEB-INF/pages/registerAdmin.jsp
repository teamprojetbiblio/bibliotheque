<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        	 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous" >

</head>
<body>

<h1 align="center">Formulaire d'enregistrement</h1>
<br/>

<form method="post" action="submitRegisterAdmin">

<div class="form-group">
	<label for="nom">Nom : </label> 
	<input type="text" class="form-control" name="nom" value="${admLog.nom}">
	</div>
	
	<div class="form-group">
	<label for="prenom">Prenom : </label> 
	<input type="text" class="form-control" name="prenom" value="${admLog.prenom}">
	</div>

	<div class="form-group">
	<label for="email">Email : </label> 
	<input type="text" class="form-control" name="email" value="${admLog.email}">
	</div>

<div class="form-group">
<label for="mdp">Mot de passe : </label> 
<input type="text" class="form-control" name="mdp" value="${admLog.mdp}">
</div>

<button type="submit" class="btn btn-primary" value="Se connecter">Se connecter</button>

</form>

</body>
</html>