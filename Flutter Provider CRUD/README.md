📘 Práctica Guiada: Listas Dinámicas y CRUD Local con Provider en Flutter

📌 Descripción del proyecto
Este proyecto es una aplicación Flutter que permite agregar, editar y eliminar usuarios utilizando el patrón MVVM y el manejo de estado con Provider. Toda la información se administra localmente en memoria, reforzando conceptos esenciales como formularios, listas dinámicas y arquitectura limpia.

🎯 Objetivo general
Desarrollar una aplicación Flutter que implemente un CRUD dinámico usando Provider, aplicando MVVM para separar la lógica de negocio de la interfaz.


🎯 Objetivos específicos
- Aplicar el patrón MVVM para organizar el proyecto.
- Utilizar Provider para el manejo eficiente del estado.
- Implementar elementos interactivos como RadioButtons y Switch.
- Comprender las listas dinámicas con ListView.builder.
- Manejar formularios con validación usando TextFormField.

⚙️ Funcionalidades Implementadas
👥 Gestión de Usuarios
✅ Agregar nuevos usuarios con formulario validado
✅ Editar usuarios existentes con datos pre-cargados
✅ Eliminar usuarios con confirmación
✅ Visualización en lista con tarjetas informativas

📝 Campos del Usuario
Nombre (requerido, validación de no vacío)
Edad (requerido, numérico, validación > 0)
Correo electrónico (requerido, validación de formato)
Género (selección entre Masculino/Femenino)
Estado (activo/inactivo con Switch)

🔍 Filtros y Búsquedas
Filtro de usuarios activos - Switch en AppBar
Contador dinámico - Muestra cantidad de usuarios visibles
Indicador visual - Usuarios inactivos se muestran en gris
Actualización en tiempo real - Los cambios se reflejan inmediatamente

🚀 Cómo Ejecutar el Proyecto
Prerrequisitos
- Flutter SDK 3.0+
- Android Studio o VS Code
- Dispositivo físico o emulador

Pasos para ejecutar:
1. Clonar o descargar el proyecto
2. Abrir el terminal en la carpeta del proyecto
3. Instalar dependencias:
flutter pub get

4. Ejecutar la aplicación:
flutter run
