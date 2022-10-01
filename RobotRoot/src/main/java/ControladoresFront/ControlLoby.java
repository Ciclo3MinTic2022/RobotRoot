package ControladoresFront;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControlLoby {
    @GetMapping("/Loby")
    public String index(){
        return "Loby";
    }
}
