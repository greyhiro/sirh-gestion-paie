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
<a href="#">Employés</a>
<a href="#">Bulletin</a>

<div class=container>
	<div class=row>
		<table class="table table-dark">

			<tr>
				<td>Dates et heures de Création</td>
				<td>Periodes</td>
				<td>Matricule</td>
				<td>Salaire Brut</td>
				<td>Net imposable</td>
				<td>Net à payer</td>
				<td>Action</td>


			</tr>



			<c:forEach items="${bulletinResultat}" var="bulletinRes">
			</tr>
			<td>${bulletinRes.key.remunerationEmploye.date}</td>
			<td>${bulletinRes.key.periode.dateDebut}</td>
			<td>${bulletinRes.key.remunerationEmploye.matricule}</td>
			<td>${bulletinRes.value.salaireBrut}</td>
			<td>${bulletinRes.value.netImposable}</td>
			<td>${bulletinRes.value.netAPayer}</td>
			<td><a href=./BulletinDeSalaire?matricule=${bulletinRes.key.remunerationEmploye.matricule}>Visualiser</a></td>
			
			</tr>
			
			
			</c:forEach>


		</table>
	</div>
</div>

</html>