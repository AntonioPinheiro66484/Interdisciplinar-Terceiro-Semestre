package com.fatec.SIG2.adapters;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.SIG2.model.Produto;
import com.fatec.SIG2.ports.MantemProduto;

@Controller
@RequestMapping(path = "/sig")
public class GUIProdutoController {
	Logger logger = LogManager.getLogger(GUIProdutoController.class);
	@Autowired
	MantemProduto servico;

	@GetMapping("/produtos")
	public ModelAndView retornaFormDeConsultaTodosProdutos() {
		ModelAndView modelAndView = new ModelAndView("consultarProduto");
		modelAndView.addObject("produtos", servico.consultaTodos());
		return modelAndView;
	}

	@GetMapping("/produtos")
	public ModelAndView retornaFormDeCadastroDe(Produto produto) {
		ModelAndView mv = new ModelAndView("cadastrarProduto");
		mv.addObject("produto", produto);
		return mv;
	}

	@GetMapping("/produtos/{cpfFabricante}") // diz ao metodo que ira responder a uma requisicao do tipo get
	public ModelAndView retornaFormParaEditarProduto(@PathVariable("cpfFabricante") String cpfFabricante) {
		ModelAndView modelAndView = new ModelAndView("atualizarFabricante");
		modelAndView.addObject("fabricante", servico.consultaPorCpf(cpfFabricante).get()); // retorna um objeto do tipo Produto
		return modelAndView; // addObject adiciona objetos para view
	}

	@GetMapping("/idProduto/idProduto/{idProduto}")
	public ModelAndView excluirNoFormDeConsultaProduto(@PathVariable("idProduto") Long idProduto) {
		servico.delete(idProduto);
		logger.info(">>>>>> 1. servico de exclusao chamado para o idProduto => " + idProduto);
		ModelAndView modelAndView = new ModelAndView("consultarProduto");
		modelAndView.addObject("produtos", servico.consultaTodos());
		return modelAndView;
	}

	@PostMapping("/produtos")
	public ModelAndView save(@Valid Produto produto, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("consultarProduto");
		if (result.hasErrors()) {
			modelAndView.setViewName("cadastrarProduto");
		} else {
			if (servico.save(produto).isPresent()) {
				logger.info(">>>>>> controller chamou adastrar e consulta todos");
				modelAndView.addObject("produtos", servico.consultaTodos());
			} else {
				logger.info(">>>>>> controller cadastrar com dados invalidos");
				modelAndView.setViewName("cadastrarProduto");
				modelAndView.addObject("message", "Dados invalidos");
			}
		}
		return modelAndView;
	}

	@PostMapping("/produtos/idProdutos/{idProdutos}")
	public ModelAndView atualizaProduto(@PathVariable("idProduto") Long idProduto, @Valid Produto produto, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("consultarProduto");
		logger.info(">>>>>> servico para atualizacao de dados chamado para o idProduto => " + idProduto);
		if (result.hasErrors()) {
			logger.info(">>>>>> servico para atualizacao de dados com erro => " + result.getFieldError().toString());
			produto.setId(idProduto);
			return new ModelAndView("atualizarProdutos");
		} else {
			servico.altera(produto);
			modelAndView.addObject("produtos", servico.consultaTodos());
		}
		return modelAndView;
	}
}
