
package JHONNY.JHONNY;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "games")
public class Games implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idgames;
    
    
    private String name;
    private String brand;
    private Integer year;
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("categoria")
    private Categoria categoria;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "games")
    @JsonIgnoreProperties({"games","client"})
    private List<Mensaje> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "games")
    @JsonIgnoreProperties({"games","messages"})
    public List<Reservacion> reservations;

    public Integer getIdgames() {
        return idgames;
    }

    public void setIdgames(Integer idgames) {
        this.idgames = idgames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Mensaje> getMessages() {
        return messages;
    }

    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    public List<Reservacion> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservacion> reservations) {
        this.reservations = reservations;
    }

   
  

  
    
    
    
}
