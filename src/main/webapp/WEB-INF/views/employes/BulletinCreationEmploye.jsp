<%@page import="dev.paie.repository.EntrepriseRepository"%>
<%@page import="java.awt.List"%>
<%@page import="dev.paie.entite.Entreprise"%>
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


<a href="#">Employés</a>
<a href="#">Bulletin</a>

<div class="container">
	<div class="row"></div>
	<div class="col" align="center">
		<h1>Ajouter Employés</h1>
	</div>

	<form method="post">
		<div class="form-group">
			<label for="Matricule">Matricule:</label> <input type="text"
				class="form-control" id="Matricule" name="Matricule"
				placeholder="Enter Matricule">
		</div>
		<div class="form-group">
			<label for="Entreprise">Entreprise</label> <select id="Entreprise"
				class="form-control" name="Entreprise">


				<c:forEach items="${entreprise}" var="name">
					<option value="${name.id}">
						<c:out value="${name.denomination}" /></option>
				</c:forEach>
			</select>
		</div>

		<div class="form-group">
			<label for="Profil">Profil</label> <select id="Profil"
				class="form-control" name="Profil">
				<c:forEach items="${profil}" var="name">
					<option value="${name.id}">
						<c:out value="${name.code}" /></option>
				</c:forEach>
			</select>
		</div>

		<div class="form-group">
			<label for="Profil">Grade</label> <select id="Grade"
				class="form-control" name="Grade">
				<c:forEach  items="${grade}" var="name">
					<option  value="${name.id}">
					
						<c:out value="${name.code}  ${name.nbHeuresBase*name.tauxBase} euros/ans" /></option>
				</c:forEach>
			</select>
		</div>



		<button type="submit" class="btn btn-primary">Submit</button>
	</form>



</div>