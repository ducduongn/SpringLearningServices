package com.example.springsecuritydemo.crawler;

import com.example.springsecuritydemo.constant.cralwer.URLConstant;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ducduongn
 */

@Slf4j
@NoArgsConstructor
public class WebCrawler {
    private Document document;

    public WebCrawler(Document document) {
        this.document = document;
    }

    @PostConstruct
    public void crawlCategories() {
        HashMap<String, String> urlCateUrlMap = new HashMap<>();
        try {
            File file = new File(URLConstant.htmlPath);
            Document document = Jsoup.parse(file, "UTF-8", URLConstant.VN_EXPRESS_HOME);

            Elements menuElement = document.select("li a");

            menuElement.forEach(e -> {
                String title = e.attr("title");
                String url = e.attr("abs:href");

                log.info(title + ": " + url);

                if (!url.contains("javascript")) {
                    urlCateUrlMap.put(title, url);
                }
            });

//            System.out.println(menuElement);
        } catch (IOException e) {
            log.error("IO  exception!");
        }
        System.out.println(urlCateUrlMap);
    }

}
