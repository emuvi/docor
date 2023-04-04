package br.com.pointel.docor;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.text.Normalizer;
import java.util.Objects;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.tuple.Pair;

public class Utils {

    public static File convertToPDF(File path) throws Exception {
        var origin = path.getAbsolutePath();
        var destiny = new File(origin + ".pdf");
        if (destiny.exists()) {
            return null;
        }
        var parent = origin.substring(0, origin.lastIndexOf(File.separator));
        var folder = new File(parent, "_docor_temp_" + RandomStringUtils.randomAlphabetic(8));
        try {
            if (folder.exists()) {
                FileUtils.deleteDirectory(folder);
            }
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
            var name = path.getName().substring(0, path.getName().lastIndexOf('.'));
            var done = name + ".pdf";
            var converted = new File(folder, done);
            Files.move(converted.toPath(), destiny.toPath());
            return destiny;
        } catch (Exception ex) {
            throw ex;
        } finally {
            FileUtils.deleteDirectory(folder);
        }
    }

    public static String normalize(String string) {
        string = string.toLowerCase();
        string = Normalizer.normalize(string, Normalizer.Form.NFD);
        string = string.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        string = string.replaceAll("\\W+", "");
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
        var result = (longerLength - editDistance(longer, shorter)) / (double) longerLength;
//        System.out.println("Sim of \t" + s1 + " and \t" + s2 + " = " + result);
        return result;
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

    public static Pair<String, String> getFolderAndName(File file) {
        var path = file.getAbsolutePath();
        var last = path.lastIndexOf(File.separator);
        return Pair.of(path.substring(0, last), path.substring(last + 1));
    }

}
