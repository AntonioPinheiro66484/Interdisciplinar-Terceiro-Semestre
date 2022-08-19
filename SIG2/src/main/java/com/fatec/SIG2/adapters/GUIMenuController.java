package com.fatec.SIG2.adapters;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GUIMenuController {
	@GetMapping("/login")
	public ModelAndView autenticacao() {
		return new ModelAndView("paginaLogin");
	}

	@GetMapping("/")
	public ModelAndView home() {
		return new ModelAndView("paginaMenu");
	}
	
	@GetMapping("/acessibilidade")
	public ModelAndView acess() {
		return new ModelAndView("acessibilidade");
	}
	@GetMapping("/paginaProduto")
	public ModelAndView produto() {
		return new ModelAndView("paginaProduto");
	}
	@GetMapping("/paginaProduto2")
	public ModelAndView produto2() {
		return new ModelAndView("paginaProduto2");
	}	
}

