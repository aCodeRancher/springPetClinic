package com.mcs.springpetclinic.controllers.visit;

import com.mcs.springpetclinic.model.Visit;
import com.mcs.springpetclinic.services.OwnerService;
import com.mcs.springpetclinic.services.PetService;
import com.mcs.springpetclinic.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/owners/{ownerId}/pets/{petId}/visits")
public class VisitController {

    private final VisitService visitService;
    private final PetService petService;
    private final OwnerService ownerService;

    public VisitController(VisitService visitService,
                           PetService petService,
                           OwnerService ownerService) {
        this.visitService = visitService;
        this.petService = petService;
        this.ownerService = ownerService;
    }

    /*

    @InitBinder
    public void dataBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");

        dataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException{
                setValue(LocalDate.parse(text));
            }
        });
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable("petId") Long petId,
                                  Map<String, Object> model) {
        Pet pet = petService.findById(petId);
        model.put("pet", pet);
        Visit visit = new Visit();
        pet.getVisits().add(visit);
        visit.setPet(pet);
        return visit;
    }

    // Spring MVC calls method loadPetWithVisit(...) before initNewVisitForm is called
    @GetMapping("/owners//pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable("petId") Long petId,
                                   Map<String, Object> model) {
        return "pets/createOrUpdateVisitForm";
    }

    // Spring MVC calls method loadPetWithVisit(...) before processNewVisitForm is called
    @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String processNewVisitForm(@Valid Visit visit,
                                      BindingResult result) {
        if (result.hasErrors()) {
            return "pets/createOrUpdateVisitForm";
        } else {
            visitService.save(visit);
            return "redirect:/owners/{ownerId}";
        }
    }
    */

    @GetMapping("/new")
    public String initNewVisitForm(@PathVariable("petId") Long petId, Model model) {
        model.addAttribute("visit", new Visit());
        model.addAttribute("pet", petService.findById(petId));
        return "pets/createOrUpdateVisitForm";
    }

    @PostMapping("/new")
    public String processNewVisitForm(@Valid Visit visit,
                                      @PathVariable("petId") Long petId,
                                      BindingResult result) {
        if (result.hasErrors()) {
            return "pets/createOrUpdateVisitForm";
        } else {
            visit.setPet(petService.findById(petId));
            visitService.save(visit);

            return "redirect:/owners/{ownerId}";
        }
    }

}
