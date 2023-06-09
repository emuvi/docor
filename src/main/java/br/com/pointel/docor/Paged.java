package br.com.pointel.docor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Paged {

    private final Paced paced;
    private final List<Parted> parts;

    public Paged(Paced paced) {
        this(paced, new ArrayList<>());
    }

    public Paged(Paced paced, List<Parted> parts) {
        this.paced = paced;
        this.parts = parts;
    }

    public Paced getPaced() {
        return paced;
    }

    public List<Parted> getParts() {
        return parts;
    }

    public void addPart(Parted part) {
        parts.add(part);
    }

    public void delPart(Parted part) {
        parts.remove(part);
    }

    public List<Parted.Scored> search(List<Condition> conditions) {
        List<Parted.Scored> results = new ArrayList<>();
        var hits = 1;
        for (var part : parts) {
            var score = part.search(conditions);
            if (score > 0) {
                results.add(new Parted.Scored(part, score));
                hits++;
            }
        }
        if (hits > 1) {
            for (var result : results) {
                result.scored *= hits;
            }
        }
        Collections.sort(results, (e1, e2) -> e2.scored.compareTo(e1.scored));
        return results;
    }

    public static class Scored {

        public Paged page;
        public Integer scored;

        public Scored(Paged page, Integer scored) {
            this.page = page;
            this.scored = scored;
        }

    }

}
