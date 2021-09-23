<!--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

*{text-decoration:none; list-style:none; margin:0px; padding:0px; outline:none;}
body{margin:0px; padding:0px; font-family: 'Open Sans', sans-serif;}
section{width:100%; max-width:1200px; margin:0px auto; display:table; position:relative;}

header{width:100%; display:table; background-color: #2ba3ac; margin-bottom:50px;}
#logo{float:left; font-size:24px; text-transform:uppercase; color: #eb737b; font-weight:600; padding:20px 0px;}

nav{width:auto; float:right;}
nav ul{display:table; float:right;}
nav ul li{float:left;}
nav ul li:last-child{padding-right:0px;}
nav ul li a{color:#ecf0f1; font-size:18px; padding: 25px 20px; display:inline-block; transition: all 0.5s ease 0s;}
nav ul li a:hover{background-color:#eb737b; color:#ecf0f1; font-weight:bolder; transition: all 0.5s ease 0s;}
nav ul li a:hover i{color:#2ba3ac; transition: all 0.5s ease 0s;}
nav ul li a i{padding-right:10px; color:#eb737b; transition: all 0.5s ease 0s;}

.toggle-menu ul{display:table; width:25px;}
.toggle-menu ul li{width:100%; height:3px; background-color:#eb737b; margin-bottom:4px;}
.toggle-menu ul li:last-child{margin-bottom:0px;}

input[type=checkbox], label{display:none;}

.content{display:table; margin-bottom:60px; width:900px;}

footer{display:table; padding-bottom:30px; width:100%;}
.social{margin:0px auto; display:table; display:table;}
.social li{float:left; padding:0px 10px;}
.social li a{color:#eb737b; transition: all 0.5s ease 0s;}
.social li a:hover{color:#2ba3ac; transition: all 0.5s ease 0s;}

@media only screen and (max-width: 1440px) {
section{max-width:95%;}
}

@media only screen and (max-width: 980px) {
header{padding:20px 0px;}
#logo{padding:0px;}
input[type=checkbox] {position: absolute; top: -9999px; left: -9999px; background:none;}
input[type=checkbox]:fous{background:none;}
label {float:right; padding:8px 0px; display:inline-block; cursor:pointer; }
input[type=checkbox]:checked ~ nav {display:block;}

nav{display:none; position:absolute; right:0px; top:53px; background-color:#002e5b; padding:0px; z-index:99;}
nav ul{width:auto;}
nav ul li{float:none; padding:0px; width:100%; display:table;}
nav ul li a{color:#FFF; font-size:15px; padding:10px 20px; display:block; border-bottom: 1px solid rgba(225,225,225,0.1);}
nav ul li a i{color:#fde428; padding-right:13px;}
}

</style>
</head>
<body>

<!--  USAR EL ARCHIVO Header.jsp dentro de cada jsp para traer el menu y poder reutilizarlo
	
	<img src="img/logo.jpg" width="450px" />
		
	<header>
	<section>
	<label for="toggle-1" class="toggle-menu"><ul><li></li> <li></li> <li></li></ul></label>
	<input type="checkbox" id="toggle-1">
	
		<nav>
		<ul>
		<li><a href="Usuarios.jsp"><i class="icon-home"></i>Usuarios</a></li>
		<li><a href="Clientes.jsp"><i class="icon-user"></i>Clientes</a></li>
		<li><a href="#proveedores"><i class="icon-thumbs-up-alt"></i>Proveedores</a></li>
		<li><a href="#productos"><i class="icon-gear"></i>Productos</a></li>
		<li><a href="#ventas"><i class="icon-picture"></i>Ventas</a></li>
		<li><a href="#reportes"><i class="icon-phone"></i>Reportes</a></li>
		</ul>
		</nav>
	</section>	
	</header>
	
	 -->
</body>
</html>