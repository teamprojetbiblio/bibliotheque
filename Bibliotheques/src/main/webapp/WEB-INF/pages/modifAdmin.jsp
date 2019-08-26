<%@ include file="fragments/header.html"%>
<br/>
<br/>

<div class="box">
<br/>
<br/>
<h1 style="text-align: center;color: blue; font-size: 34px;">Formulaire de modification</h1>
  <br/>
  <br/>
  <div align="center">


<form:form modelAttribute="admMod"   method="POST" action="submitUpdateAdm">

<br/>
<div >
<form:label path="id_adm" id="id" >Id :</form:label>
<form:input path="id_adm" />
</div>
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
<button type="submit" class="btn btn-primary" value="Ajouter">Modifier un administrateur</button>
</div>

</form:form>
<br/>
<br/>
</div>
</div>

<%@ include file="fragments/footer.html"%>