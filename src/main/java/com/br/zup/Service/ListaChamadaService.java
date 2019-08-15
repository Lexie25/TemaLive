package com.br.zup.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.Models.ListaChamada;
import com.br.zup.Repositories.ListaChamadaRepository;

@Service
public class ListaChamadaService {

	@Autowired
	private ListaChamadaRepository listaChamadaRepository;
	
	public Iterable<ListaChamada> listaAlunos(){
		return listaChamadaRepository.findAll();
	}
	public ListaChamada adicionarAluno(ListaChamada listaChamada) {
	listaChamadaRepository.save(listaChamada);
	return listaChamada;
	}
	public ListaChamada buscarAluno(int id) {
		if(listaChamadaRepository.existsById(id)) {
			return listaChamadaRepository.findById(id).get();
		}
		return null;
	}
	public void atualizarAluno(int id,ListaChamada listaChamada) {
		listaChamada.setId(id);
		listaChamadaRepository.save(listaChamada);
	} 
	public void removerAluno(int id) {
		listaChamadaRepository.deleteById(id);
	}
}
