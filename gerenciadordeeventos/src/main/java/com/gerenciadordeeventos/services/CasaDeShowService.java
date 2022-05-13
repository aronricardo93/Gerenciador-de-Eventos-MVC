package com.gerenciadordeeventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciadordeeventos.entities.CasaDeShow;
import com.gerenciadordeeventos.repositories.CasaDeShowRepository;

@Service
public class CasaDeShowService {

	@Autowired
	private CasaDeShowRepository casadeshowRepository;
	
	
	public CasaDeShow obterCasaDeShow(Long id) {
		return casadeshowRepository.getById(id);
	}
	
	public CasaDeShow salvarCasaDeShow(CasaDeShow casaDeShow) {
		return casadeshowRepository.save(casaDeShow); 
	}
	
	public List<CasaDeShow> casasDeShows(){
		return casadeshowRepository.findAll();
	}
	
	public void excluirCasaDeShow(Long id) {
		casadeshowRepository.deleteById(id);
	}
}
