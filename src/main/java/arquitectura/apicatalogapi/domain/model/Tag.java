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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "TAG")
public class Tag implements Serializable {

    private static final long serialVersionUID = 1L;

    public Tag(Integer id) {
        this.id = id;
    }

    @Column(name = "ID", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinTable(name = "TAG_ENDPOINT", joinColumns = @JoinColumn(name = "TAG_ID"), inverseJoinColumns = @JoinColumn(name = "ENDPOINT_ID"))
    private List<Endpoint> endpoints;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "IDAPLICACION", nullable = false)
    private Aplicacion aplicacion;
}
