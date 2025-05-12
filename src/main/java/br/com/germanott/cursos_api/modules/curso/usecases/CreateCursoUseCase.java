package br.com.germanott.cursos_api.modules.curso.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.germanott.cursos_api.modules.curso.entities.CursoEntity;
import br.com.germanott.cursos_api.modules.curso.repository.CursoRepository;
import br.com.germanott.cursos_api.modules.exceptions.EntityFoundException;

@Service
public class CreateCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoEntity execute(CursoEntity cursoEntity) {
        this.cursoRepository.findByNameAndCategory(cursoEntity.getName(), cursoEntity.getCategory())
                .ifPresent(user -> {
                    throw new EntityFoundException("Curso já cadastrado com o nome: " + cursoEntity.getName());
                });

        return this.cursoRepository.save(cursoEntity);

    }
}
