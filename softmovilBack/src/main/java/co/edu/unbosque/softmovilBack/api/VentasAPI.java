package co.edu.unbosque.softmovilBack.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.softmovilBack.dao.VentasDAO;
import co.edu.unbosque.softmovilBack.model.Ventas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("ventas")

public class VentasAPI {
	
	@Autowired
	private VentasDAO ventasDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Ventas ventas){
		ventasDAO.save(ventas);
		
	}
	
	@GetMapping("/listar")
	public List<Ventas> listar(){
		return ventasDAO.findAll();
	}

}
