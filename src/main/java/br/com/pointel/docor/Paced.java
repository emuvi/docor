package br.com.pointel.docor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.tuple.Pair;

public class Paced {
    
    private final String name;
    private final String folder;
    private final List<Paged> pages;
    
    public Paced(Pair<String, String> folderAndName) {
        this(folderAndName.getRight(), folderAndName.getLeft(), new ArrayList<>());
    }
    
    public Paced(String name, String folder) {
        this(name, folder, new ArrayList<>());
    }

    public Paced(String name, String folder, List<Paged> pages) {
        this.name = name;
        this.folder = folder;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public String getFolder() {
        return folder;
    }
    
    public String getFolderDisplay() {
        return folder.substring(folder.lastIndexOf(File.separator) + 1);
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
        var hits = 1;
        for (var paged: pages) {
            var founds = paged.search(conditions);
            if (!founds.isEmpty()) {
                if (results == null) {
                    results = new Found(this);
                }
                results.add(paged, founds);
                hits++;
            }
        }
        return results;
    }
    
    public String getText() {
        var builder = new StringBuilder();
        for (var page : pages) {
            for (var part : page.getParts()) {
                builder.append(part.getText());
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return name;
    }
    
}
