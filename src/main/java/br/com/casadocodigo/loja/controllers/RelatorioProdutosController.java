package br.com.casadocodigo.loja.controllers;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.RelatorioProdutos;

@Controller
public class RelatorioProdutosController {
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	@ResponseBody
	@RequestMapping(path="/relatorio-produtos", method=RequestMethod.GET)
	public RelatorioProdutos relatorio(@RequestParam(required = false) @DateTimeFormat(iso = ISO.DATE) Calendar data) {
		List<Produto> produtos = produtoDAO.listar(data);
		return new RelatorioProdutos(produtos);
	}
	
}
