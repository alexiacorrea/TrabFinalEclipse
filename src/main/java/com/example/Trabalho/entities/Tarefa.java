package com.example.Trabalho.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table( name = "tb_tarefas")
public class Tarefa {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50, nullable = false)
	private String titulo;
	@Column(length = 100, nullable = false)
	private String data;
	@Column(length = 500, nullable = false)
	private String conteudo;
	@Column(length = 50, nullable = false)
	private String status;


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Tarefa(Long id, String titulo, String data, String conteudo, String status) {
		this.id = id;
		this.titulo = titulo;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.status = status;
	}

	public Tarefa() {

	}

}
