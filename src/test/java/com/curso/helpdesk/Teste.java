package com.curso.helpdesk;

import com.curso.helpdesk.domain.Chamado;
import com.curso.helpdesk.domain.Cliente;
import com.curso.helpdesk.domain.Tecnico;
import com.curso.helpdesk.domain.enums.Perfil;
import com.curso.helpdesk.domain.enums.Prioridade;
import com.curso.helpdesk.domain.enums.Status;
import com.curso.helpdesk.repository.ChamadoRepository;
import com.curso.helpdesk.repository.ClienteRepository;
import com.curso.helpdesk.repository.TecnicoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class Teste {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Test
    public void testandoAplicacao(){
            Tecnico tec1 = new Tecnico(null,"Daniel","72314306201","daniel@hotmail.com", "123");
            tec1.addPerfil(Perfil.ADMIN);

            Cliente cli1 = new Cliente(null,"Linus Torvalds", "12345678901","torvalds@email.com", "123");

            Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO,"chmado 01","Primeiro chamado", tec1, cli1);

            tecnicoRepository.saveAll(Arrays.asList(tec1));
            clienteRepository.saveAll(Arrays.asList(cli1));
            chamadoRepository.saveAll(Arrays.asList(c1));

            System.out.println("TECNICO" +tecnicoRepository.findAll());
            System.out.println("CLIENTE" +clienteRepository.findAll());
            System.out.println("CHAMADO" +chamadoRepository.findAll());



        }
    }

