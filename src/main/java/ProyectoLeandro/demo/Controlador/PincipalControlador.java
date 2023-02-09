package ProyectoLeandro.demo.Controlador;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PincipalControlador {
    
    @GetMapping("/index")
    public ModelAndView inicio (HttpSession session){
        return new ModelAndView("index2");
        
    }
}
    