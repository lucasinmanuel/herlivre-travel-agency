package com.travelagency.herlivre.controller.admin;

import com.travelagency.herlivre.enums.RoleName;
import com.travelagency.herlivre.model.Cargo;
import com.travelagency.herlivre.model.Cidade;
import com.travelagency.herlivre.model.Usuario;
import com.travelagency.herlivre.repository.CidadeRepository;
import com.travelagency.herlivre.repository.UsuarioRepository;
import com.travelagency.herlivre.utils.PasswordEncoderUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/admin/usuario")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping(path = "/select")
    public String select(Model model){
        try{
            List<Usuario> usuarios = usuarioRepository.findAll();
            model.addAttribute("usuarios",usuarios);
            model.addAttribute("usuario",new Usuario());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/usuarios/cadastro-usuario";
    }

    @GetMapping(path = "/delete/{id}")
    public String select(@PathVariable(name = "id") Long id){
        try{
            usuarioRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/usuario/select";
    }

    @GetMapping(path = "/edit/{id}")
    public String edit(Model model, @PathVariable(name = "id") Long id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        model.addAttribute("usuario",usuario);
        return "admin/usuarios/editar-usuario";
    }

    @PostMapping(path = "/insert")
    public String insert(@ModelAttribute Usuario usuario,@RequestParam(name = "id_cargo") Long id_cargo){
        try{
            String passwordEncoder = PasswordEncoderUtils.encode(usuario.getPassword());
            usuario.setPassword(passwordEncoder);

            Cargo cargo = new Cargo();
            cargo.setId(id_cargo);
            if(id_cargo == 1){
                cargo.setNome(RoleName.ROLE_ADMIN);
            }else if(id_cargo == 2){
                cargo.setNome(RoleName.ROLE_USER);
            }
            usuario.setCargo(cargo);
            usuarioRepository.save(usuario);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/usuario/select";
    }

    @PostMapping(path = "/update")
    public String update(@ModelAttribute Usuario usuario,@RequestParam(name = "id_cargo") Long id_cargo){
        try {
            String passwordEncoder = PasswordEncoderUtils.encode(usuario.getPassword());
            usuario.setPassword(passwordEncoder);

            Cargo cargo = new Cargo();
            cargo.setId(id_cargo);
            if(id_cargo == 1){
                cargo.setNome(RoleName.ROLE_ADMIN);
            }else if(id_cargo == 2){
                cargo.setNome(RoleName.ROLE_USER);
            }
            usuario.setCargo(cargo);
            usuarioRepository.save(usuario);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/usuario/select";
    }
}
