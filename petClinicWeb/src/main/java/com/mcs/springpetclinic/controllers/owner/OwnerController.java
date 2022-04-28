package com.mcs.springpetclinic.controllers.owner;

import com.mcs.springpetclinic.model.Owner;
import com.mcs.springpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;
    private final String CREATE_OR_UPDATE_TEMPLATE = "createOrUpdateOwnerForm";

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/{ownerId}")
    public String showOwner(@PathVariable("ownerId") Long ownerId, Model model) {
        model.addAttribute("owner", ownerService.findById(ownerId));
        return "owners/ownerDetails";
    }

    @GetMapping("/find")
    public String findOwners(Model model){
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model){
        // allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null) {
            owner.setLastName(""); // empty string signifies broad possible search
        }

        // find owners by last name
        List<Owner> results = ownerService.findAllByLastNameContainingIgnoreCase(owner.getLastName());

        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (results.size() == 1) {
            // 1 owner found
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            // multiple owners found
            model.addAttribute("owners", results);
            return "owners/ownersList";
        }
    }

    @GetMapping("/new")
    public String newOwner(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "owners/" + CREATE_OR_UPDATE_TEMPLATE;
    }

    @PostMapping("/new")
    public String processCreateForm(@Valid Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return "owners/" + CREATE_OR_UPDATE_TEMPLATE;
        } else {
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable("ownerId") Long ownerId, Model model) {
        model.addAttribute("owner", ownerService.findById(ownerId));
        return "owners/" + CREATE_OR_UPDATE_TEMPLATE;
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(@Valid Owner owner,
                                         BindingResult result,
                                         @PathVariable("ownerId") Long ownerId) {
        if (result.hasErrors()) {
            return "owners/" + CREATE_OR_UPDATE_TEMPLATE;
        }
        else {
            owner.setId(ownerId);
            ownerService.save(owner);
            return "redirect:/owners/" + ownerId;
        }
    }
}
