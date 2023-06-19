package uz.friendchallange.friendchallange.controller;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import uz.friendchallange.friendchallange.dto.Book;
import uz.friendchallange.friendchallange.dto.BooksCreationDto;
import uz.friendchallange.friendchallange.service.AccountService;

import java.util.List;

//@Controller
public class BookController {
    private List<Book> books;
    private AccountService bookService;

//    @PostMapping("/books/save")
//    public String saveBooks(@ModelAttribute BooksCreationDto form, Model model) {
//        form.getBooks().forEach(System.out::println);
//
//        model.addAttribute("books", bookService.findAll());
//        return "redirect:/books/all";
//    }

//    @GetMapping("/create")
//    public String showCreateForm(Model model) {
//        BooksCreationDto booksForm = new BooksCreationDto();
//
//        for (int i = 1; i <= 3; i++) {
//            booksForm.addBook(new Book(1L,"Title1","Author1"));
//        }
//
//        model.addAttribute("form", booksForm);
//        return "book/add-book";
//    }
//
//    @GetMapping("/all")
//    public String showAll(Model model) {
//        model.addAttribute("books", books);
//        return "book/books";
//    }
}
