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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HelpdeskApplication{

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}


}
