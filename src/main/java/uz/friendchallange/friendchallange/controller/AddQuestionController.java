package uz.friendchallange.friendchallange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import uz.friendchallange.friendchallange.dto.QuestionListDto;
import uz.friendchallange.friendchallange.service.AccountService;
import uz.friendchallange.friendchallange.service.QuestionService;

import java.util.List;

@RestController
@CrossOrigin
public class AddQuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private AccountService accountService;


    @PostMapping("/createQuiz")
    public String create(@RequestBody QuestionListDto questionListDto){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String s = "";
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        System.out.println(questionListDto.getQuestions());
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        if (principal instanceof UserDetails userDetails){
            System.out.println("asdasdasdasdasdads");
            s = questionService.create(questionListDto, userDetails.getUsername());
        }

        return s;
    }
}
