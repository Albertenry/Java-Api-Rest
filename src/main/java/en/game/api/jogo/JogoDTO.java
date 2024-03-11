package en.game.api.jogo;

import java.time.LocalDate;

public record JogoDTO(
        String nome,
        String descricao,
        LocalDate dataLancamento,
        String website,
        String genero,
        String urlCapa
) {
}
