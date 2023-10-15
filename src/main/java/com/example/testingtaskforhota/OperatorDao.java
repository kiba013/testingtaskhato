package com.example.testingtaskforhota;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class OperatorDao {

    private List<Operator> operatorList = new ArrayList<>();
    public void save(Operator operator) {
        Operator operator1 = new Operator();
        operator1.setText(operator.getText());

        List<String> result = new ArrayList<>();
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char c : operator.getText().toCharArray()) {
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
        operator1.setAnswer(result.toString());
        operatorList.add(operator1);
    }

    public List<Operator> getOperatorList() {
        return operatorList;
    }

    public String getResult(String text) {

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

        return result.toString();
    }


}
