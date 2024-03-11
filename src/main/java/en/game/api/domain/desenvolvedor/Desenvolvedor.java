package en.game.api.domain.desenvolvedor;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")
@Entity(name = "Desenvolvedor")
@Table(name = "desenvolvedores")
public class Desenvolvedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    private LocalDate dataFundacao;
    private String website;
    private String sede;

    public Desenvolvedor(DesenvolvedorDTO dados) {
        if (dados.codigo() != null) {
            codigo = dados.codigo();
        }
        nome = dados.nome();
        dataFundacao = dados.dataFundacao();
        website = dados.website();
        sede = dados.sede();
    }
}
