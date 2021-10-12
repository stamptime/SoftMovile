package co.edu.unbosque.softmovilBack.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.softmovilBack.dao.ProductosDAO;
import co.edu.unbosque.softmovilBack.model.Productos;

import java.util.List;

@RestController
@RequestMapping("productos")
public class ProductosAPI {
	
	@Autowired
	private ProductosDAO productoDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Productos producto) {
		productoDAO.save(producto);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Productos producto) {
		productoDAO.save(producto);
	}
	
	@GetMapping("/listar")
	public List<Productos> listar(){
		return productoDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		productoDAO.deleteById(id);
	}
}
