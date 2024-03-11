package en.game.api.jogo;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Jogo")
@Table(name = "jogos")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private LocalDate dataLancamento;
    private String website;
    private String genero;
    private String urlCapa;

    public Jogo(JogoDTO dados) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.dataLancamento = dados.dataLancamento();
        this.website = dados.website();
        this.genero = dados.genero();
        this.urlCapa = dados.urlCapa();
    }

}
