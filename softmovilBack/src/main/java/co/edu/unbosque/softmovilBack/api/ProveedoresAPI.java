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

import java.util.List;
import co.edu.unbosque.softmovilBack.dao.ProveedoresDAO;
import co.edu.unbosque.softmovilBack.model.Proveedores;

@RestController
@RequestMapping("proveedores")
public class ProveedoresAPI {
	
	@Autowired
	private ProveedoresDAO proveedoresDAO;

	@PostMapping("/guardar")
	public void guardar(@RequestBody Proveedores proveedores) {
		proveedoresDAO.save(proveedores);
	}

	@GetMapping("/listar")
	public List<Proveedores> listar() {
		return proveedoresDAO.findAll();
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		proveedoresDAO.deleteById(id);
	}

	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Proveedores proveedores) {
		proveedoresDAO.save(proveedores);
	}



}
