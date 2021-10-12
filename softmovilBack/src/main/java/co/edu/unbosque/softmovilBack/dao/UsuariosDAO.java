package co.edu.unbosque.softmovilBack.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.softmovilBack.model.Usuarios;

public interface UsuariosDAO extends JpaRepository<Usuarios,Long> {

}
