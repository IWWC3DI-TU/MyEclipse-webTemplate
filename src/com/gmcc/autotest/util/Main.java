package com.gmcc.autotest.util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {
        String source = new Scanner(new File("c:\\source.html")).useDelimiter("\\Z").next();
        String target = new Scanner(new File("c:\\target.html")).useDelimiter("\\Z").next();
        ExtractLink extractLink = new ExtractLink(source);
        Map<String, String> linkMap = extractLink.getLinks();
        //print the links stored in map
        System.out.println(linkMap.toString());
        Compare compare = new Compare(source, target);
        String outPutSource = compare.getResultSource();
        String outPutTarget = compare.getResultTarget();
        //save the compared result to file
        PrintWriter printSource = new PrintWriter("c:\\resultSource.html");
        PrintWriter printTarget = new PrintWriter("c:\\resultTarget.html");
        printSource.println(outPutSource);
        printTarget.println(outPutTarget);
        printSource.close();
        printTarget.close();
    }
}