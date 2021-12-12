package jpabook.jpashop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping(value="/hello")
    public String get(Model model){
        model.addAttribute("data", "JPA 공부 중!");

        // String boot 설정에 의해 view name으로 매핑된다.
        return "hello"; 
    } 
}
