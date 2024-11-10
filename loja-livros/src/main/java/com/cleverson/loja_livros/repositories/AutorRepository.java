package com.cleverson.loja_livros.repositories;


import com.cleverson.loja_livros.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface AutorRepository extends JpaRepository<Autor, UUID> {

}
