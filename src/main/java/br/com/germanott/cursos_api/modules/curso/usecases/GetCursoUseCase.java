package br.com.germanott.cursos_api.modules.curso.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.germanott.cursos_api.modules.curso.entities.CursoEntity;
import br.com.germanott.cursos_api.modules.curso.repository.CursoRepository;

@Service
public class GetCursoUseCase {
    @Autowired
    private CursoRepository cursoRepository;

    public List<CursoEntity> getAll() {
        return cursoRepository.findAll(); //
    }

}
