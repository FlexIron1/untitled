package com.example.impl;

import com.example.servise.DownloadHTMLpage;
import org.jsoup.Connection;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class DownloadHTMLpageImpl implements DownloadHTMLpage {

    @Override
    public void downloadHTMLpage(String urlD) throws MalformedURLException {
        URL url = new URL(urlD);
        Scanner scanner = new Scanner(System.in);
        BufferedWriter writer;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(url.openStream()));
        } catch (IOException ie) {
            System.out.println("Данный адрес не существует");
        }
        try {
            writer = new BufferedWriter(new FileWriter(scanner.next() + ".html"));
            String line;
            if (reader!=null) {
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                }
            }
            else {
                System.out.println(new NullPointerException());
            }
            System.out.println("Page downloaded.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}