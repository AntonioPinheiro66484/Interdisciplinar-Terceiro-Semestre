package com.fatec.SIG2.adapters;
import java.util.Optional;
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
	MantemProduto servicoProdutoProduto;

	@GetMapping("/produto")
	public ModelAndView retornaFormDeConsultaTodosProduto() {
		ModelAndView modelAndView = new ModelAndView("consultarProduto");
		modelAndView.addObject("produto", servicoProduto.consultaTodos());
		return modelAndView;
	}

	@GetMapping("/produto")
	public ModelAndView retornaFormDeCadastroDe(Produto produto) {
		ModelAndView mv = new ModelAndView("cadastrarProduto");
		mv.addObject("produto", produto);
		return mv;
	}

	@GetMapping("/produto/{id}") // diz ao metodo que ira responder a uma requisicao do tipo get
	public ModelAndView retornaFormParaEditarProduto(@PathVariable("cpf") String cpf) {
		ModelAndView modelAndView = new ModelAndView("atualizarProduto");
		modelAndView.addObject("produto", servicoProduto.consultaPorCpf(cpf).get()); // retorna um objeto do tipo Produto
		return modelAndView; // addObject adiciona objetos para view
	}

	@GetMapping("/produto/id/{id}")
	public ModelAndView excluirNoFormDeConsultaProduto(@PathVariable("id") Long id) {
		servicoProduto.delete(id);
		logger.info(">>>>>> 1. servicoProduto de exclusao chamado para o id => " + id);
		ModelAndView modelAndView = new ModelAndView("consultarProduto");
		modelAndView.addObject("produto", servicoProduto.consultaTodos());
		return modelAndView;
	}

	@PostMapping("/produto")
	public ModelAndView save(@Valid Produto produto, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("consultarProduto");
		if (result.hasErrors()) {
			modelAndView.setViewName("cadastrarProduto");
		} else {
			if (servicoProdutoProduto.save(produto).isPresent()) {
				logger.info(">>>>>> controller chamou adastrar e consulta todos");
				modelAndView.addObject("produto", servicoProduto.consultaTodos());
			} else {
				logger.info(">>>>>> controller cadastrar com dados invalidos");
				modelAndView.setViewName("cadastrarProduto");
				modelAndView.addObject("message", "Dados invalidos");
			}
		}
		return modelAndView;
	}

	@PostMapping("/produto/id/{id}")
	public ModelAndView atualizaProduto(@PathVariable("id") Long id, @Valid Produto Produto, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("consultarProduto");
		logger.info(">>>>>> servicoProduto para atualizacao de dados chamado para o id => " + id);
		if (result.hasErrors()) {
			logger.info(">>>>>> servicoProduto para atualizacao de dados com erro => " + result.getFieldError().toString());
			Produto.setId(id);
			return new ModelAndView("atualizarProduto");
		} else {
			servicoProduto.altera(produto);
			modelAndView.addObject("produto", servicoProduto.consultaTodos());
		}
		return modelAndView;
	}
}
