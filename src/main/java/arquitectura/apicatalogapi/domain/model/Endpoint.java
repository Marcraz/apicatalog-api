package arquitectura.apicatalogapi.domain.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Endpoint")
@EqualsAndHashCode(callSuper = false)
public class Endpoint implements Serializable {

	private static final long serialVersionUID = 1L;

	public Endpoint(Integer id) {
		this.id = id;
	}

	@Column(name = "NOMBRE", nullable = false)
	private String nombre;

	@Column(name = "URL", nullable = false)
	private String url;

	@Column(name = "ID", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;

	@Column(name = "TIPOOP", nullable = false)
	private String tipoOP;

	@Column(name = "NOMBREOP", nullable = false)
	private String nombreOp;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "IDAPLICACION", nullable = false)
	private Aplicacion aplicacion;

	@ManyToMany(mappedBy = "endpoints", fetch = FetchType.EAGER)
	private List<Tag> tags;

}
