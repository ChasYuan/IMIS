package com.chas.crawler;


import com.chas.service.Impl.ShopServiceImpl;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ShirUshI on 2017/4/6.
 */
public class CommentController {



    public static void main(String[] args) throws Exception {
        String crawlStorageFolder = "./data/comment";
        int numberOfCrawlers = 7;

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
//        config.setPolitenessDelay(1000);
        config.setIncludeHttpsPages(true);
        config.setMaxDepthOfCrawling(1);
        config.setResumableCrawling(true);
        config.setUserAgentString("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 YaBrowser/17.3.1.840 Yowser/2.5 Safari/537.36");



        /*
         * Instantiate the controller for this crawl.
         */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        /*
         * For each crawl, you need to add some seed urls. These are the first
         * URLs that are fetched and then the crawler starts following links
         * which are found in these pages
         */
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/graduate?useUnicode=true&characterEncoding=utf8&useSSL=false";
            Connection conn = DriverManager.getConnection(url,"root","1234");
            Statement stmt = conn.createStatement();

            String shopSql = "select id from `shop` WHERE category = '日本菜' ";
            ResultSet rs = stmt.executeQuery(shopSql);
            List<Integer> shopList = new ArrayList<Integer>();
            while(rs.next()){
                shopList.add(rs.getInt(1));
            }

            String pre = "https://www.dianping.com/shop/";
            String aft = "/review_more?pageno=1";
            Iterator<Integer> shopIt = shopList.iterator();
            while(shopIt.hasNext()){
                int city = shopIt.next();
               controller.addSeed(pre + city + aft);
            }
            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }



//        controller.addSeed("https://www.dianping.com/shop/77013723/review_more?pageno=1");
//        controller.addSeed("https://www.dianping.com/shop/77298586/review_more?pageno=2");
//        controller.addSeed("https://www.dianping.com/search/category/1/10/g110");
//        controller.addSeed("https://www.dianping.com/search/category/1/10/g110p2");
//        controller.addSeed("http://www.ics.uci.edu/~welling/");
//        controller.addSeed("http://www.ics.uci.edu/");

        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
        controller.start(CommentCrawler.class, numberOfCrawlers);

    }
}
