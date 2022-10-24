package com.travelagency.herlivre.controller.admin;

import com.travelagency.herlivre.model.Quarto;
import com.travelagency.herlivre.model.Voo;
import com.travelagency.herlivre.repository.CidadeRepository;
import com.travelagency.herlivre.repository.HotelRepository;
import com.travelagency.herlivre.repository.QuartoRepository;
import com.travelagency.herlivre.repository.VooRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/admin/voo")
public class VooController {
    private CidadeRepository cidadeRepository;
    private VooRepository vooRepository;

    public VooController(CidadeRepository cidadeRepository, VooRepository vooRepository) {
        this.cidadeRepository = cidadeRepository;
        this.vooRepository = vooRepository;
    }

    @GetMapping(path = "/select")
    public String select(Model model){
        try{
            List<Voo> voos = vooRepository.findAll();
            model.addAttribute("voos",voos);
            model.addAttribute("voo",new Voo());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/voos/cadastro-voo";
    }

    @GetMapping(path = "/delete/{id}")
    public String select(@PathVariable(name = "id") Long id){
        try{
            vooRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/voo/select";
    }

    @GetMapping(path = "/edit/{id}")
    public String edit(Model model, @PathVariable(name = "id") Long id){
        Voo voo = vooRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Voo não encontrado"));
        model.addAttribute("voo",voo);
        return "admin/voos/editar-voo";
    }

    @PostMapping(path = "/insert")
    public String insert(@ModelAttribute Voo voo,
                         @RequestParam(name = "id_cidade") Long id_cidade){
        try{
            voo.setCidade(cidadeRepository.findById(id_cidade).get());
            vooRepository.save(voo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/voo/select";
    }

    @PostMapping(path = "/update")
    public String update(@ModelAttribute Voo voo,
                         @RequestParam(name = "id_cidade") Long id_cidade){
        try {
            voo.setCidade(cidadeRepository.findById(id_cidade).get());
            vooRepository.save(voo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/voo/select";
    }
}
