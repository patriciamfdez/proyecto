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


añadido del NO LOGADO
<i class="fa fa-user-circle-o" aria-hidden="true"></i>
<li class="dropdown">
<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user fa-fw"></i> Mi perfil <b class="caret"></b></a>
<ul class="dropdown-menu">
<li><a href="miperfil.hmtl">Ver perfil</a></li>
<li><a href="#">Mis mascotas</a></li>
<li><a href="#">Mis reservas</a></li>
<li><a href="#">Mis paseadores</a></li>
<li><a href="#">Notificaciones</a></li>
<li><a href="#">Métodos de pago</a></li>
</ul>
</li>
<li><a class="btn" href="#">Cerrar sesión</a></li> <!-- TODO Cambiar link a página inicio de LogIn -->
    