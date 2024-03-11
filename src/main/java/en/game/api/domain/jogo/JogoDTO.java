package en.game.api.domain.jogo;

import en.game.api.domain.desenvolvedor.DesenvolvedorDTO;

import java.time.LocalDate;

public record JogoDTO(
        String nome,
        String descricao,
        LocalDate dataLancamento,
        String website,
        String genero,
        String urlCapa,
        DesenvolvedorDTO desenvolvedor
) {
}
