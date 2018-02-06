<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<a href="#">Employés</a>
<a href="#">Bulletin</a>
<html>
<div class= container>
<div class=row>
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">Date/heure de creation</th>
      <th scope="col">Matricule</th>
      <th scope="col">Grade</th>

    </tr>
 <c:forEach items="${remEmploye}" var="name">
					
						<tr>
						<td>${formater.formaterDateTime(name.date)}</td>
						<td><c:out value="${name.matricule}" /></td>
						<td><c:out value="${name.grade.code}" /></td>
						</tr>
						
				</c:forEach>
			</tr>
			
</table>



</div>


</div>






</html>