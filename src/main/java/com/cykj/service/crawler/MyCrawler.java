package com.cykj.service.crawler;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cykj.service.base.Constants;
import com.cykj.service.entity.Weather;
import com.cykj.service.entity.WeatherInfo;
import com.cykj.service.web.service.WeatherInfoService;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Pattern;

/**
 * @author yangsq
 * @date 2018/8/9 9:59.
 */
public class MyCrawler extends WebCrawler {

    @Autowired
    WeatherInfoService weatherInfoService;

    //自定义过滤规则
    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg|png|mp3|mp4|zip|gz))$");

    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        //过滤不想访问的url
        //return false时 url被过滤掉不会被爬取
        String href = url.getURL().toLowerCase();
        boolean b =!FILTERS.matcher(href).matches()&&href.startsWith("http://www.nmc.cn/publish/forecast/ASC");
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

            Elements nameEle = doc.getElementsByClass("cname fl");
            String name = nameEle.get(0).text();

            Elements elements = doc.getElementsByTag("script");
            Element element = elements.get(7);
            String temp = element.data().toString();
            String substring = temp.substring(temp.indexOf("climate("), temp.indexOf("});"));
            String str = substring.substring(8, 223);

            String[] sub = str.split("],");

            WeatherInfo weather = new WeatherInfo();
            weather.setName(name);
            weather.setHighWeather(sub[0] + "]");
            weather.setLowWeather(sub[1]+"]");

            if (sub[2].indexOf("]") == -1) {
                weather.setRainfall(sub[2] + "]");
            } else {
                weather.setRainfall(sub[2]);
            }

            Constants.addWether(weather);

        }
    }
}
