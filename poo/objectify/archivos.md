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

