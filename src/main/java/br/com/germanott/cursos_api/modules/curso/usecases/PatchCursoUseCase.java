package br.com.germanott.cursos_api.modules.curso.usecases;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.germanott.cursos_api.modules.curso.entities.CursoActive;
import br.com.germanott.cursos_api.modules.curso.entities.CursoEntity;
import br.com.germanott.cursos_api.modules.curso.repository.CursoRepository;

@Service
public class PatchCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoEntity execute(UUID id) {
        Optional<CursoEntity> cursoOptional = this.cursoRepository.findById(id);
        if (cursoOptional.isEmpty()) {
            throw new RuntimeException("Curso não encontrado com o id: " + id);
        }

        CursoEntity cursoExists = cursoOptional.get();
        cursoExists.setStatus(cursoExists.getStatus() == CursoActive.ACTIVE
                ? CursoActive.INACTIVE
                : CursoActive.ACTIVE);

        return cursoRepository.save(cursoExists);
    }
}
