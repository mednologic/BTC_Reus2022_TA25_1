package com.crud.h2.service;

import java.util.List;
import com.crud.h2.dto.Video;

public interface IVideoService {

	public List<Video> listarVideos(); // Listar All

	public Video guardarVideo(Video video); // Guarda un video CREATE

	public Video videoXID(Long id); // Leer datos de un video READ

	public Video actualizarVideo(Video video); // Actualiza datos del video UPDATE

	public void eliminarVideo(Long id);// Elimina el video DELETE
}
