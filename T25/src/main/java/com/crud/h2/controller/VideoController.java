package com.crud.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.h2.dto.Video;
import com.crud.h2.service.VideoServiceImpl;

@RestController
@RequestMapping("/api")
public class VideoController {

	@Autowired
	VideoServiceImpl videoServideImpl;
	
	@GetMapping("/videos")
	public List<Video> listarVideos(){
		return videoServideImpl.listarVideos();
	}
	
	@PostMapping("/videos")
	public Video salvarVideo(@RequestBody Video video) {
		
		return videoServideImpl.guardarVideo(video);
	}
	
	@GetMapping("/videos/{id}")
	public Video videoXID(@PathVariable(name="id") Long id) {
		
		Video video_xid= new Video();
		
		video_xid=videoServideImpl.videoXID(id);
		
		System.out.println("Video XID: "+video_xid);
		
		return video_xid;
	}
	
	@PutMapping("/videos/{id}")
	public Video actualizarVideo(@PathVariable(name="id")Long id,@RequestBody Video video) {
		
		Video video_seleccionado= new Video();
		Video video_actualizado= new Video();
		
		video_seleccionado= videoServideImpl.videoXID(id);
		
		video_seleccionado.setTitle(video.getTitle());
		video_seleccionado.setDirector(video.getDirector());
		video_seleccionado.setCliente(video.getCliente());
		
		video_actualizado = videoServideImpl.actualizarVideo(video_seleccionado);
		
		System.out.println("El video actualizado es: "+ video_actualizado);
		
		return video_actualizado;
	}
	
	@DeleteMapping("/videos/{id}")
	public void eliminarVideo(@PathVariable(name="id")Long id) {
		videoServideImpl.eliminarVideo(id);
	}
	
}
