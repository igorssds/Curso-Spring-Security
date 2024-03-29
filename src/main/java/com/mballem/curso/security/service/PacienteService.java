package com.mballem.curso.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mballem.curso.security.domain.Paciente;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repository;
	
	@Transactional(readOnly = true)
	public Paciente buscarPorUsuarioEmail(String email) {
		return repository.findByUsuarioEmail(email).orElse(new Paciente());
	}
	@Transactional(readOnly = false)
	public void salvar(Paciente paciente) {
		repository.save(paciente);
	}
	
	
}
