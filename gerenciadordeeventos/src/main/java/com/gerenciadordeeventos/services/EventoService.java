package com.gerenciadordeeventos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciadordeeventos.entities.Evento;
import com.gerenciadordeeventos.repositories.EventoRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository eventoRepository;
	
	
	public Evento cadastrarEvento(Evento evento) {
		return eventoRepository.save(evento);
	}
	
	public List<Evento> listaEventos(){
		return eventoRepository.findAll();
	}
	
	public Evento obterEvento(Long id) throws Exception {
		
		Optional<Evento> evento = eventoRepository.findById(id);
		
		if(evento.isEmpty()) {
			throw new Exception("Evento não encontrado!");
		}
		
		return evento.get();
		
		}
	
	public void deletarEvento(Long id) {
		eventoRepository.deleteById(id);
	}
	
}
