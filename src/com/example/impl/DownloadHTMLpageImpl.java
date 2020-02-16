package com.example.impl;

import com.example.servise.DownloadHTMLpage;
import com.example.servise.ParsingHTMLpage;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class DownloadHTMLpageImpl implements DownloadHTMLpage {
    private Logger logger = Logger.getLogger(ParsingHTMLpage.class.getName());


    /**
     * @throws IOException
     * The downloadPage method accepts an HTTP request as input and downloads an HTML page
     * to a local computer disk.
     * Application guide: after starting the application, you must specify the address
     * and file name (how you want to save it on the local disk), after which the
     * countingUniqueWordsInPage method will start working.
     *
     */
    @Override
    public void downloadPage(String urlPage) throws IOException {
        URL url = null;
        try {
            url = new URL(urlPage);
        } catch (MalformedURLException e) {
            logger.log(Level.ERROR, "This address does not exist", e);
            System.out.println("This address does not exist");
            System.exit(1);
        }
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream()));
        System.out.println("Enter file name");
        BufferedWriter writer = new BufferedWriter(new FileWriter(scanner.next() + ".html"));
        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(line);
        }
        System.out.println("Page downloaded.");
        }

    }
