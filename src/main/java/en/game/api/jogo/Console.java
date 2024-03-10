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
public class Console {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    private LocalDate dataLancamento;
    private String empresa;

    public Console() {
        // Construtor padrão vazio necessário para JPA
    }

    public Console(Long codigo, String nome, LocalDate dataLancamento, String empresa) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.empresa = empresa;
    }

    // Getters e Setters

}

