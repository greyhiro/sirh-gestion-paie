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
	<div class=row>

		<div class="col=12 col-lg-12">

			<h1>Bulletin de Salaire</h1>

			<div class="col-12 col-lg-12 float-right ">

				<p class=" float-right">Periode</p>

			</div>

			<div class="col-12 float-right">
				<p class="float-right">du ..... au ......</p>

			</div>


			<div class="col-12 col-lg-12 float-right ">

				<strong class=" float-left">Entreprise</strong>

			</div>

			<div class="col-12 float-right">
				<p class="float-left">DEV ENTREPRISE</p>

			</div>

			<div class="col-12 float-right">
				<p class="float-left">SIRET:</p>

			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">

<div class="col-12">


<h3>Salaire</h3>



</div>
			<table class="table table-dark">
				<tr>
					<td>Rubrique</td>
					<td>Base</td>
					<td>TauxSalarial</td>
					<td>Montant Salarial</td>
					<td>Taux patronal</td>
					<td>Cotisation patronal</td>
				</tr>
			</table>

<div class="col-12">


<h3>Cotisation</h3>



</div>
			<table class="table table-dark">
				<tr>
					<td>Cotisation</td>
					<td>Base</td>
					<td>TauxSalarial</td>
					<td>Montant Salarial</td>
					<td>Taux patronal</td>
					<td>Cotisation patronal</td>
				</tr>
			</table>



<div class="col-12">


<h3>Net Imposable</h3>



</div>
			<table class="table table-dark">
				<tr>
					<td>Rubrique</td>
					<td>Base</td>
					<td>TauxSalarial</td>
					<td>Montant Salarial</td>
					<td>Taux patronal</td>
					<td>Cotisation patronal</td>
				</tr>
			</table>




		</div>


	</div>

</div>

</html>