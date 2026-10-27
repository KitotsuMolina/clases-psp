# Hoja de ejercicios 1 — Servicios y Procesos

Los 12 ejercicios son independientes, sin frameworks ni dependencias externas.
Necesitas Windows y un JDK (Java 8 o superior) para compilarlos y ejecutar las
aplicaciones de Windows.

Desde esta carpeta, compila y ejecuta el ejercicio que quieras:

```bat
javac -encoding UTF-8 Ejercicio01.java
java Ejercicio01
```

También puedes compilarlos todos con `javac -encoding UTF-8 Ejercicio*.java`.

Para el ejercicio 3, crea un fichero de texto y pasa su ruta:

```bat
java Ejercicio03 "C:\Mis documentos\notas.txt"
```

Si omites la ruta, intentará abrir `ejemplo.txt` en el directorio actual. Si el
fichero no existe, Bloc de notas puede preguntar si quieres crearlo.

En el ejercicio 4 debes pasar tanto el comando como el fichero:

```bat
java Ejercicio04 notepad.exe "C:\Mis documentos\notas.txt"
```

Las comillas permiten pasar rutas con espacios como un único argumento.

## Qué observar

1. El comando se configura en el constructor de `ProcessBuilder`.
2. El comando se configura usando `command()`.
3. El fichero se pasa como argumento separado del ejecutable.
4. El comando y el fichero se reciben mediante `String[] args`.
5. El padre genera diez números entre 0 y 9 sin esperar al hijo. Ambos procesos
   pueden ejecutarse concurrentemente; no hay garantía sobre su orden exacto.
6. `waitFor()` bloquea al padre: los números se generan cuando termina el hijo.
7. Si el lanzamiento falla, se captura `IOException`. Si se inicia, el padre
   espera e imprime el código de terminación. Un código distinto de cero suele
   indicar un error, según las convenciones del programa ejecutado.
8. `exitValue()` lanza `IllegalThreadStateException` si el proceso sigue vivo:
   todavía no tiene un código de terminación. El ejemplo captura la excepción y
   espera con `waitFor()`. Si el hijo ya había terminado, no se lanza la excepción.
9. Si cierras la calculadora antes de los diez segundos y su proceso termina,
   `exitValue()` devuelve el código de salida, normalmente cero. `sleep()` solo
   retrasa al padre: si el hijo sigue vivo, se captura la excepción.
10. `destroy()` solicita terminar el proceso. Consultar inmediatamente
    `exitValue()` podría lanzar `IllegalThreadStateException` porque la
    terminación puede ser asíncrona. La solución espera con `waitFor()` antes de
    consultar el valor. El código concreto depende del sistema y del proceso;
    no se presupone un número fijo.
11. El padre espera 300 milisegundos y solicita destruir el hijo. Después confirma
    su terminación mediante `waitFor()`.
12. Se solicita destruir el hijo y se esperan diez segundos antes de consultar
    su código. Se captura la excepción por si aún no hubiera terminado.

## Particularidades de Windows actuales

En algunas versiones modernas de Windows, `calc.exe` o `notepad.exe` pueden
delegar la ventana en otro proceso. Java controla el proceso que ha creado:
su terminación puede no coincidir con el cierre de la ventana. Esto afecta a
`waitFor()`, `exitValue()` y `destroy()`, y puede explicar que el padre continúe
con la ventana aún abierta. Los ejemplos mantienen los ejecutables pedidos
por el enunciado.

## Validación

Los doce archivos se han compilado con OpenJDK 21 en Linux. La apertura y el
cierre de Bloc de notas y Calculadora requieren comprobación en Windows.
