package com.crud.h2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.h2.dto.Fabricante;

public interface IFabricanteDAO  extends JpaRepository<Fabricante, Long>{

}
