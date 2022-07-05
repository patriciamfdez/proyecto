TAREAS en el HTML
 - Cambiar los href a tipo: "@{'/bookssolds/'
 - Crear directorios: Logado y No_Logado ????
 - Duplicar cada página en versiones LOG y NO_LOG
 - Cambiar login a ventana emergente?

SEPARAMOS LAS NOTIFICACIONES?
Un iconito como en rover


Crear páginas:
   - editar perfil 
   - notificaciones
     - lista
     - crear/editar
   - mis reservas/guarderías (lista reservas, botón ver reserva?, botón eliminar reserva)
     - pantalla detalles reserva
   - mis mascotas
   - editar mascotas
   - mis paseadores 
     - detalles paseadores
   - métodos de pago
     - eliminar
     - añadir/editar
   - factura

EJECUTAR: 
mvn spring-boot:run


IMPORTACION DE ESTILOS
<html lang="en" xmlns="https://www.thymeleaf.org" xmlns:th="http://www.w3.org/1999/xhtml">
<!--xmlns="https://www.thymeleaf.org"-->
<head>
	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">

	<title>DogGo - Inicio</title>

	<link th:href="@{/images/gt_favicon.png}" rel="shortcut icon" /> <!--Icono T, al lado de DogGo - Inicio-->
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet" media="screen" />
	<link th:href="@{/css/bootstrap.min.css}" rel="stylesheet" />
	<link th:href="@{/css/font-awesome.min.css}" rel="stylesheet" />


	<!-- Custom styles for our template -->
	<link th:href="@{/css/bootstrap-theme.css}" rel="stylesheet" media="screen"/>
	<link th:href="@{/css/main.css}" rel="stylesheet" />


	<!--Este bloque es para adaptarlo a internet explorer-->
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script th:src="@{/js/html5shiv.js}"></script>
	<script th:src="@{/js/respond.min.js}"></script>

	<![endif]-->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
		  integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
    