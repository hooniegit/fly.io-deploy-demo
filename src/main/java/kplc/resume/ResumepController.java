package kplc.resume;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ResumepController {

    private final ResumepRepository resumepRepository;

    @GetMapping ("/resume/{name}")
    public Resumep park(@PathVariable("name") String name){
        return resumepRepository.findByName(name);
    }
}
