package com.example.pictureofday.Controller;

import com.example.pictureofday.Model.Picture;
import com.example.pictureofday.Service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    private IPictureService pictureService;
    @GetMapping("")
    public String hone(Model model){
        model.addAttribute("Picture",new Picture());
        return "/home";
    }
    private static final List<String> badWord = Arrays.asList("suck","fuck","nigger");
    public boolean checkFeedBack(String text){
        for (String badWord : badWord){
            if (text.toLowerCase().contains(badWord.toLowerCase())){
                return false;
            }
        }
        return true;
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("Picture") Picture picture) throws Exception{
        if (checkFeedBack(picture.getFeedBack())){
            pictureService.save(picture);
        }else {
            throw new Exception();
        }
        return "redirect:/pictures";
    }
}
