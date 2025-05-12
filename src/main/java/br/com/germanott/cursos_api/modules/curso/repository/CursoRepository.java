package br.com.germanott.cursos_api.modules.curso.repository;

import java.lang.StackWalker.Option;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.germanott.cursos_api.modules.curso.entities.CursoEntity;

public interface CursoRepository extends JpaRepository<CursoEntity, UUID> {
    Optional<CursoEntity> findByNameAndCategory(String name, String category);
}
