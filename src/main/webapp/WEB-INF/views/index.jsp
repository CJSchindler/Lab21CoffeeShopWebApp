<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GC Coffee</title>
</head>
<link rel="stylesheet" href="/style.css"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<body>
<main class="container">
<div class="jumbotron">
  <h1 class="display-4">Welcome to GC Coffee</h1>
  <p class="lead">All the caffeine you need to fuel your brain through Bootcamp.</p>
  <hr class="my-4">
</div>

  <p class="lead">
    <a class="btn btn-primary btn-md" href="/register" role="button">Register here</a>
  </p>

<div class="container">
		<h1>Menu</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Item</th><th>Description</th><th>Quantity</th><th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${items}">
				<tr>
					<td><a href="/items/">${item.name}</a></td>
					<td>${item.description}</td>
					<td>${item.quantity}</td>
					<td>${item.price }</td>
					<td>
						<a href="/items/${ item.id }/edit-item/{id}" class="btn btn-light btn-sm">Edit</a>
						<a href="/items/${ item.id }/delete" class="btn btn-light btn-sm" onclick="return confirm('Are you sure?')">Delete</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/add-item" class="btn btn-medium btn-sm">Add</a>
	</div>
	<br><br>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</main>
</body>
</html>