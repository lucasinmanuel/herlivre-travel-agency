package com.travelagency.herlivre.controller.admin;

import com.travelagency.herlivre.model.Cidade;
import com.travelagency.herlivre.model.Comprovante;
import com.travelagency.herlivre.model.RegistroAluguelQuarto;
import com.travelagency.herlivre.repository.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(path = "/admin/comprovante")
public class ComprovanteController {

    private final RegistroAluguelQuartoRepository registroAluguelQuartoRepository;
    private final UsuarioRepository usuarioRepository;
    private final PacoteRepository pacoteRepository;
    private final ComprovanteRepository comprovanteRepository;

    public ComprovanteController(RegistroAluguelQuartoRepository registroAluguelQuartoRepository, UsuarioRepository usuarioRepository, PacoteRepository pacoteRepository, ComprovanteRepository comprovanteRepository) {
        this.registroAluguelQuartoRepository = registroAluguelQuartoRepository;
        this.usuarioRepository = usuarioRepository;
        this.pacoteRepository = pacoteRepository;
        this.comprovanteRepository = comprovanteRepository;
    }

    @GetMapping(path = "/select")
    public String select(Model model){
        try {
            List<Comprovante> comprovantes = comprovanteRepository.findAll();
            model.addAttribute("comprovantes",comprovantes);
            model.addAttribute("comprovante",new Comprovante());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/comprovantes/cadastro-comprovante";
    }

    @GetMapping(path = "/delete/{id}")
    public String select(@PathVariable(name = "id") Long id){
        try {
            comprovanteRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/comprovante/select";
    }

    @GetMapping(path = "/edit/{id}")
    public String edit(Model model, @PathVariable(name = "id") Long id){
        Comprovante comprovante = comprovanteRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Comprovante não encontrado"));
        model.addAttribute("comprovante",comprovante);
        return "admin/comprovantes/editar-comprovante";
    }

    @PostMapping(path = "/insert")
    public String insert(@ModelAttribute Comprovante comprovante,
                         @RequestParam(name = "id_registro_aluguel_quarto") Long id_registro_aluguel_quarto,
                         @RequestParam(name = "id_usuario") Long id_usuario,
                         @RequestParam(name = "id_pacote",required = false) Long id_pacote){
        try{
            comprovante.setRegistroAluguelQuarto(registroAluguelQuartoRepository.findById(id_registro_aluguel_quarto).get());
            comprovante.setUsuario(usuarioRepository.findById(id_usuario).get());
            comprovante.setPacote(pacoteRepository.findById(id_pacote).get());
            comprovante.setData_compra(LocalDate.now());
            comprovanteRepository.save(comprovante);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/comprovante/select";
    }

    @PostMapping(path = "/update")
    public String update(@ModelAttribute Comprovante comprovante,
                         @RequestParam(name = "id_registro_aluguel_quarto") Long id_registro_aluguel_quarto,
                         @RequestParam(name = "id_usuario") Long id_usuario,
                         @RequestParam(name = "id_pacote",required = false) Long id_pacote){
        try{
            comprovante.setRegistroAluguelQuarto(registroAluguelQuartoRepository.findById(id_registro_aluguel_quarto).get());
            comprovante.setUsuario(usuarioRepository.findById(id_usuario).get());
            comprovante.setPacote(pacoteRepository.findById(id_pacote).get());
            comprovanteRepository.save(comprovante);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/comprovante/select";
    }
}
