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

    public Object[] toRow() {
        return new Object[]{score, paced.getName(), paced.getName(), paced.getText().trim()};
    }
    
    public static record Star(Paged.Scored pageScored, List<Parted.Scored> meets){};

}
