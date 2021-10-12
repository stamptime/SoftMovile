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
import co.edu.unbosque.softmovilBack.dao.UsuariosDAO;
import co.edu.unbosque.softmovilBack.model.Usuarios;

@RestController
@RequestMapping("usuarios")
public class UsuariosAPI {
	@Autowired
	private UsuariosDAO usuarioDAO;

	@PostMapping("/guardar")
	public void guardar(@RequestBody Usuarios usuario) {
		usuarioDAO.save(usuario);
	}

	@GetMapping("/listar")
	public List<Usuarios> listar() {
		return usuarioDAO.findAll();
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		usuarioDAO.deleteById(id);
	}

	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Usuarios usuario) {
		usuarioDAO.save(usuario);
	}
}
