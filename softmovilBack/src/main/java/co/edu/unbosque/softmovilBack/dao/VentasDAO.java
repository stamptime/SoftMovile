package co.edu.unbosque.softmovilBack.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.unbosque.softmovilBack.model.Ventas;

public interface VentasDAO extends JpaRepository<Ventas, Long> {

}
