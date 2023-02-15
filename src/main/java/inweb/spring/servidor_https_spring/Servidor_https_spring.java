package inweb.spring.servidor_https_spring;

import innui.modelos.comunicaciones.sockets.Utilidades_sockets;
import innui.modelos.configuraciones.ResourceBundles;
import innui.modelos.configuraciones.Resources;
import innui.modelos.configuraciones.iniciales;
import innui.modelos.errores.oks;
import innui.modelos.internacionalizacion.tr;
import innui.modelos.modelos;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.System.exit;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Servidor_https_spring extends iniciales {
    public static String k_in_ruta = "in/inweb/spring/servidor_https_spring/in";
    public static String k_server_connection_timeout = "server.connection-timeout";
    public static String k_server_ssl_enabled = "server.ssl.enabled";
    public static String k_server_ssl_protocol = "server.ssl.protocol";
    public static String k_server_ssl_key_store_password = "server.ssl.key-store-password";
    public static String k_server_ssl_key_store_type = "server.ssl.key-store-type";
    public static String k_server_ssl_key_store = "server.ssl.key-store";
    public static String k_server_port = "server.port";
    public static String k_spring_thymeleaf_prefix = "spring.thymeleaf.prefix";
    public static String k_spring_web_resources_static_locations = "spring.web.resources.static-locations";
    public static String k_jar_ruta = "jar_ruta:";
    public static String k_servidor_jar_ruta = "servidor_jar_ruta:";
    public static String k_comando_navegador = "servidor_https_spring.comando_para_ejecutar_navegador";
    public static String k_comando_url = "servidor_https_spring.comando_url_que_ejecutar_navegador";
    public static String k_puerto_num = "puerto_num:";
    
    public SpringApplication springApplication;
    
    public static void main(String[] args) {
        oks ok = new oks();
        try {
            Servidor_https_spring servidor_https_spring 
                    = new Servidor_https_spring();
            // Object [] extra_array = { args };
            servidor_https_spring.run(ok, Servidor_https_spring.class, args);
        } catch (Exception e) {
            ok.setTxt(e);
        }
        if (ok.es == false) {
            System.err.println(ok.txt);
            exit(1);
        }
//	SpringApplication.run(Servidor_https_spring.class, args);
    }

    @Override
    public boolean run(oks ok, Object... extra_array) throws Exception {
        try {
            if (ok.es == false) { return ok.es; }
            ResourceBundle in;
            iniciar(ok);
            if (ok.es) {
                in = ResourceBundles.getBundle(k_in_ruta);
                while (true) {
                    URL url = null;
                    File file;
                    String reemplazo_texto = "";
                    boolean es_hacer_reemplazo = false;
                    int puerto_libre = Utilidades_sockets.encontrar_puerto_libre(443, ok);
                    springApplication = new SpringApplication((Class) extra_array[0]);
                    // System.getProperties().put( "server.port", puerto_libre );
                    Map<String, Object> mapa = new HashMap();
                    String texto;
                    texto = this.properties.getProperty(k_server_connection_timeout);
                    ok.no_nul(texto, tr.in(in, "Propiedad no encontrada ") + k_server_connection_timeout);
                    if (ok.es == false) { break; }
                    mapa.put(k_server_connection_timeout, texto);
                    texto = this.properties.getProperty(k_server_ssl_enabled);
                    ok.no_nul(texto, tr.in(in, "Propiedad no encontrada ") + k_server_ssl_enabled);
                    if (ok.es == false) { break; }
                    mapa.put(k_server_ssl_enabled, texto);
                    texto = this.properties.getProperty(k_server_ssl_protocol);
                    ok.no_nul(texto, tr.in(in, "Propiedad no encontrada ") + k_server_ssl_protocol);
                    if (ok.es == false) { break; }
                    mapa.put(k_server_ssl_protocol, texto);
                    texto = this.properties.getProperty(k_server_ssl_key_store_password);
                    ok.no_nul(texto, tr.in(in, "Propiedad no encontrada ") + k_server_ssl_key_store_password);
                    if (ok.es == false) { break; }
                    mapa.put(k_server_ssl_key_store_password, texto);
                    texto = this.properties.getProperty(k_server_ssl_key_store_type);
                    ok.no_nul(texto, tr.in(in, "Propiedad no encontrada ") + k_server_ssl_key_store_type);
                    if (ok.es == false) { break; }
                    mapa.put(k_server_ssl_key_store_type, texto);
                    texto = this.properties.getProperty(k_server_ssl_key_store);
                    ok.no_nul(texto, tr.in(in, "Propiedad no encontrada ") + k_server_ssl_key_store);
                    if (ok.es == false) { break; }
                    es_hacer_reemplazo = false;
                    if (texto.startsWith(k_servidor_jar_ruta)) {
                        url = Resources.getResource(Servidor_https_spring.class, "");
                        reemplazo_texto = k_servidor_jar_ruta;
                        es_hacer_reemplazo = true;
                    } else if (texto.startsWith(k_jar_ruta)) {
                        url = Resources.getResource(this.getClass(), "");
                        reemplazo_texto = k_jar_ruta;
                        es_hacer_reemplazo = true;
                    }
                    if (es_hacer_reemplazo) {
                        file = new File(url.toURI());
                        file = new File(file.getCanonicalFile(), texto.replace(reemplazo_texto, ""));
                        texto = "file:" + file.getCanonicalPath();
                    }
                    mapa.put(k_server_ssl_key_store, texto);
                    texto = this.properties.getProperty(k_spring_thymeleaf_prefix);
                    ok.no_nul(texto, tr.in(in, "Propiedad no encontrada ") + k_spring_thymeleaf_prefix);
                    if (ok.es == false) { break; }
                    es_hacer_reemplazo = false;
                    if (texto.startsWith(k_servidor_jar_ruta)) {
                        url = Resources.getResource(Servidor_https_spring.class, "");
                        reemplazo_texto = k_servidor_jar_ruta;
                        es_hacer_reemplazo = true;
                    } else if (texto.startsWith(k_jar_ruta)) {
                        url = Resources.getResource(this.getClass(), "");
                        reemplazo_texto = k_jar_ruta;
                        es_hacer_reemplazo = true;
                    }
                    if (es_hacer_reemplazo) {
                        url = Resources.getResource(this.getClass(), "");
                        file = new File(url.toURI());
                        file = new File(file.getCanonicalFile(), texto.replace(reemplazo_texto, ""));
                        texto = "file:" + file.getCanonicalPath();
                        if (texto.endsWith(File.separator) == false) {
                            texto = texto + File.separator;                        
                        }
                    }
                    mapa.put(k_spring_thymeleaf_prefix, texto);
                    texto = this.properties.getProperty(k_spring_web_resources_static_locations);
                    ok.no_nul(texto, tr.in(in, "Propiedad no encontrada ") + k_spring_web_resources_static_locations);
                    if (ok.es == false) { break; }
                    es_hacer_reemplazo = false;
                    if (texto.contains(k_servidor_jar_ruta)) {
                        url = Resources.getResource(Servidor_https_spring.class, "");
                        reemplazo_texto = k_servidor_jar_ruta;
                        es_hacer_reemplazo = true;
                    } else if (texto.contains(k_jar_ruta)) {
                        url = Resources.getResource(this.getClass(), "");
                        reemplazo_texto = k_jar_ruta;
                        es_hacer_reemplazo = true;
                    }
                    if (es_hacer_reemplazo) {
                        url = Resources.getResource(this.getClass(), "");
                        file = new File(url.toURI());
                        String cambio = "file:" + file.getCanonicalPath();
                        int pos = texto.indexOf(reemplazo_texto);
                        pos = pos + reemplazo_texto.length();
                        if (pos < texto.length()) {
                            if (texto.charAt(pos) != '/') {
                                if (cambio.endsWith("/") == false) {
                                    cambio = cambio + "/";
                                }
                            }
                        }
                        texto = texto.replace(reemplazo_texto, cambio);
                    }
                    mapa.put(k_spring_web_resources_static_locations, texto);
                    texto = String.valueOf(puerto_libre);
                    mapa.put(k_server_port, texto);
                    this.properties.setProperty(k_server_port, texto);
                    springApplication.setDefaultProperties(mapa);
                    springApplication.run((String []) extra_array[1]);
                    mapa = new HashMap();
                    texto = this.properties.getProperty(k_comando_navegador);
                    ok.no_nul(texto, tr.in(in, "Propiedad no encontrada ") + k_comando_navegador);
                    if (ok.es == false) { break; }
                    mapa.put(k_comando_navegador, texto);
                    texto = this.properties.getProperty(k_comando_url);
                    ok.no_nul(texto, tr.in(in, "Propiedad no encontrada ") + k_comando_url);
                    if (ok.es == false) { break; }
                    if (texto.contains(k_puerto_num)) {
                        texto = texto.replace(k_puerto_num, String.valueOf(puerto_libre));
                    }
                    mapa.put(k_comando_url, texto);
                    lanzar_aplicacion_javafx_configurada(mapa, ok);
                    break;
                }
                oks ok_fin = new oks();
                terminar(ok_fin);
                ok.setTxt(ok.getTxt(), ok_fin.getTxt());
            }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return ok.es;
    }

    @Override
    public boolean iniciar(oks ok, Object... extra_array) throws Exception {
        if (ok.es == false) { return ok.es; }
        _iniciar_desde_clase(modelos.class, ok);
        if (ok.es == false) { return ok.es; }
        _iniciar_desde_clase(Servidor_https_spring.class, ok);
        return ok.es;
    }

    @Override
    public boolean terminar(oks ok, Object... extra_array) throws Exception {
        if (ok.es == false) { return ok.es; }
        _terminar_desde_clase(modelos.class, ok);
        if (ok.es == false) { return ok.es; }
        _terminar_desde_clase(Servidor_https_spring.class, ok);
        return ok.es;
    }

    public boolean lanzar_aplicacion_javafx_configurada(Map<String, Object> mapa
            , oks ok, Object... extra_array) throws Exception {
        String comando = (String) mapa.get(k_comando_navegador);
        String url = (String) mapa.get(k_comando_url);
        comando = comando + " " + url;
        String [] comando_array = comando.split("\\s");
        File carpeta_de_trabajo = new File (".");
        carpeta_de_trabajo = carpeta_de_trabajo.getCanonicalFile();
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(comando_array, null, carpeta_de_trabajo);
        InputStream inputStream = process.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String linea;
        while (true) {
            linea = bufferedReader.readLine();
            if (linea == null) {
                break;
            }
            this.escribir_linea(linea, ok);
            if (ok.es == false) {
                break;
            }
        }
        return ok.es;
    }    
}
