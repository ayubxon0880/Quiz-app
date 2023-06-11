package uz.friendchallange.friendchallange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.friendchallange.friendchallange.dto.QuestionDto;
import uz.friendchallange.friendchallange.dto.QuestionListDto;
import uz.friendchallange.friendchallange.model.Question;
import uz.friendchallange.friendchallange.service.AccountService;
import uz.friendchallange.friendchallange.service.QuestionService;


@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/question")
    public String getQuestionPage(Model model){
        Question questionDto = new Question();
        model.addAttribute("quiz",questionDto);
        return "add";
    }

    @GetMapping("/question/{id}")
    public String getQuestion(@PathVariable String id){
        System.out.println(id);
        QuestionDto read = questionService.read(id);

        return null;
    }
}
