package com.cykj.service.crawler;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.regex.Pattern;

public class BaiduCrawler extends WebCrawler {

    //自定义过滤规则
    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg|png|mp3|mp4|zip|gz))$");

    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        //过滤不想访问的url
        //return false时 url被过滤掉不会被爬取
        String href = url.getURL().toLowerCase();
        boolean b =!FILTERS.matcher(href).matches()&&href.startsWith("https://www.baidu.com");
        return b;
    }

    @Override
    public void visit(Page page) {
        //这个方法的作用是当shouldVisit方法返回true时，调用该方法，获取网页内容，已被封装到Page
        String url = page.getWebURL().getURL();
        System.out.println(url);
        //判断page是否为真正的网页
        if (page.getParseData() instanceof HtmlParseData){
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String html = htmlParseData.getHtml();
            Document doc = Jsoup.parse(html);


        }
    }
}
