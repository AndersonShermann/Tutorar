package com.tutorar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tutorar.model.Usuario;
import com.tutorar.repository.UsuarioRepository;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
	@GetMapping("/listar-usuario")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("usuario/listar.html");
 
		List<Usuario> usuarios = usuarioRepository.findAll();
		modelAndView.addObject("usuario", usuarios);
 
		return modelAndView;
	}
	
	

//    @GetMapping()
//    public ModelAndView home() {
//        ModelAndView modelAndView = new ModelAndView("usuario/perfil");
//
//        modelAndView.addObject("usuarios", usuarioRepository.findAll());
//
//        return modelAndView;
//    }

    @GetMapping("/cadastrar-usuario")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("usuario/cadastro");

        modelAndView.addObject("usuario", new Usuario());

        return modelAndView;
    }

    @GetMapping("/{id}/editar-usuario")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("usuario/editar");

        modelAndView.addObject("usuario", usuarioRepository.getReferenceById(id));

        return modelAndView;
    }

    @PostMapping({"/cadastrar-usuario", "/{id}/editar-usuario"})
    public String salvar(Usuario usuario) {

        usuarioRepository.save(usuario);
        return "redirect:/listar-usuario";
    }

    @GetMapping("/{id}/excluir-usuario")
    public String excluir(@PathVariable Long id) {
        usuarioRepository.deleteById(id);

        return "redirect:/listar";
    }
    
	@GetMapping("/{id}/perfil-usuario")
	public ModelAndView perfil(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("usuario/perfil");
 
		Usuario usuario = usuarioRepository.getReferenceById(id);
		modelAndView.addObject("usuario", usuario);
 
		return modelAndView;
	}
}
