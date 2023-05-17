package br.com.pointel.docor;

import java.util.ArrayList;
import java.util.List;

public class Conditions {
    
    public static List<Condition> parse(String conditions) {
        var wordsArray = conditions.split("\\s+");
        var results = new ArrayList<Condition>();
        for (var word : wordsArray) {
            Integer weight = 1;
            while (word.startsWith("!")) {
                word = word.substring(1);
                weight++;
            }
            results.add(new Condition(weight, Utils.normalize(word)));
        }
        return results;
    }
    
}
