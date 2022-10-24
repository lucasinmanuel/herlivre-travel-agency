package com.travelagency.herlivre.controller.admin;

import com.travelagency.herlivre.model.Hotel;
import com.travelagency.herlivre.model.Pacote;
import com.travelagency.herlivre.repository.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/admin/hotel")
public class HotelController {
    private CidadeRepository cidadeRepository;
    private HotelRepository hotelRepository;

    public HotelController(CidadeRepository cidadeRepository, HotelRepository hotelRepository) {
        this.cidadeRepository = cidadeRepository;
        this.hotelRepository = hotelRepository;
    }

    @GetMapping(path = "/select")
    public String select(Model model){
        try{
            List<Hotel> hoteis = hotelRepository.findAll();
            model.addAttribute("hoteis",hoteis);
            model.addAttribute("hotel",new Hotel());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/hoteis/cadastro-hotel";
    }

    @GetMapping(path = "/delete/{id}")
    public String select(@PathVariable(name = "id") Long id){
        try{
            hotelRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/hotel/select";
    }

    @GetMapping(path = "/edit/{id}")
    public String edit(Model model, @PathVariable(name = "id") Long id){
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Hotel não encontrada"));
        model.addAttribute("hotel",hotel);
        return "admin/hoteis/editar-hotel";
    }

    @PostMapping(path = "/insert")
    public String insert(@ModelAttribute Hotel hotel,
                         @RequestParam(name = "id_cidade") Long id_cidade,
                         @RequestParam(name = "wifi") Boolean wifi,
                         @RequestParam(name = "cafe_manha") Boolean cafe_manha){
        try{
            hotel.setWifi(wifi);
            hotel.setCafe_manha(cafe_manha);
            hotel.setCidade(cidadeRepository.findById(id_cidade).get());
            hotelRepository.save(hotel);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/hotel/select";
    }

    @PostMapping(path = "/update")
    public String update(@ModelAttribute Hotel hotel,
                         @RequestParam(name = "id_cidade") Long id_cidade,
                         @RequestParam(name = "wifi") Boolean wifi,
                         @RequestParam(name = "cafe_manha") Boolean cafe_manha){
        try {
            hotel.setWifi(wifi);
            hotel.setCafe_manha(cafe_manha);
            hotel.setCidade(cidadeRepository.findById(id_cidade).get());
            hotelRepository.save(hotel);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/hotel/select";
    }
}
