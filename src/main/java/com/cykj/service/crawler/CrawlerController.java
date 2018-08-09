package com.cykj.service.crawler;

import com.cykj.service.base.Constants;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/8/9 10:21.
 */
public class CrawlerController {

    public static void main(String[] args) throws Exception {
        //文件储存位置
        String crawlStorageFolder = "/data/crawl/root";
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
        controller.addSeed("http://www.nmc.cn/publish/forecast/ASC/dayi.html");

        //开始执行爬虫
        controller.start(MyCrawler.class,numberOfCrawlers);
    }

    public static void getLocalWeatherInfo() throws Exception {
        System.out.println("----------爬虫开始----------");
        //文件储存位置
        String crawlStorageFolder = "/data/crawl/root";
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

        for (String string: Constants.LOCAL_MAP.keySet()){
            //传入的url
            controller.addSeed("http://www.nmc.cn/publish/forecast/ASC/"+Constants.LOCAL_MAP.get(string)+".html");
        }


        //开始执行爬虫
        controller.start(MyCrawler.class,numberOfCrawlers);
    }

 }
