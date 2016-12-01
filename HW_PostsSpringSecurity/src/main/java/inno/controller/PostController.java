package inno.controller;

import inno.model.Post;
import inno.model.User;
import inno.repository.PostRepository;
import inno.repository.UserRepository;
import inno.util.validators.PostValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    PostValidator validator;

//    @Autowired
//    CommentRepository commentRepository;

    @RequestMapping
    public String getAllPosts(@RequestParam(value = "phrase", required = false) String phrase, ModelMap map) {
        List<Post> posts = postRepository.findAll();
        if (phrase != null) {
            posts = posts.stream().filter(p -> p.getText().contains(phrase)).collect(Collectors.toList());
        }
        map.addAttribute("posts", posts);
        return "posts/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addNewPostPage(HttpSession session,ModelMap map) {
        map.addAttribute("post", new Post());
        return "posts/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewPost(HttpSession session,@ModelAttribute Post post, BindingResult result) {
        validator.validate(post, result);
        if (result.hasErrors()) {
            return "posts/add";
        }
        String user=SecurityContextHolder.getContext().getAuthentication().getName();
	    post.setAuthor(postRepository.userByLogin(user));
        postRepository.add(post);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showPost(@PathVariable("id") Long id, ModelMap map) {
        Post post = postRepository.find(id);

        map.addAttribute("post", post);
//        map.addAttribute("comments", commentRepository.findByPostId(id));
        return "/posts/show";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deletePost(HttpSession session, @PathVariable("id") Long id, ModelMap map) {
        postRepository.remove(id);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editPost(@PathVariable("id") Long id, ModelMap map) {
        Post post = postRepository.find(id);
        map.addAttribute("post", post);
        return "posts/edit";
    }

    @RequestMapping(value = "/{id}/save", method = RequestMethod.POST)
    public String savePost(@ModelAttribute Post post, BindingResult result) {
        validator.validate(post, result);
        if (result.hasErrors()) {
            return "posts/edit";
        }
        String user=SecurityContextHolder.getContext().getAuthentication().getName();
        post.setAuthor(postRepository.userByLogin(user));
        postRepository.update(post);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/userRegistration", method = RequestMethod.GET)
    public String formRegistration(ModelMap map) {
        map.addAttribute("user", new User());
        return "posts/userRegistration";
    }

    @RequestMapping(value = "/userRegistration/accessRegistration", method = RequestMethod.POST)
    public String userReg(@ModelAttribute User user, ModelMap map) {
        userRepository.userAdd(user);
	    return "redirect:/posts";
    }
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String Error(ModelMap map) {
        return "errors/error";
    }
}
