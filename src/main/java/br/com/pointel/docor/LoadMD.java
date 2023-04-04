package br.com.pointel.docor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;

public class LoadMD implements Loader {

    private final File file;

    public LoadMD(File file) {
        this.file = file;
    }

    @Override
    public Paced load() throws Exception {
        try (var reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
            var paced = new Paced(Utils.getFolderAndName(file));
            var paged = new Paged(paced);
            paced.addPage(paged);
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    paged.addPart(new Parted(paged, Parted.Kind.PARAGRAPH, line));
                }
            }
            return paced;
        }
    }

}
