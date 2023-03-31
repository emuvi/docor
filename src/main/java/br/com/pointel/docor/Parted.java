package br.com.pointel.docor;

import java.util.List;

public class Parted {

    private final Paged paged;
    private final Kind kind;
    private final String text;
    private final String[] words;

    public Parted(Paged paged, Kind kind, String text) {
        this.paged = paged;
        this.kind = kind;
        this.text = text;
        this.words = indexWords();
    }
    
    private String[] indexWords() {
        String[] parts = text.split("\\s+");
        for (int i = 0; i < 10; i++) {
            parts[i] = Utils.normalize(parts[i]);
        }
        return parts;
    }

    public Paged getPaged() {
        return paged;
    }

    public Kind getKind() {
        return kind;
    }

    public String getText() {
        return text;
    }
    
    public Integer search(List<Condition> conditions) {
        var result = 0;
        for (var word : words) {
            for (var condition: conditions) {
                if (Utils.isMatch(word, word)) {
                    result += condition.getWeight();
                }
            }
        }
        return result;
    }

    public static enum Kind {
        
        TITLE(9), SUBTITLE(6), DIVISION(3), PARAGRAPH(1);
        
        private Integer weight;
        
        private Kind(int weight) {
            this.weight = weight;
        }

        public Integer getWeight() {
            return weight;
        }
        
    };
    
    public static record Scored(Parted part, Integer scored) {};

}
