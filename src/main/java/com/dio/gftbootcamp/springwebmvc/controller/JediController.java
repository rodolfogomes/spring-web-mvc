package com.dio.gftbootcamp.springwebmvc.controller;


import com.dio.gftbootcamp.springwebmvc.model.Jedi;
import com.dio.gftbootcamp.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

@Controller
public class JediController {

    @Autowired
    JediRepository jediRepository;

    @GetMapping("/jedi")
    public ModelAndView jedi(){
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");
        modelAndView.addObject("allJedi",jediRepository.getAllJedi());
        return modelAndView;
    }

    @GetMapping("/new-jedi")
    public ModelAndView newJedi(){
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-jedi");
        modelAndView.addObject("jedi",new Jedi());
        return modelAndView;
    }

    //TODO ajust validation
    @PostMapping("/jedi")
    public String createtJedi(@Valid @ModelAttribute Jedi jedi, BindingResult result, RedirectAttributes redirect){
        if(result.hasErrors()){
            return "new-jedi";
        }
        jediRepository.save(jedi);
        redirect.addFlashAttribute("message", "Jedi successfully created.");
        return "redirect:/jedi";
    }
}
