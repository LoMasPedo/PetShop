<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tienda D.Pet Shop</title>
<style>
.saludo{

text-align: center;
font-size:25px;
color: #8b61c3; 
}

</style>
</head>
<body>
<%
String mensaje="";
if(request.getParameter("nom")!=null){
mensaje=request.getParameter("nom");
}
%>

<jsp:include page="Header.jsp" />

 <% if (mensaje != null && mensaje != "") { %>
		<div class="saludo">Hola <%= mensaje %>, Por Favor Seleccione una opcion del menu</div>
 <% } else { %>
        <div class="saludo">Por Favor Seleccione una opcion del menu</div>
      <% } %>

</body>
</html>