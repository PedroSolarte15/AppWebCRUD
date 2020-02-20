package proyecto.view.servicio;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import proyecto.view.modelo.Pelicula;

@Stateless
public class ServicioPelicula {
	
	private List<Pelicula> peliculas = new ArrayList<Pelicula>();
	
	public void create(Pelicula pelicula) {
		pelicula.setId(peliculas.size() + 1);
		peliculas.add(pelicula);
	}
	
	public void update(Pelicula pelicula) {
		pelicula.setNombre(pelicula.getNombre());
		pelicula.setGenero(pelicula.getGenero());
		pelicula.setDuracion(pelicula.getDuracion());
		pelicula.setPais(pelicula.getPais());
		pelicula.setAño(pelicula.getAño());
	}
	
	public List<Pelicula> list() {
		return peliculas;
		
	}
	
	public List<String> countries() {
		List<String> countries = new ArrayList<String>();
		countries.add("Argentina");
		countries.add("Bolivia");
		countries.add("Brasil");
		countries.add("Chile");
		countries.add("Colombia");
		countries.add("Ecuador");
		countries.add("Paraguay");
		countries.add("Perú");
		countries.add("Uruguay");
		countries.add("Venezuela");
		countries.add("España");
		countries.add("Francia");
		countries.add("Alemania");
		countries.add("Italia");
		countries.add("Estados Unidos");
		return countries;
	}
	
	public void delete(Pelicula pelicula) {
		peliculas.remove(pelicula);
	}

	public Pelicula obtenerObjetoPorId(String userId) {
		return peliculas.get(Integer.parseInt(userId) - 1);
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	
}
