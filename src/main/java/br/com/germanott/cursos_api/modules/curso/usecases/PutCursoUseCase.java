package br.com.germanott.cursos_api.modules.curso.usecases;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.germanott.cursos_api.modules.curso.entities.CursoEntity;
import br.com.germanott.cursos_api.modules.curso.repository.CursoRepository;

@Service
public class PutCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoEntity execute(UUID id, CursoEntity cursoEntity) {
        Optional<CursoEntity> cursoOptional = this.cursoRepository.findById(id);

        if (cursoOptional.isEmpty()) {
            throw new RuntimeException("Curso não encontrado com o id: " + id);
        }

        CursoEntity cursoExists = cursoOptional.get();
        cursoExists.setName(cursoEntity.getName());
        cursoExists.setCategory(cursoEntity.getCategory());
        cursoExists.setStatus(cursoEntity.getStatus());

        return cursoRepository.save(cursoExists);

    }
}
