package uz.friendchallange.friendchallange.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import uz.friendchallange.friendchallange.dto.AccountDto;
import uz.friendchallange.friendchallange.dto.QuestionDto;
import uz.friendchallange.friendchallange.dto.SubjectUuidDto;
import uz.friendchallange.friendchallange.model.Account;
import uz.friendchallange.friendchallange.service.AccountService;
import uz.friendchallange.friendchallange.service.QuestionService;

import java.util.HashMap;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final QuestionService questionService;

    @PostMapping("/register")
    public String createUser(@ModelAttribute AccountDto accountDto) {
        AccountDto save = accountService.create(accountDto);
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String getForm(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            model.addAttribute("message","Siz Ro'yhatdan o'tgansiz");
            return "wrong";
        }
        Account account = new Account();
        model.addAttribute("account",account);
        return "registration";
    }



    @GetMapping("/profile")
    public String profile(Model model){
        Account account = new Account();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails userDetails) {
            account = accountService.findByEmail(userDetails.getUsername());
            model.addAttribute("account", account);
            List<SubjectUuidDto> subjects = questionService.findSubjects(account.getId());

            if (subjects.size() != 0) {
                model.addAttribute("subjectAndUuid",subjects);
            } else {
                model.addAttribute("quizNotFound", "Hozircha sizda Testlar yo'q");
            }
        }
        return "profile";
    }




}
