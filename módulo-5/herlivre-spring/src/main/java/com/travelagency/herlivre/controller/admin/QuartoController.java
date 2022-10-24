package com.travelagency.herlivre.controller.admin;

import com.travelagency.herlivre.model.Hotel;
import com.travelagency.herlivre.model.Quarto;
import com.travelagency.herlivre.repository.CidadeRepository;
import com.travelagency.herlivre.repository.HotelRepository;
import com.travelagency.herlivre.repository.QuartoRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/admin/quarto")
public class QuartoController {
    private QuartoRepository quartoRepository;
    private HotelRepository hotelRepository;

    public QuartoController(QuartoRepository quartoRepository, HotelRepository hotelRepository) {
        this.quartoRepository = quartoRepository;
        this.hotelRepository = hotelRepository;
    }

    @GetMapping(path = "/select")
    public String select(Model model){
        try{
            List<Quarto> quartos = quartoRepository.findAll();
            model.addAttribute("quartos",quartos);
            model.addAttribute("quarto",new Quarto());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/quartos/cadastro-quarto";
    }

    @GetMapping(path = "/delete/{id}")
    public String select(@PathVariable(name = "id") Long id){
        try{
            quartoRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/quarto/select";
    }

    @GetMapping(path = "/edit/{id}")
    public String edit(Model model, @PathVariable(name = "id") Long id){
        Quarto quarto = quartoRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Quarto não encontrado"));
        model.addAttribute("quarto",quarto);
        return "admin/quartos/editar-quarto";
    }

    @PostMapping(path = "/insert")
    public String insert(@ModelAttribute Quarto quarto,
                         @RequestParam(name = "id_hotel") Long id_hotel,
                         @RequestParam(name = "tipo") String tipo){
        try{
            quarto.setHotel(hotelRepository.findById(id_hotel).get());
            quarto.setTipo(tipo);
            quartoRepository.save(quarto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/quarto/select";
    }

    @PostMapping(path = "/update")
    public String update(@ModelAttribute Quarto quarto,
                         @RequestParam(name = "id_hotel") Long id_hotel,
                         @RequestParam(name = "tipo") String tipo){
        try {
            quarto.setHotel(hotelRepository.findById(id_hotel).get());
            quarto.setTipo(tipo);
            quartoRepository.save(quarto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/quarto/select";
    }
}
