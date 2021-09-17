<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>D Pet Shop</title>
</head>
<body>
<%!String mensaje="";
email_usuario="",nombre_usuario="",password="",usuario="",   estado="";
long cedula=0;
%>
<h1>Modulo Usuarios</h1>
<hr>
<%
if(request.getParameter("cedula")!=null){
cedula=Integer.parseInt(request.getParameter("cedula"));
email_usuario= request.getParameter("email_usuario");
nombre_usuario=request.getParameter("nombre_usuario");
password=request.getParameter("password");
usuario=request.getParameter("usuario");
estado="disabled";
}
%>
<%
if(request.getParameter("men")!=null){
cedula=0;
email_usuario="";
nombre_usuario="";
password="";
usuario="";
mensaje=request.getParameter("men");
}
%>
<form action="Libro" method="post">
<fieldset>
<legend>Datos del Usuario:</legend>
<div><label>cedula: </label><input type="number" name="cedula_usuario" value="<%=cedula%>" required <%=estado%>></div>
<input type="hidden" name="cod" value="<%=cedula%>">
<div><label>email_usuario: </label><input type="text" name="email_usuario" value="<%=email_usuario%>" required></div>
<div><label>nombre_usuario: </label><input type="text" name="nombre_usuario" value="<%=nombre_usuario%>" required></div>
<div><label>password: </label><input type="text" name="password" value="<%=password%>" required></div>
<div><label>usuario: </label><input type="text" name="usuario" value="<%=usuario%>" required></div>

<div><input type="submit" name="registrar" value="Registrar">
<input type="submit" name="actualizar" value="Actualizar">
<input type="submit" name="eliminar" value="Eliminar"></div>
</fieldset>
</form>
<form action="Libro" method="post">
<fieldset>
<legend>Consultar</legend>
<div><label>cedula: </label><input type="text" name="codigo" required></div>
<div><input type="submit" name="consultar" value="Consultar"></div>
</fieldset>
</form>

<h2><%=mensaje %></h2>
</body>
</html>