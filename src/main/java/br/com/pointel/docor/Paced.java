package br.com.pointel.docor;

import java.util.ArrayList;
import java.util.List;

public class Paced {
    
    private final String name;
    private final List<Paged> pages;
    
    public Paced(String name) {
        this(name, new ArrayList<>());
    }

    public Paced(String name, List<Paged> pages) {
        this.name = name;
        this.pages = pages;
    }

    public List<Paged> getPages() {
        return pages;
    }
    
    public void addPage(Paged page) {
        pages.add(page);
    }
    
    public void delPage(Paged page) {
        pages.remove(page);
    }
    
    public Found search(List<Condition> conditions) {
        Found results = null;
        for (var paged: pages) {
            var founds = paged.search(conditions);
            if (!founds.isEmpty()) {
                if (results == null) {
                    results = new Found(this);
                }
                results.add(paged, founds);
            }
        }
        return results;
    }
    
    public String getText() {
        var builder = new StringBuilder();
        for (var page : pages) {
            for (var part : page.getParts()) {
                builder.append(part.getText());
                builder.append("\n\n");
            }
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return name;
    }
    
}
