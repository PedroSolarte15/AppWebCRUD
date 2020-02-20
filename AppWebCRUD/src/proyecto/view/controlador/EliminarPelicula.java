package proyecto.view.controlador;

import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import proyecto.view.modelo.Pelicula;
import proyecto.view.servicio.ServicioPelicula;

@Named
@ViewScoped

public class EliminarPelicula implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ServicioPelicula servicioPelicula;	
	
	private Pelicula pelicula;
	
	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		String userId = fc.getExternalContext().getRequestParameterMap().get("userId");
		pelicula = servicioPelicula.obtenerObjetoPorId(userId);
	}
	
	public void delete() throws IOException {
		servicioPelicula.delete(pelicula);
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect("index.xhtml");
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	
	
}