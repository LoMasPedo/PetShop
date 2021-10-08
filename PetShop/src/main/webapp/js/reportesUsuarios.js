
$(document).ready(function(){
	
	function listarUsuario(){
		
	$.ajax({
	type:"post",
	url:"ReportesUsuarios",
	dataType:"json",
	data:{opcion:"Usuarios"},
		success:function(result){
		console.log(result);
		var tabla=document.querySelector("#tabla")
		tabla.innerHTML=''
		tabla.innerHTML+=`<tr>
		<th class='th1'>Cedula</th>
		<th class='th1'>Nombre</th>
		<th class='th1'>Correo Electronico</th>
		<th class='th1'>Usuario</th>
		<th class='th1'>Password</th>
		</tr>`
		for(let user of result){
		tabla.innerHTML+=`<tr>
		<td class='td1'>${user.cedula_usuario}</td>
		<td class='td1'>${user.nombre_usuario}</td>
		<td class='td1'>${user.email_usuario}</td>
		<td class='td1'>${user.usuario}</td>
		<td class='td1'>${user.password}</td>
		</tr>`
		}
		}
		});	
	}
listarUsuario();
/*
$('.listaUsuarios').on('click',function(){
	listarUsuario()
});
*/
})