package com.gmcc.autotest.util;
/**
 * @author Wayne.Song
 * @version 0.0.1.Alpha
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.HashMap;
import java.util.Map;

public class ExtractLink {
    private String html;
    private Map<String, String> linkResultMap;
    public ExtractLink(String htmlFile){
        this.html = htmlFile;
        this.linkResultMap = new HashMap<String, String>();
        getLinks();
    }
   /**
    * 
    * @return 
    */
    public Map<String, String > getLinks(){
        Document doc = Jsoup.parse(this.html);
        Elements links = doc.select("a[href]");
        for (Element link : links) {
            this.linkResultMap.put(link.text(),link.attr("href"));
        }
        return this.linkResultMap;
    }
}
