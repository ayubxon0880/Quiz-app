package uz.friendchallange.friendchallange.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.friendchallange.friendchallange.dto.QuestionDto;
import uz.friendchallange.friendchallange.dto.QuestionsCreationDto;
import uz.friendchallange.friendchallange.model.Question;
import uz.friendchallange.friendchallange.service.QuestionService;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping("/question/save")
    public String saveBooks(@Valid @ModelAttribute QuestionsCreationDto form, Model model) {
        System.out.println(form.getSubject());
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails userDetails) {
            String username = userDetails.getUsername();
            List<QuestionDto> questions = questionService.create(form, username);
            model.addAttribute("questions", questions);
            return "redirect:/question/"+questions.get(0).getUuid();
        }
        model.addAttribute("message","User not found");
        return "wrong";
    }

    @GetMapping("/create")
    public String create(Model model, @ModelAttribute Question question){
        QuestionsCreationDto booksForm = new QuestionsCreationDto();

        for (int i = 0; i < 10; i++) {
            booksForm.addQuestion(new Question());
        }

        model.addAttribute("form", booksForm);
        return "Create-question";
    }

    @GetMapping("/question/{uuid}")
    public String getQuestionByUuid(Model model,@PathVariable String uuid) {
        List<QuestionDto> byUuid = questionService.getByUuid(uuid);
        model.addAttribute("questions",byUuid);

        return "question";
    }

}
