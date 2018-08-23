<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>${ title }</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<!-- Custom CSS goes below Bootstrap CSS -->
<link rel="stylesheet" href="/style.css" />
</head>
<body>
	<main class="container">
		<h1>Add an item to the menu</h1>
		
		
		<form action="/submit-add" method="post">
			<div class="form-group">
			    <label for="name">Item Name</label>
			    <!-- pre-populate the input value from the existing food (if any) -->
			    <input class="form-control" id="name" name="name" value="${item.name}" required minlength="2">
			</div>
			<div class="form-group">
			    <label for="description">Description</label>
			    <input class="form-control" id="description" name="description" value="${item.description}" required>
			</div>
			<div class="form-group">
			    <label for="quantity">Quantity</label>
			    <input class="form-control" id="quantity" name="quantity" value="${item.quantity}" required>
			</div>
			<div class="form-group">
			    <label for="quantity">Price</label>
			    <input class="form-control" id="price" name="price" value="${item.price}" required>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
			<a href="/submit-add" class="btn btn-link">Cancel</a>
		</form>
	</main>
</body>
</html>