package br.com.pointel.docor;

    public class Condition {
    
    private Integer weight;
    private String word;

    public Condition(Integer weight, String word) {
        this.weight = weight;
        this.word = word;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getWord() {
        return word;
    }
    
}
