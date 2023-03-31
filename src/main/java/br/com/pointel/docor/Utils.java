package br.com.pointel.docor;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.text.Normalizer;
import java.util.Objects;

public class Utils {

    public static File convertToPDF(File path) throws Exception {
        var origin = path.getAbsolutePath();
        var destiny = new File(origin + ".pdf");
        if (destiny.exists()) {
            throw new Exception("Error: the converted file already exists.");
        }
        var parent = origin.substring(0, origin.lastIndexOf(File.separator));
        var name = path.getName().substring(0, path.getName().lastIndexOf('.'));
        var folder = new File(parent, "temp " + name);
        Files.createDirectories(folder.toPath());
        var args = new String[]{"soffice.exe", "--headless", "--convert-to", "pdf", "--outdir", folder.getAbsolutePath(), origin};
        var proc = Runtime.getRuntime().exec(args);
        var reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        if (proc.exitValue() != 0) {
            throw new Exception("Error: could not convert the file.");
        }
        var done = name + ".pdf";
        var converted = new File(folder, done);
        Files.move(converted.toPath(), destiny.toPath());
        folder.delete();
        return destiny;
    }

    public static String normalize(String string) {
        string = string.toLowerCase();
        string = Normalizer.normalize(string, Normalizer.Form.NFD);
        string = string.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return string;
    }
    
    public static boolean isMatch(String s1, String s2) {
        return similarity(s1, s2) > 0.84;
    }

    public static double similarity(String s1, String s2) {
        String longer = s1, shorter = s2;
        if (s1.length() < s2.length()) {
            longer = s2;
            shorter = s1;
        }
        int longerLength = longer.length();
        if (longerLength == 0) {
            return 1.0;
        }
        return (longerLength - editDistance(longer, shorter)) / (double) longerLength;
    }

    public static int editDistance(String s1, String s2) {
        int[] costs = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            int lastValue = i;
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) {
                    costs[j] = j;
                } else {
                    if (j > 0) {
                        int newValue = costs[j - 1];
                        if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                            newValue = Math.min(Math.min(newValue, lastValue),
                                    costs[j]) + 1;
                        }
                        costs[j - 1] = lastValue;
                        lastValue = newValue;
                    }
                }
            }
            if (i > 0) {
                costs[s2.length()] = lastValue;
            }
        }
        return costs[s2.length()];
    }

}
