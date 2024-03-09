package en.game.api.jogo;

import java.time.LocalDate;

public record DadosCadastroJogos(

        String nome,
        String descricao,
        LocalDate dataLancamento,
        String website,
        Desenvolvedor desenvolvedor,
        String genero,
        String urlCapa,
        Console[] consoles

) {
}
