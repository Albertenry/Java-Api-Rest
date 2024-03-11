package en.game.api.domain.console;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")
@Entity(name = "Console")
@Table(name = "consoles")
public class Console {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    private LocalDate dataLancamento;
    private String empresa;

    public Console(ConsoleDTO dados) {
        if (dados.codigo() != null) {
            codigo = dados.codigo();
        }
        nome = dados.nome();
        dataLancamento = dados.dataLancamento();
        empresa = dados.empresa();
    }
}
