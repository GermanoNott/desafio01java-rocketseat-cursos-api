package br.com.germanott.cursos_api.modules.curso.usecases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.germanott.cursos_api.modules.curso.repository.CursoRepository;

@Service
public class DeleteCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public void execute(UUID id) {
        this.cursoRepository.deleteById(id);
    }
}
