package com.example.api_crud.repository;

import com.example.api_crud.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Indica que esta interface é um repositório de acesso ao banco de dados
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // O Spring Data JPA já fornece os métodos básicos de CRUD automaticamente
}
