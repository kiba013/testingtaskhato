package com.example.testingtaskforhota;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class RController {


    private final OperatorDao operatorDao;

    public RController(OperatorDao operatorDao) {
        this.operatorDao = operatorDao;
    }


    @GetMapping()
    public String showMainPage(@ModelAttribute("question") Operator operator,
                               Model model) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Operator operator1 : operatorDao.getOperatorList()) {
            stringBuilder.append(operator1.getText());
            stringBuilder.append(operator1.getAnswer());
            stringBuilder.append("\n \r");
        }
        model.addAttribute("text", stringBuilder);
        return "api/main";
    }

    @PostMapping()
    public String resolveTest(@ModelAttribute("question") Operator operator) {
        operatorDao.save(operator);
        operatorDao.getResult(operator.getText());
        return "redirect:/api";
    }

}
