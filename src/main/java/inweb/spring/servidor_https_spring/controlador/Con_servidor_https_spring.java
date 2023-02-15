package inweb.spring.servidor_https_spring.controlador;

import innui.modelos.errores.oks;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author emilio
 */
@Controller
public class Con_servidor_https_spring {
    public static String k_in_ruta = "in/inweb/spring/servidor_https_spring/controlador/in";        
    
    @GetMapping("/")
    public String inicio_raiz(Model model) throws Exception {
        oks ok = new oks();
        return Pagina_inicio_factoria.getPagina_inicio().presentar_inicio(model, ok);
    }
    
}
