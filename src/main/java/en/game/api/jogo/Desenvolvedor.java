package en.game.api.jogo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
public class Desenvolvedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    private LocalDate dataFundacao;
    private String website;
    private String sede;

    public Desenvolvedor() {
        // Construtor padrão vazio necessário para JPA
    }

    public Desenvolvedor(Long codigo, String nome, LocalDate dataFundacao, String website, String sede) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataFundacao = dataFundacao;
        this.website = website;
        this.sede = sede;
    }

    // Getters e Setters

}
