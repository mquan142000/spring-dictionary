package com.example.springdictionary;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {

    private static final Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("world", "thế giới");
        dictionary.put("goodbye", "tạm biệt");
        dictionary.put("thank you", "cảm ơn");
        dictionary.put("how are you", "bạn khỏe không?");
    }


    @GetMapping("/")
    public String showDictionary() {
        return "index";
    }

    @PostMapping("/translate")
    public String translate(@RequestParam("word")String word, Model model) {
        String result = dictionary.get(word.toLowerCase());
        if (result == null) {
            model.addAttribute("result", "Không tìm thấy từ này");
        }else {
            model.addAttribute("result", result);
        }
        return "result";
    }
}
