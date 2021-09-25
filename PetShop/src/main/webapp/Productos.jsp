<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	
<meta charset="ISO-8859-1">
<title>D Pet Shop</title>

</head>
<body>

<jsp:include page="Header.jsp" />
<h1>Modulo Productos</h1>

<form action="Productos" method="post" enctype="multipart/form-data">
	<div>
		<label>Nombre del achivo:</label><input type="text" name="nombreArch">
		<input type="file" value="Examinar" name="archivo">
	</div>
	<div>
		<input type="submit" name="cargar" value="Cargar">
	</div>
	
	
	
	
</form>

</body>
</html>