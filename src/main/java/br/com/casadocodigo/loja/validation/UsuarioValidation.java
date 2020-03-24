package br.com.casadocodigo.loja.validation;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.NovoUsuarioForm;

public class UsuarioValidation implements Validator {
	
	private UsuarioDAO dao;

	public UsuarioValidation(UsuarioDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return NovoUsuarioForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nome", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "email", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "senha", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "senhaRepetida", "field.required");
		
		NovoUsuarioForm novoUsuario = (NovoUsuarioForm) target;
		
		try {
			dao.loadUserByUsername(novoUsuario.getEmail());
			errors.rejectValue("email", "usuario.email.exists");
		}catch(UsernameNotFoundException e) {
			
		}
		
		if(novoUsuario.getSenha().length() < 5) {
			errors.rejectValue("senha", "usuario.password.short");
		}
		
		
		if(!novoUsuario.getSenha().equals(novoUsuario.getSenhaRepetida())) {
			errors.rejectValue("senhaRepetida", "usuario.passwords.different");
		}

	}

}
