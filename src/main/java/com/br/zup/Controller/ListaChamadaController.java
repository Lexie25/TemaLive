package com.br.zup.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.zup.Models.ListaChamada;
import com.br.zup.Service.ListaChamadaService;

@RestController
@RequestMapping("/chamada")
public class ListaChamadaController {

	@Autowired
	private ListaChamadaService listaChamadaService;

	@PostMapping
	public ResponseEntity<?> adicionarAluno(@RequestBody ListaChamada listaChamada){
		return ResponseEntity.status(HttpStatus.CREATED).body(listaChamadaService.adicionarAluno(listaChamada))	;
	}
	@GetMapping
	public ResponseEntity<?> listaAlunos(){
		return ResponseEntity.ok(listaChamadaService.listaAlunos());
	}
	@GetMapping("/{id}")
	public ResponseEntity<ListaChamada> buscarAluno(@PathVariable int id){
		ListaChamada listaChamadaObj = listaChamadaService.buscarAluno(id);
		if(listaChamadaObj == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(listaChamadaObj);
	}
	@PutMapping("/{id}")
	public ResponseEntity<ListaChamada> atualizarAluno(@PathVariable int id, @RequestBody ListaChamada listaChamada){
	listaChamadaService.atualizarAluno(id,listaChamada);
	return ResponseEntity.ok(listaChamada);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removerAluno(@PathVariable int id){
	listaChamadaService.removerAluno(id);
	return ResponseEntity.ok().build();
	}
}
