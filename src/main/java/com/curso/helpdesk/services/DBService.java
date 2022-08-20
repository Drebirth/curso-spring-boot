package com.curso.helpdesk.services;

import com.curso.helpdesk.domain.Chamado;
import com.curso.helpdesk.domain.Cliente;
import com.curso.helpdesk.domain.Tecnico;
import com.curso.helpdesk.domain.enums.Perfil;
import com.curso.helpdesk.domain.enums.Prioridade;
import com.curso.helpdesk.domain.enums.Status;
import com.curso.helpdesk.repository.ChamadoRepository;
import com.curso.helpdesk.repository.ClienteRepository;
import com.curso.helpdesk.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;


    public void instanciaDB(){
        Tecnico tec1 = new Tecnico(null,"Daniel","701.123.043-12","daniel@hotmail.com", encoder.encode("123"));
        tec1.addPerfil(Perfil.ADMIN);


        Cliente cli1 = new Cliente(null,"Linus Torvalds", "701.164.046-05","torvalds@email.com", encoder.encode("231"));

       Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO,"chmado 01","Primeiro chamado", tec1, cli1);

        tecnicoRepository.saveAll(Arrays.asList(tec1));
        clienteRepository.saveAll(Arrays.asList(cli1));
        chamadoRepository.saveAll(Arrays.asList(c1));

    }

}
