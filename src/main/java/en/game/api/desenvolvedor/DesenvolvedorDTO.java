package en.game.api.desenvolvedor;

import java.time.LocalDate;

public record DesenvolvedorDTO(
        Long codigo,
        String nome,
        LocalDate dataFundacao,
        String website,
        String sede
)  {
}
