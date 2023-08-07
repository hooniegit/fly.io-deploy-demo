package store.dmario24.dmarioweb;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import store.dmario24.dmarioweb.question.Question;
import store.dmario24.dmarioweb.question.QuestionService;
import store.dmario24.dmarioweb.tom.Resume;

@RestController
@RequestMapping("/mario")
@RequiredArgsConstructor
public class MarioRestController {
    private final QuestionService questionService;

    @GetMapping("/question/{id}")
    public Object createAnswer(@PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        return question;
    }

    @GetMapping("/resume")
    public Object resume() {
        Resume tomResume = new Resume();
        tomResume.setId(1);
        tomResume.setName("Tom Sawyer");
        tomResume.setEmail("tomsawyer@adventure.io");
        return tomResume;
    }

}

