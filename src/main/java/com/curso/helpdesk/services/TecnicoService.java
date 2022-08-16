package com.curso.helpdesk.services;

import com.curso.helpdesk.domain.Pessoa;
import com.curso.helpdesk.domain.Tecnico;
import com.curso.helpdesk.domain.dtos.TecnicoDTO;
import com.curso.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.curso.helpdesk.services.exceptions.ObjectNotFoundException;
import com.curso.helpdesk.repository.PessoaRepository;
import com.curso.helpdesk.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!" + id));

    }

    public List<Tecnico> findAll(){
        return repository.findAll();
    }


    public Tecnico create(TecnicoDTO objDTO) {
        objDTO.setId(null);
        validaPorCpfEEmail(objDTO);
        Tecnico newObj = new Tecnico(objDTO);
        return repository.save(newObj);
    }

    private void validaPorCpfEEmail(TecnicoDTO objDTO) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
        if (obj.isPresent() && obj.get().getId() != objDTO.getId()){
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }

        obj = pessoaRepository.findByEmail(objDTO.getEmail());
        if (obj.isPresent() && obj.get().getEmail() != objDTO.getEmail()){
            throw new DataIntegrityViolationException("Email já cadastrado no sistema!");
        }
    }
}
