package com.mcs.springpetclinic.controllers.pet;

import com.mcs.springpetclinic.model.Owner;
import com.mcs.springpetclinic.model.PetType;
import com.mcs.springpetclinic.services.OwnerService;
import com.mcs.springpetclinic.services.PetService;
import com.mcs.springpetclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private final String PETS_CREATE_UPDATE_FORM = "pets/createOrUpdatePetForm";

    private final PetTypeService petTypeService;
    private final OwnerService ownerService;
    private final PetService petService;

    public PetController(
            PetTypeService petTypeService,
            OwnerService ownerService,
            PetService petService) {
        this.petTypeService = petTypeService;
        this.ownerService = ownerService;
        this.petService = petService;
    }

    @ModelAttribute("types")
    public List<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
}
