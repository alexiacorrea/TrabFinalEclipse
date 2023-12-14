package com.example.Trabalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Trabalho.entities.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

}
