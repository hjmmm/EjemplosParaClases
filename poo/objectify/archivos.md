# Archivos

## Entrada

### Usuarios

Los usuarios se ingresan en un archivo de texto con los siguientes campos en una linea por cada usuario separados por punto y coma.

Tipo de usuario (valores posibles: PAGO, NORMAL)
Nombre
Fecha de vencimiento suscripcion (formato: yyyy-mm-dd)

Todos los campos son obligatorios a pesar de que la fecha de vencimiento es ignorada para los usuarios normales. 
Todos los campos pueden tener una cantidad libre de espacios en blanco antes o despues de la información pertinente que son ignorados por el sistema en el momento de la carga.
Todas las lineas que comienzan por # son ignoradas al igual que cualquier linea vacia o que contenga solo espacios o tabuladores.

#### Ejemplo

```
# Este es un comentario


PAGO; Juan Pepinito; 2017-01-10 
NORMAL; Maurice Moss; 2010-01-01
PAGO; Matilde Mendez; 2018-10-10

``` 

### Artistas, albumes y canciones

El formato para cargar los artistas es tambien un archivo de texto en formato JSON con la siguiente estructura:

```
{
	"artistas": [
		{  
			"nombre" : "Pink Floyd", 
			"descripcion" : "Pink Floyd es una banda de rock británica, considerada un icono cultural del siglo xx y una de las bandas más influyentes en la historia de la música, que obtuvo gran popularidad gracias a su música psicodélica que evolucionó hacia el rock progresivo con el paso del tiempo.",
			"generos" : [ "ROCK" ],
			"albumes" : [
			 	{ 
			 		"titulo" : "Dark side of the moon",
			 		"caratula" : "https://upload.wikimedia.org/wikipedia/en/3/3b/Dark_Side_of_the_Moon.png",
			 		"exclusivo" : true,
			 		"canciones" : [
			 			{ "nombre" : "Speak to me", "duracion" : 67, "rutaArchivo" : "1.mp3" },
			 			{ "nombre" : "Breathe", "duracion" : 169, "rutaArchivo" : "2.mp3" },
			 			{ "nombre" : "On the run", "duracion" : , "rutaArchivo" : "3.mp3" }
			 		]
			 	},
			 	{ 
			 		"titulo" : "Animals",
			 		"caratula" : "https://upload.wikimedia.org/wikipedia/en/7/74/Pink_Floyd-Animals-Frontal.jpg",
			 		"exclusivo" : false,
			 		"canciones" : [
			 			{ "nombre" : "Pigs on the wing 1", "duracion" : 85, "rutaArchivo" : "1.mp3" },
			 			{ "nombre" : "Dogs", "duracion" : 1023, "rutaArchivo" : "2.mp3" },
			 			{ "nombre" : "Pigs (Three diferent ones)", "duracion" : 685, "rutaArchivo" : "3.mp3" },
			 			{ "nombre" : "Sheep", "duracion" : 625, "rutaArchivo" : "4.mp3" },
			 			{ "nombre" : "Pigs on the wing 2", "duracion" : 83, "rutaArchivo" : "5.mp3" }
			 		]
			 	}
			 	
			]
		}
	]
}
```

La duración de las canciones estan dadas en segundos.

#### Ayuda para generar lista de canciones

##### OC Remix

OC Remix (https://ocremix.org/) es una pagina donde diferentes compositores publican trabajos basados en musica de videojuegos. Todas las canciones estan disponibles de manera gratuita. A continuación un trozo de código javascript que ayuda a generar listas de canciones dada una tabla en OC Remix:


```
// Antes de usar seleccione un table body con las canciones en la variable $p. Funciona en paginas como https://ocremix.org/album/46/final-fantasy-vi-balance-and-ruin
var canciones = [];

for(var tr of $p.children) {
  var duracion = tr.children[1].innerHTML.split(":",2);
  canciones.push({
    nombre: tr.children[0].innerHTML,
    duracion: duracion[0]*60 + duracion[1]*1,
    rutaArchivo: ""
  });
}

console.log(escape(JSON.stringify(canciones)));

```

Las URLs de los archivos se pueden poner manualmente o usar un trozo de codigo que tome el arreglo generado en el anterior y los busque. Se necesita un trozo de codigo diferente para cada album, a continuación ejemplos para algunos:

```
// Antes de usar seleccione un UL con la lista de canciones en la pagina http://ff6.ocremix.org/ 
// Use el resultado de listar las canciones como parametro para unescape en la siguiente linea
var canciones = JSON.parse(unescape(""));

var i = 0;
for (var entrada of $p.children) {
  canciones[i].rutaArchivo = entrada.lastElementChild.href;
  i++;
  if (i >= canciones.length) { break; }
}
console.log(JSON.stringify(canciones));

```

```
// Este codigo funciona para el disco 1 en http://plumber.ocremix.org/
// Use el resultado de listar las canciones como parametro para unescape en la siguiente linea
var canciones = JSON.parse(unescape(""));
$("div#disc1 ul.dropdown-menu>li:nth-child(1)>a").each(
  function(indice, fuente) {
    canciones[indice].rutaArchivo = fuente.href;
  }
)
console.log(JSON.stringify(canciones));

````