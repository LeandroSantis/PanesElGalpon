package ProyectoLeandro.demo.Servicio;

import ProyectoLeandro.demo.Entidad.Pedido;
import ProyectoLeandro.demo.Repositorio.PedidoRepositorio;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PedidoServicio {
    
    @Autowired
    private PedidoRepositorio pedidoRepositorio;
    
    @Transactional
    public void crearPedido(String nombrePedido, Integer panesQueso, Integer panesSinQueso, Integer Pizza, String numero, String mail, String retiroLocal, String envioDomicilio){
    
        
        Pedido pedido = new Pedido();
        pedido.setNombrePedido(nombrePedido);
        pedido.setPanesQueso(panesQueso);
        pedido.setPanesSinQueso(panesSinQueso);
        pedido.setPizza(Pizza);
        pedido.setNumero(numero);
        pedido.setMail(mail);
        pedido.setRetiroLocal(retiroLocal);
        pedido.setEnvioDomicilio(envioDomicilio);
        
        pedidoRepositorio.save(pedido);
    }
    
    @Transactional
    public List<Pedido> buscarPedidos(){
        return pedidoRepositorio.findAll();
    }
    
    @Transactional
    public void eliminarPedido(String id) {
        
        pedidoRepositorio.deleteById(id);
    }
//    @Transactional
//    public Pedido buscarPedido(String id){
//        Optional<Pedido> pedidoOptional = pedidoRepositorio.findById(id);
//        return pedidoOptional.orElse(null);
//        
//    }
    
//    @Transactional
//    public void modificarPedido(String id, String nombrePedido, int panesQueso, int panesSinQueso, int Pizza, String numero, String mail, String retiroLocal, String envioDomicilio){
//    
//        
//        Pedido pedido = pedidoRepositorio.findById(id).orElse(null);
//        
//        if(pedido == null){
//            
//        }
//            
//        
//        Pedido pedido = new Pedido();
//        pedido.setNombrePedido(nombrePedido);
//        pedido.setPanesQueso(panesQueso);
//        pedido.setPanesSinQueso(panesSinQueso);
//        pedido.setPizza(Pizza);
//        pedido.setNumero(numero);
//        pedido.setMail(mail);
//        pedido.setRetiroLocal(retiroLocal);
//        pedido.setEnvioDomicilio(envioDomicilio);
//        
//        pedidoRepositorio.save(pedido);
//    }
    
    
    
}
