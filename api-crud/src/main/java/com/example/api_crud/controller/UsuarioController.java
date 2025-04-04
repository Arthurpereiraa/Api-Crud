package com.example.api_crud.controller;

import com.example.api_crud.model.Usuario;  // Importa a classe Usuario, que representa o modelo de dados
import com.example.api_crud.repository.UsuarioRepository;  // Importa o repositório para interagir com o banco de dados
import jakarta.validation.Valid;  // Importa a anotação para validação de campos do objeto
import org.springframework.beans.factory.annotation.Autowired;  // Importa o mecanismo de injeção de dependências do Spring
import org.springframework.http.ResponseEntity;  // Importa a classe para construir respostas HTTP
import org.springframework.web.bind.annotation.*;  // Importa as anotações para definir os endpoints REST

import java.util.List;  // Importa a classe List para retornar listas de objetos
import java.util.Optional;  // Importa a classe Optional para tratar resultados nulos de forma segura

// Define que esta classe é um controlador REST e vai expor endpoints HTTP
@RestController
@RequestMapping("/usuarios")  // Define a URL base para acessar os endpoints deste controlador
public class UsuarioController {

    // Injeta automaticamente o repositório para interagir com o banco de dados
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Método para listar todos os usuários cadastrados
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();  // Retorna todos os usuários do banco de dados
    }

    // Método para buscar um usuário pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);  // Busca o usuário pelo ID
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());  // Retorna o usuário ou 404 caso não encontrado
    }

    // Método para cadastrar um novo usuário
    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario usuarioSalvo = usuarioRepository.save(usuario);  // Salva o novo usuário no banco
        return ResponseEntity.ok(usuarioSalvo);  // Retorna o usuário salvo com status 200 OK
    }

    // Método para atualizar um usuário existente
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @Valid @RequestBody Usuario usuarioAtualizado) {
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();  // Retorna 404 se o usuário não existir
        }
        usuarioAtualizado.setId(id);  // Mantém o ID original
        Usuario usuarioSalvo = usuarioRepository.save(usuarioAtualizado);  // Atualiza o usuário no banco
        return ResponseEntity.ok(usuarioSalvo);  // Retorna o usuário atualizado
    }

    // Método para excluir um usuário pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();  // Retorna 404 se o usuário não existir
        }
        usuarioRepository.deleteById(id);  // Exclui o usuário do banco de dados
        return ResponseEntity.noContent().build();  // Retorna 204 No Content após a exclusão
    }
}
