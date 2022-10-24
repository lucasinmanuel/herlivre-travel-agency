package com.travelagency.herlivre.controller;

import com.travelagency.herlivre.enums.RoleName;
import com.travelagency.herlivre.model.Cargo;
import com.travelagency.herlivre.model.Usuario;
import com.travelagency.herlivre.repository.UsuarioRepository;
import com.travelagency.herlivre.utils.PasswordEncoderUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(path = "/pages")
public class PagesController {

    private final UsuarioRepository usuarioRepository;

    public PagesController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping(path = "/signup")
    public String signup(@ModelAttribute Usuario usuario){
        try {
            String passwordEncoder = PasswordEncoderUtils.encode(usuario.getPassword());
            usuario.setPassword(passwordEncoder);

            Cargo cargo = new Cargo();
            cargo.setId(2L);
            cargo.setNome(RoleName.ROLE_USER);
            usuario.setCargo(cargo);

            usuarioRepository.save(usuario);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/pages/login";
    }

    @GetMapping(path = {"","/","/home"})
    public String home(){
        return "home";
    }

    @GetMapping(path = "/national-destinations")
    public String destinosNacionais(){
        return "national-destinations";
    }

    @GetMapping(path = "/international-destinations")
    public String destinosInternacionais(){
        return "international-destinations";
    }

    @GetMapping(path = "/promotions")
    public String promotions(){
        return "promotions";
    }

    @GetMapping(path = "/login")
    public String login(Model model){
        model.addAttribute("usuario",new Usuario());
        return "login";
    }

    @GetMapping(path = "/profile")
    public String profile(HttpSession session, Authentication authentication){
        try {
            Usuario usuario = usuarioRepository.findByEmail(authentication.getName())
                    .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
            session.setAttribute("usuario", usuario);
            return "profile";
        }catch (Exception e){
            e.printStackTrace();
            return "redirect:/pages/home";
        }
    }

    @GetMapping(path = "/signup")
    public String signup(Model model){
        model.addAttribute("usuario",new Usuario());
        return "signup";
    }

    @GetMapping(path = "/about")
    public String about(){
        return "about";
    }

    @GetMapping(path = "/contact")
    public String contact(){
        return "contact";
    }

}
