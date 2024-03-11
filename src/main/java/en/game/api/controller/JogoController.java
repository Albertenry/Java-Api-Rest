package en.game.api.controller;

import en.game.api.jogo.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("jogos")
public class JogoController {

    private final JogoRepository jogoRepository;

    public JogoController(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody JogoDTO dados) {
        Jogo jogo = new Jogo(dados);
        jogoRepository.save(jogo);
    }

    @GetMapping
    public ResponseEntity<List<Jogo>> listarTodos() {
        List<Jogo> jogos = jogoRepository.findAll();
        return new ResponseEntity<>(jogos, HttpStatus.OK);
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Optional<Jogo>> pegarPorId(@PathVariable Long id){
        Optional<Jogo> jogo;
        jogo = jogoRepository.findById(id);
        if (jogo.isPresent()) {
            return new ResponseEntity<>(jogo, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Optional<Jogo>> deletarPorId(@PathVariable Long id){
        try {
            jogoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException erro) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Jogo> update(@PathVariable Long id, @RequestBody JogoDTO dados){
        return jogoRepository.findById(id)
                .map(jogo -> {
                    jogo.setNome(dados.nome());
                    jogo.setDescricao(dados.descricao());
                    jogo.setGenero(dados.genero());
                    jogo.setWebsite(dados.website());
                    jogo.setDataLancamento(dados.dataLancamento());
                    jogo.setUrlCapa(dados.urlCapa());
                    Jogo jogoUpdated = jogoRepository.save(jogo);
                    return ResponseEntity.ok().body(jogoUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }
}
