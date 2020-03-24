package br.com.casadocodigo.loja.models;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class NovoUsuarioForm {
	
	private String nome;
	private String email;
	private String senha;
	private String senhaRepetida;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getSenhaRepetida() {
		return senhaRepetida;
	}
	public void setSenhaRepetida(String senhaRepetida) {
		this.senhaRepetida = senhaRepetida;
	}
	
	public Usuario geraUsuario() {
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setNome(nome);
		String senhaCryptografada = BCrypt.hashpw(senha,BCrypt.gensalt());
		usuario.setSenha(senhaCryptografada);
		return usuario;
	}

}
