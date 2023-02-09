package ProyectoLeandro.demo.Entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@Getter 
@Setter
public class Pedido {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name= "uuid", strategy = "uuid2")
    private String id;   
    
    @Column(name = "nombre_Pedido",  nullable = false)
    private String nombrePedido;
    @Column(name = "panes_Queso", nullable = false)
    private Integer panesQueso;
    @Column(name = "panes_SinQueso")
    private Integer panesSinQueso;
    @Column(name = "pizza", nullable = false)
    private Integer Pizza;
    @Column(name = "numero", nullable = false)
    private String numero;
    @Column(name = "mail", nullable = false)
    private String mail;
    @Column(name = "retiro_local",nullable = false)
    private String retiroLocal;
    @Column(name = "envio_domicilio",nullable = false)
    private String envioDomicilio;

    public Pedido() {
    }
    
    public Pedido(String id, String nombrePedido, int panesQueso, int panesSinqueso, int Pizza, String numero, String mail, String retiroLocal, String envioDomicilio) {
        this.id = id;
        this.nombrePedido = nombrePedido;
        this.panesQueso = panesQueso;
        this.panesSinQueso = panesSinqueso;
        this.Pizza = Pizza;
        this.numero = numero;
        this.mail = mail;
        this.retiroLocal = retiroLocal;
        this.envioDomicilio = envioDomicilio;
    }
    
    
    
}
