package br.com.casadocodigo.loja.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.models.Pedido;

@Controller
public class PedidosServicoController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(path="/pedidos", method = RequestMethod.GET)
	public ModelAndView pedidos() {
		ResponseEntity<Pedido[]> response = restTemplate.getForEntity("https://book-payment.herokuapp.com/orders", Pedido[].class);
		List<Pedido> pedidos = Arrays.asList(response.getBody());
		ModelAndView modelAndView = new ModelAndView("pedidos");
		modelAndView.addObject("pedidos", pedidos);
		return modelAndView;
	}

}
