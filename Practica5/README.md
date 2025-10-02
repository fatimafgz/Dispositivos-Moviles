#  Configurador de Pedidos de Comida

##  Descripción
Aplicación Android desarrollada en Kotlin que permite a los usuarios armar un pedido de comida paso a paso, seleccionando el tipo de comida principal y extras, con la posibilidad de editar el pedido antes de confirmarlo.

##  Fragments

### 1. InicioFragment
- Pantalla inicial con botón "Nuevo Pedido"
- Navegación a SeleccionComidaFragment

### 2. SeleccionComidaFragment
- Selección del tipo de comida principal (Pizza, Hamburguesa, Ensalada)
- Uso de RadioGroup para selección única
- Paso de datos mediante Bundle

### 3. SeleccionExtrasFragment
- Selección múltiple de extras (Bebida, Papas Fritas, Postre)
- Uso de CheckBox para selección múltiple
- Agregado de información al Bundle existente

### 4. ResumenPedidoFragment
- Visualización del resumen del pedido
- Confirmación o edición del pedido
- Comunicación hacia atrás con `setFragmentResult()`

##  Autor
- Fatima Florez Gonzalez
