<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="css/Prueba.css">
	</head>
	
	<body>
		<img id = "logo" src="img/logo.jpg" width="800px" />
		<form class="box" action="Login" method = "post">
            <input type="text" name="user" placeholder="Ingrese Su Usuario" />
            <input type="password" name="pass" placeholder="Ingrese Su Clave"/>
            <input type="submit" name="enviar" value="Aceptar" />
            <input type="submit" name="cancelar" value="Cancelar" />
        </form>
	</body>
</html>