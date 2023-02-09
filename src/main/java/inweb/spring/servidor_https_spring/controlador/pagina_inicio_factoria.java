/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inweb.spring.servidor_https_spring.controlador;

import innui.modelos.configuraciones.ResourceBundles;
import innui.modelos.configuraciones.Resources;
import innui.modelos.errores.oks;
import innui.modelos.internacionalizacion.tr;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import org.springframework.ui.Model;

/**
 *
 * @author emilio
 */
public class pagina_inicio_factoria {
    public static String k_in_ruta = "in/inweb/spring/servidor_https_spring/controlador/in";
    public static String k_servidor_activo_html = "servidor_activo.html";   
    public static String k_titulo_txt = "titulo_txt";
    public static String k_ok_txt = "ok_txt";
    public static pagina_inicio_factoria pagina_inicio = new pagina_inicio_factoria();

    public pagina_inicio_factoria() {
        
    }
    public static pagina_inicio_factoria getPagina_inicio() {
        return pagina_inicio;
    }

    public static void setPagina_inicio(pagina_inicio_factoria pagina_inicio) {
        pagina_inicio_factoria.pagina_inicio = pagina_inicio;
    }
        
    public String presentar_inicio(Model model, oks ok, Object... extra_array) throws Exception {
        ResourceBundle in;
        try {
            in = ResourceBundles.getBundle(k_in_ruta);
            String texto = tr.in(in, "Servidor Web Spring: ¡Hola Mundo! ");
            model.addAttribute(k_titulo_txt, texto);
        } catch (Exception e) {
            in = ResourceBundles.getBundle(k_in_ruta);
            ok.setTxt(tr.in(in, "Excepción inesperada "), e);
            model.addAttribute(k_ok_txt, ok.getTxt());
        }
        return k_servidor_activo_html;
    }    
    
}
