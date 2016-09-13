/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.lfacrawler;

import com.leapfrog.lfacrawler.util.Grabber;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sagar
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Grabber grabber = new Grabber();

            String content = grabber.grab("http://leapfrog.academy");

            String regEx = "<a href=\"(.*?)\" class=\"track\"(.*?)>\\n(.*?)<span class=\"right\"></span>\\n(.*?)<h5>(.*?)</h5>";
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(content);

            while (matcher.find()) {
                System.out.println("Title:" + matcher.group(5));
                String link=matcher.group(1);
                System.out.println("Crawling:" + link);
                System.out.println(grabber.grab(link));
                System.out.println("============================");
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

}
