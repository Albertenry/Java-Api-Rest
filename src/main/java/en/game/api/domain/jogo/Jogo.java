package en.game.api.domain.jogo;

import en.game.api.domain.console.Console;
import en.game.api.domain.desenvolvedor.Desenvolvedor;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")
@Entity(name = "Jogo")
@Table(name = "jogos")
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    private String descricao;
    private LocalDate dataLancamento;
    private String website;
    private String genero;
    private String urlCapa;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "desenvolvedor_codigo", nullable = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    private Desenvolvedor desenvolvedor;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "jogos_consoles",
            joinColumns = @JoinColumn(name = "jogo_codigo"),
            inverseJoinColumns = @JoinColumn(name = "console_codigo")
    )
    private List<Console> consoles;

    public Jogo(JogoDTO dados) {
        nome = dados.nome();
        descricao = dados.descricao();
        dataLancamento = dados.dataLancamento();
        website = dados.website();
        genero = dados.genero();
        urlCapa = dados.urlCapa();
        desenvolvedor = new Desenvolvedor(dados.desenvolvedor());

        consoles = dados.consoles()
                .stream()
                .map(Console::new)
                .toList();
    }
}
