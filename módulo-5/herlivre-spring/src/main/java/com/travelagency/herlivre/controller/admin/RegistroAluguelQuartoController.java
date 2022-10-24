package com.travelagency.herlivre.controller.admin;

import com.travelagency.herlivre.model.Quarto;
import com.travelagency.herlivre.model.RegistroAluguelQuarto;
import com.travelagency.herlivre.repository.QuartoRepository;
import com.travelagency.herlivre.repository.RegistroAluguelQuartoRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/admin/registroaluguelquarto")
public class RegistroAluguelQuartoController {
    private QuartoRepository quartoRepository;
    private RegistroAluguelQuartoRepository registroAluguelQuartoRepository;

    public RegistroAluguelQuartoController(QuartoRepository quartoRepository, RegistroAluguelQuartoRepository registroAluguelQuartoRepository) {
        this.quartoRepository = quartoRepository;
        this.registroAluguelQuartoRepository = registroAluguelQuartoRepository;
    }

    @GetMapping(path = "/select")
    public String select(Model model){
        try{
            List<RegistroAluguelQuarto> registroAluguelQuartos = registroAluguelQuartoRepository.findAll();
            model.addAttribute("registroaluguelquartos",registroAluguelQuartos);
            model.addAttribute("registroaluguelquarto",new RegistroAluguelQuarto());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/registroaluguelquartos/cadastro-registroaluguelquarto";
    }

    @GetMapping(path = "/delete/{id}")
    public String select(@PathVariable(name = "id") Long id){
        try{
            registroAluguelQuartoRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/registroaluguelquarto/select";
    }

    @GetMapping(path = "/edit/{id}")
    public String edit(Model model, @PathVariable(name = "id") Long id){
        RegistroAluguelQuarto registroAluguelQuarto = registroAluguelQuartoRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Registro do aluguel do quarto não encontrado"));
        model.addAttribute("registroaluguelquarto",registroAluguelQuarto);
        return "admin/registroaluguelquartos/editar-registroaluguelquarto";
    }

    @PostMapping(path = "/insert")
    public String insert(@ModelAttribute RegistroAluguelQuarto registroAluguelQuarto,
                         @RequestParam(name = "id_quarto") Long id_quarto){
        try{
            registroAluguelQuarto.setQuarto(quartoRepository.findById(id_quarto).get());
            registroAluguelQuartoRepository.save(registroAluguelQuarto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/registroaluguelquarto/select";
    }

    @PostMapping(path = "/update")
    public String update(@ModelAttribute RegistroAluguelQuarto registroAluguelQuarto,
                         @RequestParam(name = "id_quarto") Long id_quarto){
        try {
            registroAluguelQuarto.setQuarto(quartoRepository.findById(id_quarto).get());
            registroAluguelQuartoRepository.save(registroAluguelQuarto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/registroaluguelquarto/select";
    }
}
