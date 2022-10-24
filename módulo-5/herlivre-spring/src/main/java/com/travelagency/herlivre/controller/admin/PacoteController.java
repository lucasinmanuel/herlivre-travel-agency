package com.travelagency.herlivre.controller.admin;

import com.travelagency.herlivre.model.Cidade;
import com.travelagency.herlivre.model.Pacote;
import com.travelagency.herlivre.model.RegistroAluguelQuarto;
import com.travelagency.herlivre.repository.CidadeRepository;
import com.travelagency.herlivre.repository.PacoteRepository;
import com.travelagency.herlivre.repository.RegistroAluguelQuartoRepository;
import com.travelagency.herlivre.repository.VooRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/admin/pacote")
public class PacoteController {
    private VooRepository vooRepository;
    private RegistroAluguelQuartoRepository registroAluguelQuartoRepository;
    private PacoteRepository pacoteRepository;

    public PacoteController(VooRepository vooRepository, RegistroAluguelQuartoRepository registroAluguelQuartoRepository, PacoteRepository pacoteRepository) {
        this.vooRepository = vooRepository;
        this.registroAluguelQuartoRepository = registroAluguelQuartoRepository;
        this.pacoteRepository = pacoteRepository;
    }

    @GetMapping(path = "/select")
    public String select(Model model){
        try{
            List<Pacote> pacotes = pacoteRepository.findAll();
            model.addAttribute("pacotes",pacotes);
            model.addAttribute("pacote",new Pacote());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/pacotes/cadastro-pacote";
    }

    @GetMapping(path = "/delete/{id}")
    public String select(@PathVariable(name = "id") Long id){
        try{
            pacoteRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/pacote/select";
    }

    @GetMapping(path = "/edit/{id}")
    public String edit(Model model, @PathVariable(name = "id") Long id){
        Pacote pacote = pacoteRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Pacote não encontrada"));
        model.addAttribute("pacote",pacote);
        return "admin/pacotes/editar-pacote";
    }

    @PostMapping(path = "/insert")
    public String insert(@ModelAttribute Pacote pacote,
                         @RequestParam(name = "id_voo_1") Long id_voo_1,
                         @RequestParam(name = "id_voo_2",required = false) Long id_voo_2,
                         @RequestParam(name = "id_registro_aluguel_quarto") Long id_registro_aluguel_quarto){
        try{
            System.out.println(id_voo_2);
            pacote.setVoo_1(vooRepository.findById(id_voo_1).get());
            if(id_voo_2 != null){
                pacote.setVoo_2(vooRepository.findById(id_voo_2).get());
            }else{
                pacote.setVoo_2(null);
            }
            pacote.setRegistroAluguelQuarto(registroAluguelQuartoRepository.findById(id_registro_aluguel_quarto).get());
            pacoteRepository.save(pacote);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/pacote/select";
    }

    @PostMapping(path = "/update")
    public String update(@ModelAttribute Pacote pacote,
                         @RequestParam(name = "id_voo_1") Long id_voo_1,
                         @RequestParam(name = "id_voo_2",required = false) Long id_voo_2,
                         @RequestParam(name = "id_registro_aluguel_quarto") Long id_registro_aluguel_quarto){
        try {
            pacote.setVoo_1(vooRepository.findById(id_voo_1).get());
            pacote.setVoo_2(vooRepository.findById(id_voo_2).get());
            pacote.setRegistroAluguelQuarto(registroAluguelQuartoRepository.findById(id_registro_aluguel_quarto).get());
            pacoteRepository.save(pacote);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/pacote/select";
    }
}
