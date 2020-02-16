package com.example.impl;

import com.example.servise.ParsingHTMLpage;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ParsingHTMLpageImpl implements ParsingHTMLpage {

    private Logger logger = Logger.getLogger(ParsingHTMLpage.class.getName());
    private Scanner scanner = new Scanner(System.in);
    private String[] pageItems = null;
    private ArrayList<String> list = new ArrayList<>();
    private Map<String, Integer> letters = new HashMap<>();

    /**
     * The method  countingUniqueWordsInPage allows you to count words and how many times they appear on the page.
     * Application Guide: You must specify a file name that has the HTML extension, if the file is
     * empty, the program will complete its work before starting work,
     * you must make sure that the file is not empty and has the HTML extension.
     */
    public void countingUniqueWordsInPage() {

        System.out.println("Enter an existing file in which you want to count the number of matches.");
        File htmlFile = new File(scanner.next() + ".html");
        Character[] splitUp = {' ', ',', '.', '!', '?', '"', ';', ':', '[', ']', '(', ')', '\n', '\r', '\t'};

        try {
            if (htmlFile.length() > 0) {
                Document doc = Jsoup.parse(htmlFile, "UTF-8");
                pageItems = doc.body().getAllElements().text().split(Arrays.toString(splitUp));
            } else {
                System.out.println("The file is empty");
                logger.log(Level.DEBUG, "The file is empty");
                System.exit(1);
            }
            Collections.addAll(list, pageItems);
        } catch (IOException e) {
            System.out.println("This address does not exist");
            logger.log(Level.DEBUG, "Exception", e);
            System.exit(1);
        }
        for (String tempString : list) {
            if (!letters.containsKey(tempString)) {
                letters.put(tempString, 1);
            } else {
                letters.put(tempString, letters.get(tempString) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : letters.entrySet()) {

            System.out.println(entry.getKey() + " - " + entry.getValue());

        }
    }
}
