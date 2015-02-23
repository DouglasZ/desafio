package br.com.desafio.application.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.desafio.domain.entity.Usuario;
import br.com.desafio.domain.service.UsuarioService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	  
	  @Qualifier(value="usuarioService")
	  public void setUsuarioService(UsuarioService us) {
	    this.usuarioService = us;
	  }
	  
	  @RequestMapping("/usuarios")
	  public String listarUsuarios(Model model) {
	    model.addAttribute("usuario", new Usuario());
	    model.addAttribute("listaDeUsuarios", this.usuarioService.listarUsuarios());
	    return "usuario";
	  }
	  
	  @RequestMapping(value="/usuario/salvarOuAtualizar", method = RequestMethod.POST)
	  public String salvarOuAtualizar(@ModelAttribute("usuario") Usuario u) {
	    if (u.getId() == null) {
	      this.usuarioService.salvarUsuario(u);
	    } else {
	      this.usuarioService.atualizarUsuario(u);
	    }
	    return "redirect:/usuarios";
	  }
	  
	  @RequestMapping("/remover/{id}")
	  public String removerUsuario(@PathVariable("id") Integer id) {
	    this.usuarioService.removerUsuario(id);
	    return "redirect:/usuarios";
	  }
	  
	  @RequestMapping("/editar/{id}")
	  public String editarUsuario(@PathVariable("id") Integer id, Model model) {
	    model.addAttribute("usuario", this.usuarioService.getUsuarioPorId(id));
	    model.addAttribute("listaDeUsuarios", this.usuarioService.listarUsuarios());
	    return "usuario";
	  }
	
}
