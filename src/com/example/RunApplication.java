package com.example;


import com.example.impl.DownloadHTMLpageImpl;
import com.example.impl.ParsingHTMLpageImpl;
import com.example.servise.DownloadHTMLpage;
import com.example.servise.ParsingHTMLpage;

import java.io.IOException;
import java.util.Scanner;

public class RunApplication {
    /**
     * The RunApplication class that runs the application.
     */
    private static DownloadHTMLpage downloadHTMLpageImp = new DownloadHTMLpageImpl();
    private static ParsingHTMLpage parsingHTMLpageImp = new ParsingHTMLpageImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Enter address");

        downloadHTMLpageImp.downloadPage(scanner.nextLine() + "");
        parsingHTMLpageImp.countingUniqueWordsInPage();

    }
}





