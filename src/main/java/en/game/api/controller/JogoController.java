package en.game.api.controller;


import en.game.api.jogo.DadosCadastroJogos;
import en.game.api.jogo.Jogo;
import en.game.api.jogo.JogoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jogos")
public class JogoController {
    @Autowired
    private JogoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroJogos dados) {

        repository.save(new Jogo(dados));

    }

}
