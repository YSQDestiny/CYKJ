package com.cykj.service.crawler;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import edu.uci.ics.crawler4j.url.WebURL;

import java.net.URLEncoder;

public class BaiduCrawlerController {

    private static String urll = "http://www.baidu.com/s?wd=";

    public static void main(String[] args) throws Exception{

        getInfo("成都&内涝",20);

    }

    private static void getInfo(String question,int num) throws Exception {

        String url = "";
        url = urll + URLEncoder.encode(question,"utf-8") + "&rn=" + num;

        //文件储存位置
        String crawlStorageFolder="/data/crawl/root";
        //线程数量
        int numberOfCrawlers = 1;

        CrawlConfig config = new CrawlConfig();
        //配置对象设置
        config.setCrawlStorageFolder(crawlStorageFolder);

        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig,pageFetcher);
        //创建
        CrawlController controller = new CrawlController(config,pageFetcher,robotstxtServer);

        //传入的url
        controller.addSeed("https://www.baidu.com");

        //开始执行爬虫
        controller.start(BaiduCrawler.class,numberOfCrawlers);
    }

}
