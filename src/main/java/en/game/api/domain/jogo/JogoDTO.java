package en.game.api.domain.jogo;

import en.game.api.domain.console.ConsoleDTO;
import en.game.api.domain.desenvolvedor.DesenvolvedorDTO;

import java.time.LocalDate;
import java.util.List;

public record JogoDTO(
        String nome,
        String descricao,
        LocalDate dataLancamento,
        String website,
        String genero,
        String urlCapa,
        DesenvolvedorDTO desenvolvedor,
        List<ConsoleDTO> consoles
) {
}
