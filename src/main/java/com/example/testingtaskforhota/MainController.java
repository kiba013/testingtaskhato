package com.example.testingtaskforhota;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class MainController {



    @GetMapping("/test")
    public String showTestForm(@ModelAttribute("question")  String text,
                               Model model) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
            }
        }
        charFrequencyMap = charFrequencyMap.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        HashMap::new
                ));
        for (Map.Entry<Character, Integer> entry : charFrequencyMap.entrySet()) {
            result.add(entry.getKey() + ": " + entry.getValue());
        }
        model.addAttribute("answer", result);
        return "index";
    }


}
