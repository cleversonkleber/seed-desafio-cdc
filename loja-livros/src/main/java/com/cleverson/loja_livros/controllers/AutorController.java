package com.cleverson.loja_livros.controllers;


import com.cleverson.loja_livros.entities.Autor;
import com.cleverson.loja_livros.services.AutorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public String cadastrar(@RequestBody @Valid NovoAutorRequest autorRequest){
        Autor autor = autorRequest.toModel();
        autorService.salvar(autor);
       return "Criando autor....";
    }

    @GetMapping
    public ResponseEntity<List<Autor>> getAllAutores(){
        return ResponseEntity.status(HttpStatus.OK).body(autorService.getAll());
    }


}
