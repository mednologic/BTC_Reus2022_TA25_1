package com.crud.h2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.h2.dto.Articulo;

public interface IArticuloDAO extends JpaRepository<Articulo, Long>{

}
