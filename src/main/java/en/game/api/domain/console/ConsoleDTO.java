package en.game.api.domain.console;

import java.time.LocalDate;

public record ConsoleDTO(
        Long codigo,
        String nome,
        LocalDate dataLancamento,
        String empresa
) {
}
