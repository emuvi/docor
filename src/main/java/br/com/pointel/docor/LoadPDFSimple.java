package br.com.pointel.docor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

public class LoadPDFSimple implements Loader {

    private final File file;

    public LoadPDFSimple(File file) {
        this.file = file;
    }

    @Override
    public Paced load() throws Exception {
        try (var doc = PDDocument.load(file)) {
            var paced = new Paced(Utils.getFolderAndName(file));
            var stripper = new PDFTextStripper();
            for (int i = 1; i <= doc.getNumberOfPages(); i++) {
                var paged = new Paged(paced);
                paced.addPage(paged);
                stripper.setStartPage(i);
                stripper.setEndPage(i);
                var text = stripper.getText(doc);
                var lines = text.split("\n");
                for (var line : lines) {
                    line = line.trim();
                    if (!line.isEmpty()) {
                        paged.addPart(new Parted(paged, Parted.Kind.PARAGRAPH, line));
                    }
                }
            }
            return paced;
        }
    }

}
