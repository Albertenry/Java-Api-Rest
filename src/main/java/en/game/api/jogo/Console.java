package en.game.api.jogo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public record Console(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long codigo,
        String nome,
        LocalDate dataLancamento,
        String empresa
) {

}

