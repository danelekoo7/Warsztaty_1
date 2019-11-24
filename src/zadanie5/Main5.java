package src.zadanie5;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Connection connect = Jsoup.connect("http://www.onet.pl/");
        Document docu = null;
        try {
            docu = connect.get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path path = Paths.get("popular_words.txt");
        List<String> outList = new ArrayList<>();
        Elements links = docu.select("span.title");
        for (Element elem : links) {
            String words = new String(elem.text());
            String words1 = words.toLowerCase();
            String words2 = words1.replaceAll("[,.\\-\":\\[\\]']", "");
            String[] wordsArray = words2.split("[ \\-]");
            for (int i = 0; i < wordsArray.length; i++) {
                if (wordsArray[i].length() > 2) {
                    outList.add(wordsArray[i]);
                }
            }
            try {
                Files.write(path, outList);
            } catch (IOException ex) {
                System.out.println("błąd zapisu pliku");
            }
        }
        String[] bannedWords = {"oraz", "ponieważ", "albo", "dlaczego", "dlatego", "gdyby", "gdyż"
        };
        Path censoredLists = Paths.get("filtered_popular_words.txt");
        List<String> censoredWords = new ArrayList<>();
        File file = new File("popular_words.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            String word = scanner.nextLine();
            if (!Arrays.asList(bannedWords).contains(word)) {
                censoredWords.add(word);
            }
        }
        try {
            Files.write(censoredLists, censoredWords);
        } catch (IOException ex) {
            System.out.println("błąd zapisu pliku");
        }
    }
}
