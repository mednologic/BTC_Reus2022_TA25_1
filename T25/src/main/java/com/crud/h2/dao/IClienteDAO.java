package com.crud.h2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.h2.dto.Cliente;

/**
 * @author Jose
 *
 */
public interface IClienteDAO extends JpaRepository<Cliente, Long>{

}
