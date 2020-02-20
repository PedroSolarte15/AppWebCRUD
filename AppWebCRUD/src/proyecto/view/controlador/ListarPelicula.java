package proyecto.view.controlador;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import proyecto.view.modelo.Pelicula;
import proyecto.view.servicio.ServicioPelicula;

@Named
@ViewScoped
public class ListarPelicula implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ServicioPelicula servicioPelicula;
	
	private List<Pelicula> listaPeliculas;
	
	@PostConstruct
	public void init() {
		listaPeliculas = servicioPelicula.list();
	}

	public List<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}
	public void setListaPeliculas(List<Pelicula> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}

}




