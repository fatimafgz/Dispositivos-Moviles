# CicloDeVidaApp 📱

Aplicación Android desarrollada en Kotlin que demuestra el ciclo de vida de una Activity y el uso de `onSaveInstanceState` para preservar el estado.

## 🎯 Funcionalidades

- ✅ Contador incremental con botón  
- ✅ Preservación de estado al rotar pantalla  
- ✅ Logs en Logcat de todos los métodos del ciclo de vida  
- ✅ Toast messages para cada evento del ciclo de vida  

## 🔄 Ciclo de Vida Implementado

- `onCreate()` - Inicialización de la Activity  
- `onStart()` - Activity visible pero no en foreground  
- `onResume()` - Activity interactiva  
- `onPause()` - Activity parcialmente visible  
- `onStop()` - Activity no visible  
- `onDestroy()` - Destrucción de la Activity  
- `onRestart()` - Reinicio después de onStop  
- `onSaveInstanceState()` - Guardar estado antes de destrucción  
- `onRestoreInstanceState()` - Recuperar estado después de recreación

## 📁 Estructura del Proyecto
DispositivosMoviles/
└── ActividadEnClase/
└── CicloDeVidaApp/
├── app/
│ ├── src/main/java/com/example/ciclodevidaapp/
│ │ └── MainActivity.kt
│ ├── src/main/res/layout/
│ │ └── activity_main.xml
│ └── AndroidManifest.xml
├── build.gradle.kts
└── settings.gradle.kts

## 🚀 Cómo Ejecutar

1. Clona el repositorio  
2. Abre el proyecto en Android Studio  
3. Sync project with Gradle files  
4. Ejecuta en emulador o dispositivo físico  

## 📊 Logs de Depuración

Filtrar en Logcat con: `tag:CICLO`

```log
onCreate llamado
onStart llamado  
onResume llamado
onSaveInstanceState llamado - Contador guardado: X
onRestoreInstanceState llamado - Contador recuperado: X

