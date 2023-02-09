package inweb.spring.servidor_https_spring;

import innui.modelos.comunicaciones.sockets.utilidades_sockets;
import innui.modelos.configuraciones.ResourceBundles;
import innui.modelos.configuraciones.iniciales;
import innui.modelos.errores.oks;
import innui.modelos.internacionalizacion.tr;
import innui.modelos.modelos;
import innui.modelos.modelos_comunicaciones.modelos_comunicaciones;
import static java.lang.System.exit;
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
            in = ResourceBundles.getBundle(k_in_ruta);
            iniciar(ok);
            if (ok.es) {
                int puerto_libre = utilidades_sockets.encontrar_puerto_libre(443, ok);
                SpringApplication springApplication = new SpringApplication((Class) extra_array[0]);
                // System.getProperties().put( "server.port", puerto_libre );
                Map<String, Object> mapa = new HashMap();
                String texto;
                texto = this.properties.getProperty(k_server_connection_timeout);
                ok.no_nul(texto, tr.in(in, "Propiedad no encontrada ") + k_server_connection_timeout);
                if (ok.es == false) { return ok.es; }
                mapa.put(k_server_connection_timeout, texto);
                texto = this.properties.getProperty(k_server_ssl_enabled);
                ok.no_nul(texto, tr.in(in, "Propiedad no encontrada ") + k_server_ssl_enabled);
                if (ok.es == false) { return ok.es; }
                mapa.put(k_server_ssl_enabled, texto);
                texto = this.properties.getProperty(k_server_ssl_protocol);
                ok.no_nul(texto, tr.in(in, "Propiedad no encontrada ") + k_server_ssl_protocol);
                if (ok.es == false) { return ok.es; }
                mapa.put(k_server_ssl_protocol, texto);
                texto = this.properties.getProperty(k_server_ssl_key_store_password);
                ok.no_nul(texto, tr.in(in, "Propiedad no encontrada ") + k_server_ssl_key_store_password);
                if (ok.es == false) { return ok.es; }
                mapa.put(k_server_ssl_key_store_password, texto);
                texto = this.properties.getProperty(k_server_ssl_key_store_type);
                ok.no_nul(texto, tr.in(in, "Propiedad no encontrada ") + k_server_ssl_key_store_type);
                if (ok.es == false) { return ok.es; }
                mapa.put(k_server_ssl_key_store_type, texto);
                texto = this.properties.getProperty(k_server_ssl_key_store);
                ok.no_nul(texto, tr.in(in, "Propiedad no encontrada ") + k_server_ssl_key_store);
                if (ok.es == false) { return ok.es; }
                mapa.put(k_server_ssl_key_store, texto);
                texto = String.valueOf(puerto_libre);
                mapa.put(k_server_port, texto);
                this.properties.setProperty(k_server_port, texto);
                springApplication.setDefaultProperties(mapa);
                springApplication.run((String []) extra_array[1]);
                terminar(ok);
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
        _iniciar_desde_clase(modelos_comunicaciones.class, ok);
        if (ok.es == false) { return ok.es; }
        _iniciar_desde_clase(Servidor_https_spring.class, ok);
        return ok.es;
    }

    @Override
    public boolean terminar(oks ok, Object... extra_array) throws Exception {
        if (ok.es == false) { return ok.es; }
        _terminar_desde_clase(modelos.class, ok);
        if (ok.es == false) { return ok.es; }
        _terminar_desde_clase(modelos_comunicaciones.class, ok);
        if (ok.es == false) { return ok.es; }
        _terminar_desde_clase(Servidor_https_spring.class, ok);
        return ok.es;
    }

}
