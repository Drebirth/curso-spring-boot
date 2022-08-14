package com.curso.helpdesk.services;

import com.curso.helpdesk.domain.Tecnico;
import com.curso.helpdesk.exceptions.ObjectNotFoundException;
import com.curso.helpdesk.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!" + id));

    }



}
