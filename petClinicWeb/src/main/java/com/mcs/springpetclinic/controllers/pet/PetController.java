package com.mcs.springpetclinic.controllers.pet;

import com.mcs.springpetclinic.model.Owner;
import com.mcs.springpetclinic.model.Pet;
import com.mcs.springpetclinic.model.PetType;
import com.mcs.springpetclinic.services.OwnerService;
import com.mcs.springpetclinic.services.PetService;
import com.mcs.springpetclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/pets/new")
    public String initCreateForm(Owner owner,
                                 Model model,
                                 @PathVariable Long ownerId) {
        Pet pet = new Pet();
        owner.getPets().add(pet);
        pet.setOwner(owner);
        model.addAttribute("pet", pet);
        return PETS_CREATE_UPDATE_FORM;
    }

    @PostMapping("/pets/new")
    public String processCreateForm(Owner owner,
                                    @Valid Pet pet,
                                    BindingResult result,
                                    ModelMap model) {
        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null) {
            result.rejectValue("name", "duplicate", "already exists");
        }
        if (result.hasErrors()) {
            model.put("pet", pet);
            return PETS_CREATE_UPDATE_FORM;
        } else {
            pet.setOwner(owner);
            petService.save(pet);
            return "redirect:/owners/" + owner.getId();
        }
    }

    @GetMapping("/pets/{petId}/edit")
    public String initUpdateForm(@PathVariable Long petId,
                                 Model model) {
        model.addAttribute("pet", petService.findById(petId));
        return PETS_CREATE_UPDATE_FORM;
    }

    @PostMapping("/pets/{petId}/edit")
    public String processUpdateForm(@Valid Pet pet,
                                    BindingResult result,
                                    Owner owner,
                                    Model model,
                                    @PathVariable String petId) {
        if (result.hasErrors()) {
            model.addAttribute("pet", pet);
            return PETS_CREATE_UPDATE_FORM;
        } else {
            pet.setOwner(owner);
            petService.save(pet);
            return "redirect:/owners/" + owner.getId();
        }
    }
}
