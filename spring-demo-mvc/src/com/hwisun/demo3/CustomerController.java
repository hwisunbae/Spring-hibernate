package com.hwisun.demo3;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.print.attribute.standard.ColorSupported;
import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @InitBinder //pre-process strings
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor =
                new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,
                stringTrimmerEditor);
    }

    @RequestMapping("/showForm")
    public String showForm(Model model){
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer")
                              Customer customer,
                              BindingResult bindingResult){
        System.out.println(bindingResult);
        System.out.println("\n");
        if(bindingResult.hasErrors()){
            return "customer-form";
        }else {
            return "customer-confirmation";
        }

    }
}
