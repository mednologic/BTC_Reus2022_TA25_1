package com.crud.h2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.h2.dto.Video;

public interface IVideoDAO extends JpaRepository<Video, Long>{

}
