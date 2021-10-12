package co.edu.unbosque.softmovilBack.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.softmovilBack.model.Clientes;

public interface ClientesDAO extends JpaRepository<Clientes, Long> {

}
