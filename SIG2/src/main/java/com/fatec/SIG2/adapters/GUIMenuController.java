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
	@GetMapping("/paginaProduto1")
	public ModelAndView produto1() {
		return new ModelAndView("paginaProduto1");
	}	
	@GetMapping("/paginaProduto3")
	public ModelAndView produto3() {
		return new ModelAndView("paginaProduto3");
	}	
	@GetMapping("/paginaProduto4")
	public ModelAndView produto4() {
		return new ModelAndView("paginaProduto4");
	}	
	@GetMapping("/paginaProduto5")
	public ModelAndView produto5() {
		return new ModelAndView("paginaProduto5");
	}	
	@GetMapping("/paginaProduto6")
	public ModelAndView produto6() {
		return new ModelAndView("paginaProduto6");
	}	
	@GetMapping("/paginaProduto7")
	public ModelAndView produto7() {
		return new ModelAndView("paginaProduto7");
	}	
}

