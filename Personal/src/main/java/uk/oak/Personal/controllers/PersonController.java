package uk.oak.Personal.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uk.oak.Personal.entities.Person;
import uk.oak.Personal.services.PersonService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/addnewperson")
    public String addnewperson(Model model)
    {
        Person person=new Person();
        model.addAttribute("person",person);
        return "addperson";
    }
@PostMapping("/save")
    public String save(@ModelAttribute Person person)
{
    personService.save(person);
    return "redirect:/";
}

@GetMapping("/")
    public String personlist(Model model)
{

    return paginatedperson(1,"name","asc",model);
}



@GetMapping("/updateperson/{id}")
public String updateperson(@PathVariable("id") long id,Model model)
{
    Person person=personService.getById(id);
    model.addAttribute("person",person);
    return "update_person";
}

@GetMapping("/deleteperson/{id}")
public String deleteperson(@PathVariable("id")long id,Model model)
{
    Person person=personService.deleteById(id);
    return "redirect:/";
}

@GetMapping("/page/{pageno}")
    public String paginatedperson(@PathVariable("pageno") int pageno, @RequestParam("sortfield") String sortfield,
                                  @RequestParam("sortdirection") String sortdirection,Model model)
{
    int pagesize=15;
    Page<Person> pages=personService.findpagination(pagesize,pageno,sortfield,sortdirection);
    List<Person> persons=pages.getContent();
    model.addAttribute("currentpage",pageno);
    model.addAttribute("totalpages",pages.getTotalPages());
    model.addAttribute("totalelements",pages.getTotalElements());
    model.addAttribute("sortfield",sortfield);
    model.addAttribute("sortdirection",sortdirection);
    model.addAttribute("reversesortdirection",sortdirection.equals("asc")?"desc":"asc");
    model.addAttribute("persons",persons);
    return "index";












}













}
