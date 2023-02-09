/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoLeandro.demo.Controlador;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author leand
 */
@Controller
public class ErroresControlador implements ErrorController{
    
    
    @RequestMapping("/error")
    public ModelAndView errores(HttpServletResponse response){
        ModelAndView mav = new ModelAndView("error");
        String mensaje = "";
        int codigo = response.getStatus();
        
        switch (codigo) {
            case 403:
                mensaje = "No tienen permisos suficientes para acceder al recurso solicitado";
                break;
            case 404:
                mensaje = "El recurso solicitado no fue encontrado";
                break;
            case 500:
                mensaje = "Error interno en el servidor";
                break;
            default:
                mensaje = "Error inesperado";
        }
        
        mav.addObject("codigo",codigo);
        mav.addObject("mensaje", mensaje);
        
        return mav;
    }
}
