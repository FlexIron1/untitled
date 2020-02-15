package com.example;


import com.example.impl.DownloadHTMLpageImpl;
import com.example.impl.ParsingHTMLpageImpl;
import com.example.servise.DownloadHTMLpage;
import com.example.servise.ParsingHTMLpage;

import java.io.IOException;

public class Main {
    private static DownloadHTMLpage downloadHTMLpageImp = new DownloadHTMLpageImpl();
    private static ParsingHTMLpage parsingHTMLpageImp = new ParsingHTMLpageImpl();

    public static void main(String[] args) {
        try {
            downloadHTMLpageImp.downloadHTMLpage("https://www.simbirsoft.com/");
            parsingHTMLpageImp.CountingUniqueWordsInPage("https://www.simbirsoft.com/");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





