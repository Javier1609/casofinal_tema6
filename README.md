link del repositorio de github
https://github.com/Javier1609/casofinal_tema6.git


Explicaciondel csao final 
El proyecto en el que estás trabajando es una aplicación de interfaz gráfica de usuario (GUI) en Java que permite a los usuarios gestionar una lista de pares de números. Aquí está un desglose paso a paso de lo que has hecho en el proyecto:

1. Creaste una clase `Modelado_multidimensional` que representa un par de números. Esta clase tiene dos campos privados para almacenar los números, métodos getter y setter para acceder y modificar estos números, y un método `toString` para representar el par de números como una cadena.

2. Creaste una clase `DataList` que gestiona una lista de objetos `Modelado_multidimensional`. Esta clase tiene un campo privado que es una lista de objetos `Modelado_multidimensional`, un método para agregar un par a la lista, un método para obtener un par de la lista por su índice, un método para eliminar un par de la lista por su índice, y un método `toString` para representar toda la lista de pares como una cadena.

3. Creaste una clase `Interfaz_de_usuario` que es una GUI para interactuar con la lista de pares. Esta clase tiene varios campos privados para almacenar la lista de pares, una lista visual de pares, y campos de texto para la entrada del usuario. También tiene varios botones que permiten al usuario agregar un par a la lista, modificar un par seleccionado en la lista, eliminar un par seleccionado de la lista, y filtrar la lista de pares.

4. En la clase `Interfaz_de_usuario`, también creaste varios oyentes de acción para los botones que realizan las acciones correspondientes cuando se hace clic en los botones.

5. Finalmente, en la clase `Main`, creaste un método `main` que inicia la GUI en el hilo de despacho de eventos de Swing.

En resumen, has creado una aplicación GUI en Java que permite a los usuarios gestionar una lista de pares de números. Los usuarios pueden agregar pares a la lista, modificar pares existentes en la lista, eliminar pares de la lista, y filtrar la lista de pares.
