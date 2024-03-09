package en.game.api.jogo;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Getter
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

    @OneToOne(cascade = CascadeType.MERGE)
    private Desenvolvedor desenvolvedor;

    private String genero;
    private String urlCapa;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Console[] console;


    public Jogo(DadosCadastroJogos dados) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.dataLancamento = dados.dataLancamento();
        this.website = dados.website();
        this.desenvolvedor = dados.desenvolvedor();
        this.genero = dados.genero();
        this.urlCapa = dados.urlCapa();
        this.console = dados.consoles();
    }
}