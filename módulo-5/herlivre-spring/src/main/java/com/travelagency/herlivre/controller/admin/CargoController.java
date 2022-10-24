package com.travelagency.herlivre.controller.admin;

import com.travelagency.herlivre.enums.RoleName;
import com.travelagency.herlivre.model.Cargo;
import com.travelagency.herlivre.model.Voo;
import com.travelagency.herlivre.repository.CargoRepository;
import com.travelagency.herlivre.repository.CidadeRepository;
import com.travelagency.herlivre.repository.VooRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/admin/cargo")
public class CargoController {
    private CargoRepository cargoRepository;

    public CargoController(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @GetMapping(path = "/select")
    public String select(Model model){
        try{
            List<Cargo> cargos = cargoRepository.findAll();
            model.addAttribute("cargos",cargos);
            model.addAttribute("cargo",new Cargo());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/cargos/cadastro-cargo";
    }
}
