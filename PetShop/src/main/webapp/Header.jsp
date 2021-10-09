<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="img/fonts.css">
<style>
* {
	text-decoration: none;
	list-style: none;
	margin: 0px;
	padding: 0px;
	outline: none;
}



body {
	background-image: url("css/Fondo.jpg");
	margin:0px;
	padding: 0px;
	font-family: 'Open Sans', sans-serif;
}


section {
	width: auto;
	max-width: 1200px;
	margin: 0px auto;
	display: table;
	position: relative;
}

header {
	width: 100%;
	display: table;
	background-color: #2ba3ac;
	margin-bottom: 40px;
	
	
}

#logomenu {
	display: block;
	margin-left: auto;
 	margin-right: auto;
 	border-radius: 210px;
	 
}

nav {
width: auto;
height: 60px;
	text-align: center;
	padding:1px;
}

nav ul {
	display: table;
	list-style: none;
        display: inline-block;
}

nav ul li {
	  display: inline-block;
    float:left; 
}

nav ul li:last-child {
	padding-right: 0px;
}

nav ul li a {
	color: #ecf0f1;
	font-size: 20px;
	padding: 20px 20px; /*sele ajusto el tamaño a la barra rosada del menu*/
	border-radius: 100px;
	display: inline-block;
	transition: all 0.5s ease 0s;
}

nav ul li a:hover {
border-radius: 100px;
	background-color: #eb737b;
	color: #ecf0f1;
	font-weight: bolder;
	transition: all 0.5s ease 0s;
}

nav ul li a:hover i {
	color: #2ba3ac;
	transition: all 0.5s ease 0s;
}

nav ul li a i {
	padding-right: 10px;
	color: #eb737b;
	transition: all 0.5s ease 0s;
}

.toggle-menu ul {
	display: table;
	width: 25px;
}

.toggle-menu ul li {
	width: 100%;
	height: 3px;
	background-color: #eb737b;
	margin-bottom: 4px;
}

.toggle-menu ul li:last-child {
	margin-bottom: 0px;
}
/*
input[type=checkbox],
label {
	display: none;
}
*/

.content {
	display: table;
	margin-bottom: 60px;
	width: 900px;
}

footer {
	display: table;
	padding-bottom: 30px;
	width: 100%;
}
.social {
	position: fixed; /* Hacemos que la posición en pantalla sea fija para que siempre se muestre en pantalla*/
	left: 0; /* Establecemos la barra en la izquierda */
	top: 200px; /* Bajamos la barra 200px de arriba a abajo */
	z-index: 2000; /* Utilizamos la propiedad z-index para que no se superponga algún otro elemento como sliders, galerías, etc */
}

	.social ul {
		list-style: none;
	}

	.social ul li a {
		display: inline-block;
		color:#fff;
		background: #000;
		padding: 10px 15px;
		text-decoration: none;
		-webkit-transition:all 500ms ease;
		-o-transition:all 500ms ease;
		transition:all 500ms ease; /* Establecemos una transición a todas las propiedades */
	}

	.social ul li .icon-facebook2 {background:#3b5998;} /* Establecemos los colores de cada red social, aprovechando su class */
	.social ul li .icon-twitter {background: #00abf0;}
	.social ul li .icon-google-plus {background: #d95232;}
	.social ul li .icon-instagram {background: #ae181f;}
	.social ul li .icon-android {background: #666666;}

	.social ul li a:hover {
		background: #000; /* Cambiamos el fondo cuando el usuario pase el mouse */
		padding: 10px 30px; /* Hacemos mas grande el espacio cuando el usuario pase el mouse */
	}

@media only screen and (max-width: 1440px) {
	section {
		max-width: 95%;
	}
}

@media only screen and (max-width: 980px) {
	header {
		padding: 20px 0px;
	}
	#logo {
		padding: 0px;
	}
	input[type=checkbox] {
		position: absolute;
		top: -9999px;
		left: -9999px;
		background: none;
	}
	input[type=checkbox]:fous {
		background: none;
	}
	label {
		float: right;
		padding: 8px 0px;
		display: inline-block;
		cursor: pointer;
	}
	input[type=checkbox]:checked~nav {
		display: block;
	}
	nav {
		display: none;
		position: absolute;
		right: 0px;
		top: 53px;
		background-color: #002e5b;
		padding: 0px;
		z-index: 99;
	}
	nav ul {
		width: auto;
	}
	nav ul li {
		float: none;
		padding: 0px;
		width: 100%;
		display: table;
	}
	nav ul li a {
		color: #FFF;
		font-size: 15px;
		padding: 10px 20px;
		display: block;
		border-bottom: 1px solid rgba(225, 225, 225, 0.1);
	}
	nav ul li a i {
		color: #fde428;
		padding-right: 13px;
	}
}
</style>	
<img id="logomenu" src="img/logo.png" width="300px" />
<header>
	<section>
	<!--  -->
		<label for="toggle-1" class="toggle-menu" style="display:none;">
			<ul>
				<li></li>
				<li></li>
				<li></li>
			</ul>
		</label>
		<input type="checkbox" id="toggle-1"  style="display:none;" />
			<nav>
				<ul>
					<li>
						<a href="Usuarios.jsp">
							<i class="icon-home"></i>Usuarios
						</a>
					</li>
					<li>
						<a href="Clientes.jsp">
							<i class="icon-user"></i>Clientes
						</a>
					</li>
					<li>
						<a href="Proveedores.jsp">
							<i class="icon-thumbs-up-alt"></i>Proveedores
						</a>
					</li>
					<li>
						<a href="Productos.jsp">
							<i class="icon-gear"></i>Productos
						</a>
					</li>
					<li>
						<a href="Ventas.jsp">
							<i class="icon-picture"></i>Ventas
						</a>
					</li>
					<li>
						<a href="Reportes.jsp">
							<i class="icon-phone"></i>Reportes
						</a>
					</li>
				</ul>
				<ul>
				<li>
						<a href="login.jsp">
							<i class="icon-phone"></i>LogOut
						</a>
					</li>
				</ul>
			</nav>
			
			<div class="social">
		<ul>
			<li><a href="http://www.facebook.com" target="_blank" class="icon-facebook2"></a></li>
			<li><a href="http://www.twitter.com" target="_blank" class="icon-twitter"></a></li>
			<li><a href="http://www.googleplus.com" target="_blank" class="icon-google-plus"></a></li>
			<li><a href="http://www.instagram.com" target="_blank" class="icon-instagram"></a></li>
			<li><a href="mailto:contacto@Dpetshop.com" class="icon-android"></a></li>
		</ul>
	</div>
		</section>
	</header>