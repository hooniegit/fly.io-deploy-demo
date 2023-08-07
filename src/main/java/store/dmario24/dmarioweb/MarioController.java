package store.dmario24.dmarioweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MarioController {

    @GetMapping("/mario")
    @ResponseBody
    public String mario() {
        System.out.println("MARIO");
        return "MARIO";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }
}
