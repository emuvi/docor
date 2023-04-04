package br.com.pointel.docor;

import java.util.ArrayList;
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

    public Paced getPaced() {
        return paced;
    }

    public Integer getScore() {
        return score;
    }

    public List<Star> getStars() {
        return stars;
    }
    
    public void add(Paged page, List<Parted.Scored> meets) {
        var pageScored = 0;
        for (var meet : meets) {
            pageScored += meet.scored;
        }
        this.score += pageScored;
        stars.add(new Star(new Paged.Scored(page, pageScored), meets));
    }
    
    public void multiplier(Integer hits) {
        if (hits > 1) {
            this.score *= hits;
        }
    }

    public Object[] toRow() {
        return new Object[]{this, paced.getName(), paced.getFolderDisplay(), paced.getText().trim()};
    }

    @Override
    public String toString() {
        return "" + score;
    }
    
    public static record Star(Paged.Scored pageScored, List<Parted.Scored> meets){};

}
