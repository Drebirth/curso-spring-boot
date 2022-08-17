package com.curso.helpdesk.services;

import com.curso.helpdesk.domain.Chamado;
import com.curso.helpdesk.repository.ChamadoRepository;
import com.curso.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository repository;

    public Chamado findById(Integer id){
        Optional<Chamado> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Chamado não encontrado" + id));
    }

    public List<Chamado> findAll() {
        return repository.findAll();
    }
}
