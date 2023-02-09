package ProyectoLeandro.demo.Controlador;

import ProyectoLeandro.demo.Entidad.Pedido;
import ProyectoLeandro.demo.Servicio.PedidoServicio;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/pedidos")
public class PedidoControlador {
    
    @Autowired
    private PedidoServicio pedidoServicio;
    
    @GetMapping("/lista")
    public ModelAndView pedidos(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("listado");
        Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
         if (flashMap != null) {
            mav.addObject("exito", flashMap.get("exito-name"));
            mav.addObject("error", flashMap.get("error-name"));
        }
        mav.addObject("pedidos", pedidoServicio.buscarPedidos());
        return mav;
    }
    
    
    @GetMapping("/CrearPedido")
    public ModelAndView crearPedido() {
        ModelAndView mav = new ModelAndView("Formulario-Pedido");
        mav.addObject("pedido", new Pedido());
        return mav;
    }
    
    @PostMapping("/guardar")
    public RedirectView guardar(@RequestParam String nombrePedido, @RequestParam int panesQueso, @RequestParam int panesSinQueso, @RequestParam int Pizza, @RequestParam String numero, @RequestParam String mail, @RequestParam String retiroLocal, @RequestParam String envioDomicilio) throws  Exception{
        
        try {
            pedidoServicio.crearPedido(nombrePedido, panesQueso, panesSinQueso, Pizza, numero, mail, retiroLocal, envioDomicilio);
            return new RedirectView("/index");
        } catch (Exception e) {
            e.printStackTrace();
            return new RedirectView("/error");
        }
        
    }
    
    @PostMapping("/eliminar/{id}")
    public RedirectView eliminar(@PathVariable String id) {
        pedidoServicio.eliminarPedido(id);
        return new RedirectView("/index");
    }
    
    
    
    
    
    
}
