package arquitectura.apicatalogapi.domain.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="APLICACION")
public class Aplicacion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    public Aplicacion(Integer id) {
        this.id = id;
    }

    @Column(name = "VERSION", nullable = false)
    private String version;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "ID", nullable = false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "aplicacion", orphanRemoval = true)
    private List<Endpoint> endpoints;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "aplicacion", orphanRemoval = true)
    private List<Tag> tags;
}
