package br.com.casadocodigo.loja.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.RoleDAO;
import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.NovoUsuarioForm;
import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.Usuario;
import br.com.casadocodigo.loja.validation.UsuarioValidation;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private RoleDAO roleDAO;
	
	@InitBinder("novoUsuario")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new UsuarioValidation(this.usuarioDAO));
	}
	
	@RequestMapping(path="/form")
	public ModelAndView form(NovoUsuarioForm novoUsuario) {
		ModelAndView modelAndView = new ModelAndView("usuarios/form");
		modelAndView.addObject("novoUsuario", novoUsuario);
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@Transactional
	public ModelAndView cadastra(@ModelAttribute("novoUsuario") @Valid NovoUsuarioForm novoUsuario,BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return form(novoUsuario);
		}
		usuarioDAO.gravar(novoUsuario.geraUsuario());
		attributes.addFlashAttribute("message", "Usuário " + novoUsuario.getNome() + " cadastrado com sucesso!");
		return new ModelAndView("redirect:/usuarios");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView lista() {
		ModelAndView modelAndView = new ModelAndView("usuarios/lista");
		modelAndView.addObject("usuarios", usuarioDAO.lista());
		return modelAndView;
	}
	
	@RequestMapping(path="/roles/{id}", method = RequestMethod.GET)
	public ModelAndView editaRoleForm(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("usuarios/roleForm");
		modelAndView.addObject("roles", roleDAO.lista());
		Usuario usuario = usuarioDAO.find(id);
		modelAndView.addObject("usuario", usuario);
		modelAndView.addObject("userRoles", usuario.getRoles());
		return modelAndView;
	}
	
	
	@RequestMapping(path="/roles/", method = RequestMethod.POST)
	@Transactional
	public ModelAndView editaRoles(Usuario usuario, RedirectAttributes attributes) {
		List<Role> roles = usuario.getRoles();
		usuario = usuarioDAO.find(usuario.getId());
		usuario.setRoles(roles);
		attributes.addFlashAttribute("message", "Permissões alteradas com sucesso!");
		ModelAndView modelAndView = new ModelAndView("redirect:/usuarios");
		return modelAndView;
	}
}
