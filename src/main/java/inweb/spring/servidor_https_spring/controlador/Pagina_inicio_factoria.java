package inweb.spring.servidor_https_spring.controlador;

import innui.modelos.configuraciones.ResourceBundles;
import innui.modelos.errores.oks;
import innui.modelos.internacionalizacion.tr;
import java.util.ResourceBundle;
import org.springframework.ui.Model;

/**
 *
 * @author emilio
 */
public class Pagina_inicio_factoria {
    public static String k_in_ruta = "in/inweb/spring/servidor_https_spring/controlador/in";
    public static String k_servidor_activo_html = "servidor_https_spring/index.html";   
    public static String k_titulo_tex = "titulo_tex";
    public static String k_mensaje_tex = "mensaje_tex";
    public static String k_ok_tex = "ok_tex";
    public static Pagina_inicio_factoria pagina_inicio = new Pagina_inicio_factoria();

    public Pagina_inicio_factoria() {
        
    }
    public static Pagina_inicio_factoria getPagina_inicio() {
        return pagina_inicio;
    }

    public static void setPagina_inicio(Pagina_inicio_factoria pagina_inicio) {
        Pagina_inicio_factoria.pagina_inicio = pagina_inicio;
    }
        
    public String presentar_inicio(Model model, oks ok, Object... extra_array) throws Exception {
        ResourceBundle in;
        try {
            in = ResourceBundles.getBundle(k_in_ruta);
            String texto = tr.in(in, "Servidor Web Spring: ¡Hola Mundo! ");
            model.addAttribute(k_titulo_tex, texto);
            model.addAttribute(k_mensaje_tex, tr.in(in, "nota_importante"));
        } catch (Exception e) {
            in = ResourceBundles.getBundle(k_in_ruta);
            ok.setTxt(tr.in(in, "Excepción inesperada "), e);
            model.addAttribute(k_ok_tex, ok.getTxt());
        }
        return k_servidor_activo_html;
    }    
    
}
