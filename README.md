# servidor_https_spring
Servidor HTTPS con la Java y el marco de desarrollo Spring

Depende de:
- Modelos: https://github.com/EAG-es/modelos

El servidor HTTPS necesita que se cree un almacen de claves. Tiene uno incorporado (re/almacen_claves.p12) , que debería ser reemplazado empleando el comando:

keytool -genkeypair -alias <etiqueta identificadora> -keyalg RSA -keysize 4096 -storetype PKCS12 -keystore <nombre del archivo.p12> -validiy <días de validez> -storepass <contraseña del almacen a generar>

Los datos de configuración de TSL están en el archivo: re/inweb.spring.servidor_https_spring.properties:
- server.connection-timeout=30s               
- server.ssl.enabled=true
- server.ssl.protocol=TLS
- server.ssl.key-store-password=criptoymaspassword
- server.ssl.key-store-type=pkcs12
- server.ssl.key-store=servidor_jar_ruta:re/almacen_claves.p12

También se configuran en él los datos de las rutas de los archivos de: templates; y de archivos de recursos estáticos: static
- server.ssl.key-store=servidor_jar_ruta:re/almacen_claves.p12
- spring.thymeleaf.prefix=jar_ruta:re/templates/
- spring.web.resources.static-locations=jar_ruta:re/static/,classpath:re/static/

Donde:
- servidor_jar_ruta: Se cambia en tiempo de ejecución por la ruta donde está el jar: servidor_https_spring-x.x.jar
- jar_ruta: Se cambia en tiempo de ejecución por la ruta donde está el jar con la clase que hereda de: Servidor_https_spring.class

También están los comandos para lanzar un navegador web cuando se termina de arrancar el Servidor HTTPS:
- # Otras opciones: firefox, google-chrome, opera, brave-browse
- servidor_https_spring.comando_para_ejecutar_navegador=google-chrome
- servidor_https_spring.comando_url_que_ejecutar_navegador=https://localhost:puerto_num:/

Donde:
- puerto_num: Se cambia en tiempo de ejecución el número de puerto libre que se encontró primero para escuchar en él las peticiones HTTPS

El valor:
- server.port=0 Se actualiza con el último puerto libre que se ha asignado al servidor HTTPS

