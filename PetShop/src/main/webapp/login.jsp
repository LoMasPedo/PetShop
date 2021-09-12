<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tienda D.Pet Shop</title>
<style>
.divInicial {
	 border: 5px solid white; 
  border-radius: 5px; 
  margin: auto; 
  text-align: center;
}

.tablalogin {
  margin: auto;
}
.botoneslogin
{
	margin-top:20px;
}
</style>
</head>
<body>
	<div class="divInicial">
		<br /> <br />
		<img src="img/logo.jpg" width="450px" />
		<h2>Bienvenidos a la tienda D.Pet Shop</h2>
		<br />
		<br />
		<h5>Ingresa tu usuario y contraseña para continuar</h5>
		<div>
			<form action="Login" method="post">
				<table class="tablalogin">
					<tr>
						<td><label for="user" class="labeluser">Usuario: </label></td>
						<td><input type="text" name="user" /></td>
					</tr>
					<tr>
						<td><label for="pass">Contraseña: </label></td>
						<td><input type="password" name="pass" /></td>
					</tr>
					
				</table>
				<table  class="tablalogin botoneslogin">
				<tr>
						<td><input type="submit" name="enviar" value="Aceptar" /></td>
						<td/>
						<td><input type="submit" name="cancelar" value="Cancelar" /></td>
					</tr>
				</table>
			</form>
		</div>

		<!-- 
	<div>
				<label for="user" class="labeluser">Usuario: </label>
				<input type="text" name="user" />
			</div>
			<br/>
			<div>
				<label for="pass">Contraseña: </label>
				<input type="password" name="pass" />
			</div>
			<br/>
			<div>
				<input type="submit" name="enviar" value="Aceptar"/>  
				<input type="submit" name="cancelar" value="Cancelar"/> 
			</div>
			 -->

	</div>
</body>
</html>