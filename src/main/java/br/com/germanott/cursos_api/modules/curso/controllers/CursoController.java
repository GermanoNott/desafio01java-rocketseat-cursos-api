package br.com.germanott.cursos_api.modules.curso.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.germanott.cursos_api.modules.curso.entities.CursoEntity;
import br.com.germanott.cursos_api.modules.curso.usecases.CreateCursoUseCase;
import br.com.germanott.cursos_api.modules.curso.usecases.DeleteCursoUseCase;
import br.com.germanott.cursos_api.modules.curso.usecases.GetCursoUseCase;
import br.com.germanott.cursos_api.modules.curso.usecases.PatchCursoUseCase;
import br.com.germanott.cursos_api.modules.curso.usecases.PutCursoUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CreateCursoUseCase createCursoUseCase;

    @Autowired
    private DeleteCursoUseCase deleteCursoUseCase;

    @Autowired
    private GetCursoUseCase getCursosUseCase;

    @Autowired
    private PutCursoUseCase putCursoUseCase;

    @Autowired
    private PatchCursoUseCase patchCursoUseCase;

    @PostMapping("/create")
    public CursoEntity create(@Valid @RequestBody CursoEntity cursoEntity) {
        return this.createCursoUseCase.execute(cursoEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        this.deleteCursoUseCase.execute(id);
    }

    @GetMapping("/get")
    public List<CursoEntity> getAllCursos() {
        return this.getCursosUseCase.getAll();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CursoEntity> updateCurso(@PathVariable UUID id, @RequestBody CursoEntity cursoEntity) {
        try {
            CursoEntity curso = putCursoUseCase.execute(id, cursoEntity);
            return ResponseEntity.ok(curso);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/patch/{id}")
    public ResponseEntity<CursoEntity> patchCurso(@PathVariable UUID id) {
        try {
            CursoEntity curso = patchCursoUseCase.execute(id);
            return ResponseEntity.ok(curso);

        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
