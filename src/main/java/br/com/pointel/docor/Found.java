package br.com.pointel.docor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Found {

    public Paced paced;
    public Integer score;
    public List<Star> stars;

    public Found(Paced paced) {
        this.paced = paced;
        this.score = 0;
        this.stars = new ArrayList<>();
    }
    
    public void add(Paged page, List<Parted.Scored> meets) {
        var pageScored = 0;
        for (var meet : meets) {
            pageScored += meet.scored();
        }
        this.score += pageScored;
        stars.add(new Star(new Paged.Scored(page, pageScored), meets));
    }
    
    public String getSlices() {
        Collections.sort(stars, (e1, e2) -> e2.pageScored.scored().compareTo(e1.pageScored.scored()));
        return "";
    }

    public Object[] toRow() {
        return new Object[]{paced, score, getSlices(), paced.getText()};
    }
    
    public static record Star(Paged.Scored pageScored, List<Parted.Scored> meets){};

}
