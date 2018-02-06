<%@page import="dev.paie.repository.EntrepriseRepository"%>
<%@page import="java.awt.List"%>
<%@page import="dev.paie.entite.Entreprise"%>
<%@page import="dev.paie.web.controller.FormaterDate"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<div class="container">
	<div class="row">

		
			<div class="col-12"->

				<a href="#">Employés</a>


			</div>
			<div class="col-12"-></div>
			<a href="#">Bulletins</a>
	</div>
</div>



<div class="container">
	<div class="row">
		<div class="col-12">
		
			<br>
			<h1>Créer un bulletin de salaire</h1>

		</div>

<form method="POST" class="col-12">
		<div class="form-group col-lg-12">
			<label for="Periodes">Periodes</label> <select id="Periodes"
				class="form-control" name="Periodes">

				<c:forEach items="${periodes}" var="name">
					<option value="${name.id}">dates du
						${formater.formaterDate(name.dateDebut)} au
						${formater.formaterDate(name.dateFin)}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group col-lg-12">
			<label for="Matricule">Matricule</label> <select id="Matricule"
				class="form-control" name="Matricule">

				<c:forEach items="${employe}" var="name">
					<option value="${name.id}">${name.matricule}</option>
				</c:forEach>
			</select>
		</div>

		<div class="form-group col-lg-12">
			<label for="Prime">Prime Exeptionnelle:</label> <input type="text"
				class="form-control" id="Prime" name="Prime"
				placeholder="Enter Prime">
		</div>
		
		<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</div>

</div>






</html>