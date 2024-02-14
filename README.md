# Api de restaurantes
## Recursos usados:
El recurso usado para esta API es que se ha creado una base de datos de restaurantes. Los atributos que tiene la tabla de restaurantes son:

- id
- nombre
- puntuacion
- ubicacion
- tipocomida
- menu
- menuinfantil
- precio

Cabe mencionar, que la tabla está llena de datos ficticios, y cada uno tiene su respectivo endpoint.

## Endpoints
Teniendo en cuenta que parten de la raíz @RequestMapping("/api/restaurante"), el controlador del recurso Evento tiene los siguientes endpoints:

- @GetMappping("/") -> Obtiene todos los datos que hay
- @GetMappping("/id/{id}") -> Obtiene todos los datos del restaurante con el id indicado
- @GetMappping("/nombre/{nombre}") -> Obtiene todos los datos del restaurante con el nombre indicado
- @GetMappping("/puntuacion/{puntuacion}") -> Obtiene todos los datos de los restaurantes con la puntuación indicada
- @GetMappping("/ubicacion/{ubicacion}") -> Obtiene todos los datos del restaurante con la ubicación indicada
- @GetMappping("/tipocomida/{tipocomida}") -> Obtiene todos los datos de los restaurantes con el tipo de comida indicado
- @GetMappping("/menuDia/{menuDelDia}") -> Obtiene todos los datos de los restaurantes que se le indique si quiere que tenga menu del dia o no
- @GetMappping("/menuInfantil/{menuInfantil}") -> Obtiene todos los datos de los restaurantes que se le indique si quiere que tenga menu infantil o no
- @GetMappping("/precioMedio/{precioMedio}") -> Obtiene una lista con todos los datos de los restaurantes que tengan el precio medio indicado
- @GetMappping("/listaNombres") -> Devuelve una lista con todos los nombres de los restaurantes
- @GetMappping("/cantidad") -> Devuelve la cantidad de restaurantes que hay en la base de datos
- @GetMappping("/puntuacionMinima/{puntuacionMinima}") -> Devuelve la lista de restaurantes que tengan como mínimo la puntuación indicada
- @GetMappping("/precioMaximo/{precioMax}") -> Devuelve la lista de restaurantes que tengan como máximo el precio indicado
- @GetMappping("/precioMinimo/{precioMin}") -> Devuelve la lista de restaurantes que tengan como mínimo el precio indicado
- @PostMapping("/post") -> Método para añadir un restaurante a la lista
- @PutMapping("/{id}") -> Método para modificar los datos de un restaurante, en caso de que se ponga un id que no esté en la base de datos, se creará un nuevo restaurante
- @DeleteMapping("/{id}") -> Método para borrar un restaurante de la lista indicando un id

Cabe mencionar también, que para los métodos post, put y delete se ha creado un token de seguridad definido en la clase SecurityService
