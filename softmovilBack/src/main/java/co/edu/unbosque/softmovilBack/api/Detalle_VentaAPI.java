package co.edu.unbosque.softmovilBack.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.softmovilBack.dao.Detalle_VentaDAO;
import co.edu.unbosque.softmovilBack.model.Detalle_Venta;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("detalle_venta")
public class Detalle_VentaAPI {
	
	@Autowired
	private Detalle_VentaDAO detalle_ventaDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Detalle_Venta detalle_venta) {
		detalle_ventaDAO.save(detalle_venta);
	}

}
