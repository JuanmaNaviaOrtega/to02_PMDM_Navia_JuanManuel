#Primera Aplicacion.
Esta aplicación convierte entre euros y dólares, cuando se pasa un valor como parametro elegiremos a traves de dos radio boton si queremos convertir de euros a dólares o de dólares a euros y automaticamnente nos da el resultado.
La mejora que he hecho en esta aplicación es poner un unico editText editable que valga para euros y dólares y cuando se pulse cualquier radioboton haga el cambio de moneda automaticamente en un editText no editable llamado resultado, gracias a esto he podido quitar el botón convertir y tener una aplicacion mejor optimiziada

#Segunda Aplicacion.
Esta aplicación tiene una array que contiene la información de los sitios webs sobre herramientas de inteligencia artificial para programadores, cada sitio web contiene un nombre,link,descripción,email del administrador y una imagen.
Tambien contiene una pantalla principal que usa un RecyclerView con cardView que muestra el nombre del sitio su link y una imagen.
Incluye un Toast que mostrará la descripción y el email de la tarjeta del sitio web que hemos pulsado.
Como mejoras he añadido varios elementos:
un buscador para filtrar los sitiosWeb por su nombre, de esta manera se podrá localizar un sitioWeb mas facilmente solo buscandolo por su nombre en el filtro
un boton x arriba a la derecha del cardView para poder eliminar un sitioWeb del Recyclerview
un Swipe up

#Tercera Aplicacion
Esta aplicacion consta de una Pantalla inicial que carga una lista de sitioesWebs sobre herramientas de inteligencia artificial desde un array o una fuente de datos, tambien tiene un RecyclerView que muestra la lista en tarjetas (cardView).
Tiene un evento al pulsar el sitio web que queremos seleccionar,  este será comunicado a la actividad principal para abrir el fragmento de detalle con los datos del sitio web.
La pantalla detalle como ya he dicho muestra toda la información sobre el sitioWeb seleccionado, esto incluye su nombre, link, descripcion, email, imagen.
