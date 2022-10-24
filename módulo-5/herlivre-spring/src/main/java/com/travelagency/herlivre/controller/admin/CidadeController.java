package com.travelagency.herlivre.controller.admin;

import com.travelagency.herlivre.enums.RoleName;
import com.travelagency.herlivre.model.Cargo;
import com.travelagency.herlivre.model.Cidade;
import com.travelagency.herlivre.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/admin/cidade")
public class CidadeController {

    private CidadeRepository cidadeRepository;

    public CidadeController(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    @GetMapping(path = "/select")
    public String select(Model model){
        try{
            List<Cidade> cidades = cidadeRepository.findAll();
            model.addAttribute("cidades",cidades);
            model.addAttribute("cidade",new Cidade());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/cidades/cadastro-cidade";
    }

    @GetMapping(path = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id){
        try{
            cidadeRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/cidade/select";
    }

    @GetMapping(path = "/edit/{id}")
    public String edit(Model model, @PathVariable(name = "id") Long id){
        Cidade cidade = cidadeRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Cidade não encontrada"));
        model.addAttribute("cidade",cidade);
        return "admin/cidades/editar-cidade";
    }

    @PostMapping(path = "/insert")
    public String insert(@ModelAttribute Cidade cidade){
        try{
            cidadeRepository.save(cidade);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/cidade/select";
    }

    @PostMapping(path = "/update")
    public String update(@ModelAttribute Cidade cidade){
        try {
            cidadeRepository.save(cidade);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/cidade/select";
    }
}
