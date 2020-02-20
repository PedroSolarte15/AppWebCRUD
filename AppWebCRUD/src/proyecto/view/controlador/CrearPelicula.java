package proyecto.view.controlador;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import proyecto.view.modelo.Pelicula;
import proyecto.view.servicio.ServicioPelicula;

@Named
@ViewScoped

public class CrearPelicula implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ServicioPelicula servicioPelicula;
	
	private List<String> countries;
	private String pais_seleccionado;
	
	private Pelicula pelicula;
	
	@PostConstruct
	public void init() {
		countries = servicioPelicula.countries();
		pelicula = new Pelicula();

	}
	
	public void create() throws IOException {
		pelicula.setPais(pais_seleccionado);
		servicioPelicula.create(pelicula);
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect("index.xhtml");
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public List<String> getCountries() {
		return countries;
	}

	public void setCountries(List<String> countries) {
		this.countries = countries;
	}

	public String getPais_seleccionado() {
		return pais_seleccionado;
	}

	public void setPais_seleccionado(String pais_seleccionado) {
		this.pais_seleccionado = pais_seleccionado;
	}
}
