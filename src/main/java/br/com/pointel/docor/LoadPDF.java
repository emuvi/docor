package br.com.pointel.docor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

public class LoadPDF {

    private File file;

    public LoadPDF(File file) {
        this.file = file;
    }

    public Paced load() throws Exception {
        try (var doc = PDDocument.load(file)) {
            var stripper = new Stripper();
            stripper.getText(doc);
            var stripes = stripper.stripes;
            Collections.sort(stripes, (e1, e2) -> {
                var dif = Integer.compare(e1.page, e2.page);
                if (dif != 0) {
                    return dif;
                }
                return Float.compare(e1.minY, e2.minY);
            });
            if (stripes.isEmpty()) {
                return null;
            }
            var paced = new Paced(Utils.getFolderAndName(file));
            var paged = new Paged(paced);
            paced.addPage(paged);
            var pageNr = 1;
            for (var stripe : stripes) {
                if (stripe.page != pageNr) {
                    paged = new Paged(paced);
                    paced.addPage(paged);
                    pageNr = stripe.page;
                }
                paged.addPart(new Parted(paged, Parted.Kind.PARAGRAPH, stripe.line()));
            }
            return paced;
        }
    }

    private class Stripper extends PDFTextStripper {

        private final List<Stripes> stripes = new ArrayList<>();

        public Stripper() throws IOException {
        }

        @Override
        protected void writeString(String line, List<TextPosition> positions) throws IOException {
            if (positions.isEmpty()) {
                return;
            }
            var page = getCurrentPageNo();
            var minY = positions.get(0).getY();
            var maxY = positions.get(0).getY() + positions.get(0).getHeight();
            var meanFont = positions.get(0).getFontSizeInPt();
            for (var i = 1; i < positions.size(); i++) {
                minY = Math.min(minY, positions.get(0).getY());
                maxY = Math.max(maxY, positions.get(0).getY() + positions.get(0).getHeight());
                meanFont = (meanFont + positions.get(0).getFontSizeInPt()) / 2;
            }
            stripes.add(new Stripes(page, line, minY, maxY, meanFont));
        }
    }

    private record Stripes(int page, String line, float minY, float maxY, float meanFont) {}

}
