package com.isaac.academia.academiaapi.controller;

import com.isaac.academia.academiaapi.model.Treino;
import com.isaac.academia.academiaapi.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/treinos")
@CrossOrigin("*")
public class TreinoController {

    @Autowired
    private TreinoRepository repository;

    @GetMapping
    public List<Treino> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Treino salvarTreino(@RequestBody Treino treino) {
        // Validação Manual: Se o nome for vazio ou a carga for menor que 1
        if (treino.getExercicio() == null || treino.getExercicio().trim().isEmpty()) {
            throw new RuntimeException("O nome do exercício é obrigatório!");
        }
        if (treino.getCarga() <= 0) {
            throw new RuntimeException("A carga deve ser maior que zero!");
        }


        treino.setVolumeTotal(treino.getCarga() * treino.getSeries() * treino.getRepeticoes());
        return repository.save(treino);
    }

    @DeleteMapping("/{id}")
    public void deletarTreino(@PathVariable Long id) {
        repository.deleteById(id);
    }
}