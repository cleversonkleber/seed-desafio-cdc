package com.cleverson.loja_livros.services;

import com.cleverson.loja_livros.entities.Autor;
import com.cleverson.loja_livros.repositories.AutorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class AutorService {

    public final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> getAll(){
        return autorRepository.findAll();
    }

    @Transactional
    public Autor salvar(Autor autor){
        autor.setDatahoraCriacao(LocalDateTime.now(ZoneId.of("UTC")));
        return autorRepository.save(autor);
    }
}
