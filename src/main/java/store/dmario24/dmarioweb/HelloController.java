package store.dmario24.dmarioweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello PD24 ~~~";
    }

    @GetMapping("/hi")
    @ResponseBody
    public String hi() {
        return "hi PD24 ~~~ ^^";
    }
}
