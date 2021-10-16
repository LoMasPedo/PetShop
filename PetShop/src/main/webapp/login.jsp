<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login PetShop</title>
			<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
			<script type="text/javascript" src="js/modulos.js"></script>
		<link rel="stylesheet" href="css/Prueba.css">
	</head>
	
	<body>
		<img id = "logo" src="img/logo.png" width="800px" />
		<form class="box" action="Login" method = "post" onsubmit="return validacion()">
            <input type="text" name="user" placeholder="Ingrese Su Usuario" />
            <input type="password" name="pass" placeholder="Ingrese Su Clave"/>
            <input type="submit" name="enviar" value="Aceptar" />
            <input type="submit" name="cancelar" value="Cancelar" />
        </form>
	</body>
</html> 