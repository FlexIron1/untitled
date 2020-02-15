package com.example.impl;

import com.example.servise.ParsingHTMLpage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ParsingHTMLpageImpl implements ParsingHTMLpage {
    public void CountingUniqueWordsInPage(String url) {
        Document doc;
        Scanner scanner = new Scanner(System.in);
        String[] pageItems = null;
        ArrayList<String> list = new ArrayList<>();
        Map<String, Integer> letters = new HashMap<>();
        File htmlFile = new File(scanner.next() + ".html");
        try {
            doc = Jsoup.parse(htmlFile, "UTF-8");
            pageItems = doc.body().getAllElements().text().split(" ");
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Sorry ");
            System.out.println("This address does not exist");
            System.exit(1);
        }
        Collections.addAll(list, pageItems);
        for (String tempString : list) {
            if (!letters.containsKey(tempString)) {
                letters.put(tempString, 1);
            } else {
                letters.put(tempString, letters.get(tempString) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : letters.entrySet()) {

            System.out.println("Слово = " + entry.getKey() + ", Повторений = " + entry.getValue());

        }
    }
}
