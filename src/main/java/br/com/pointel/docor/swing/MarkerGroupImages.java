package br.com.pointel.docor.swing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.commonmark.node.AbstractVisitor;
import org.commonmark.node.Image;
import org.commonmark.parser.Parser;

public class MarkerGroupImages {
    
    private final String text;
    private final File folder;
    private final File destiny;
    

    public MarkerGroupImages(String text, File folder, File destiny) {
        this.text = text;
        this.folder = folder;
        this.destiny = destiny;
    }
    
    public void save() throws Exception {
        var images = loadImages(getImagePaths());
        var width = getMaxWidth(images);
        var height = getSumHeight(images);
        var result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        var canvas = result.createGraphics();
        var y = 0;
        for (BufferedImage image : images) {
            var x = (width - image.getWidth()) / 2;
            canvas.drawImage(image, x, y, null);
            y += image.getHeight();
        }
        ImageIO.write(result, "PNG", destiny);
    }
    
    private List<String> getImagePaths() {
        var parser = Parser.builder().build();
        var document = parser.parse(text);
        var finder = new FindImagePaths();
        document.accept(finder);
        return finder.results;
    }
    
    private class FindImagePaths extends AbstractVisitor {
        private List<String> results = new ArrayList<>();

        @Override
        public void visit(Image image) {
            results.add(image.getDestination());
        }
    }
    
    private List<BufferedImage> loadImages(List<String> paths) throws Exception {
        var result = new ArrayList<BufferedImage>();
        for (String path : paths) {
            var origin = new File(folder, path);
            var image = ImageIO.read(origin);
            result.add(image);
        }
        return result;
    }
    
    private Integer getMaxWidth(List<BufferedImage> ofImages) {
        var result = 0;
        for (BufferedImage image : ofImages) {
            if (image.getWidth() > result) {
                result = image.getWidth();
            }
        }
        return result;
    }
    
    private Integer getSumHeight(List<BufferedImage> ofImages) {
        var result = 0;
        for (BufferedImage image : ofImages) {
            result += image.getHeight();
        }
        return result;
    }
}
