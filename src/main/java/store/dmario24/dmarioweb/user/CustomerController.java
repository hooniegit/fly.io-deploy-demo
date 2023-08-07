package store.dmario24.dmarioweb.user;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/signup")
    public String signup(CustomerCreateForm customerCreateForm) {
        return "signup_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid CustomerCreateForm customerCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

        if (!customerCreateForm.getPassword1().equals(customerCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "signup_form";
        }

        customerService.create(customerCreateForm.getUsername(),
                customerCreateForm.getEmail(), customerCreateForm.getPassword1());

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login_form";
    }
}
