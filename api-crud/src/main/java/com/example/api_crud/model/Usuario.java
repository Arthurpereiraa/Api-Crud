package com.example.api_crud.model;

import jakarta.persistence.Entity;  // Importa a anotação para marcar a classe como uma entidade JPA (banco de dados)
import jakarta.persistence.GeneratedValue;  // Importa a anotação para indicar que o campo 'id' será gerado automaticamente
import jakarta.persistence.GenerationType;  // Importa as estratégias de geração do valor (como auto-increment)
import jakarta.persistence.Id;  // Importa a anotação para marcar o campo 'id' como a chave primária
import jakarta.validation.constraints.Email;  // Importa a validação de formato de email
import jakarta.validation.constraints.NotBlank;  // Importa a validação para garantir que o campo não seja nulo ou vazio
import jakarta.validation.constraints.Size;  // Importa a validação de tamanho para strings

// A anotação @Entity marca esta classe como uma entidade JPA, ou seja, ela será mapeada para uma tabela no banco de dados
@Entity
public class Usuario {

    // A anotação @Id indica que o campo 'id' é a chave primária da tabela no banco de dados
    @Id
    // A anotação @GeneratedValue com a estratégia GenerationType.IDENTITY faz com que o banco de dados gere o valor automaticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // A anotação @NotBlank garante que o campo 'nome' não pode ser vazio nem nulo
    @NotBlank(message = "O nome é obrigatório")  // Mensagem personalizada para o erro de validação
    // A anotação @Size limita o tamanho do nome, garantindo que tenha entre 3 e 100 caracteres
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    // A anotação @NotBlank garante que o campo 'email' não pode ser vazio nem nulo
    @NotBlank(message = "O email é obrigatório")
    // A anotação @Email valida se o valor inserido é um email válido
    @Email(message = "O email deve ser válido")
    private String email;

    // A anotação @NotBlank garante que o campo 'senha' não pode ser vazio nem nulo
    @NotBlank(message = "A senha é obrigatória")
    // A anotação @Size limita o tamanho da senha, garantindo que tenha entre 5 e 20 caracteres
    @Size(min = 5, max = 20, message = "A senha deve ter entre 5 e 20 caracteres")
    private String senha;

    // Métodos getters e setters são utilizados para acessar e modificar os valores das propriedades do objeto

    public Long getId() {
        return id;  // Retorna o valor do campo 'id'
    }

    public void setId(Long id) {
        this.id = id;  // Define o valor para o campo 'id'
    }

    public String getNome() {
        return nome;  // Retorna o valor do campo 'nome'
    }

    public void setNome(String nome) {
        this.nome = nome;  // Define o valor para o campo 'nome'
    }

    public String getEmail() {
        return email;  // Retorna o valor do campo 'email'
    }

    public void setEmail(String email) {
        this.email = email;  // Define o valor para o campo 'email'
    }

    public String getSenha() {
        return senha;  // Retorna o valor do campo 'senha'
    }

    public void setSenha(String senha) {
        this.senha = senha;  // Define o valor para o campo 'senha'
    }
}
