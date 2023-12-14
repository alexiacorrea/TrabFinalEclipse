package com.example.Trabalho.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Trabalho.entities.Tarefa;
import com.example.Trabalho.repository.TarefaRepository;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin
public class TarefaController {
	@Autowired
	TarefaRepository repo;
	
	@GetMapping()
	public ResponseEntity<List<Tarefa>> getTarefas() {
		return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
	}
		
	@PostMapping()
	public ResponseEntity<Tarefa> inserirTarefa(@RequestBody Tarefa tarefa) {
		Tarefa tf = repo.save(tarefa);
		return ResponseEntity.status(HttpStatus.CREATED).body(tf);
	}
	
	@PutMapping("/{idtarefa}")
	public ResponseEntity<Tarefa> alterarTarefa(@PathVariable("idtarefa") Long idtarefa, 
			@RequestBody Tarefa tarefa) {
		Optional<Tarefa> opTarefa = repo.findById(idtarefa);
		try {
			Tarefa tf = opTarefa.get();		
			tf.setTitulo(tarefa.getTitulo());
			tf.setData(tarefa.getData());
			tf.setConteudo(tarefa.getConteudo());
			tf.setStatus(tarefa.getStatus());
			repo.save(tf);
			return ResponseEntity.status(HttpStatus.OK).body(tf);
		}
		catch(Exception e) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> getUmaTarefa(@PathVariable("id") long id) {
		Optional<Tarefa> opTarefa = repo.findById(id);
		try {
			Tarefa tf = opTarefa.get();		
			return ResponseEntity.status(HttpStatus.OK).body(tf);
		}
		catch(Exception e) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Tarefa> excluirUmaTarefa(@PathVariable("id") long id) {
		Optional<Tarefa> opTarefa= repo.findById(id);
		try {
			Tarefa tf = opTarefa.get();	
			repo.delete(tf);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
}
