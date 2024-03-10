package en.game.api.controller;

import en.game.api.jogo.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("jogos")
public class JogoController {

    private final JogoRepository jogoRepository;
    private final DesenvolvedorRepository desenvolvedorRepository;

    public JogoController(JogoRepository jogoRepository, DesenvolvedorRepository desenvolvedorRepository) {
        this.jogoRepository = jogoRepository;
        this.desenvolvedorRepository = desenvolvedorRepository;
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroJogos dados) {
        Desenvolvedor desenvolvedor;

        if (dados.desenvolvedor().getCodigo() == null) {
            desenvolvedor = desenvolvedorRepository.save(dados.desenvolvedor());
        } else {
            desenvolvedor = desenvolvedorRepository.findById(dados.desenvolvedor().getCodigo())
                    .orElseThrow(() -> new EntityNotFoundException("Desenvolvedor não encontrado com o código: " + dados.desenvolvedor().getCodigo()));
        }

        Jogo jogo = new Jogo(dados);
        jogo.setDesenvolvedor(desenvolvedor);
        jogoRepository.save(jogo);
    }
}
