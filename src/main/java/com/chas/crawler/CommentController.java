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
import java.util.*;

/**
 * Created by ShirUshI on 2017/4/6.
 */
public class CommentController {



    public static void main(String[] args) throws Exception {
        String crawlStorageFolder = "./data/comment";
        int numberOfCrawlers = 7;

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        config.setPolitenessDelay(1000);
        config.setIncludeHttpsPages(true);
        config.setMaxDepthOfCrawling(0);
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

            String shopSql = "select id,commentNum from `shop` where category = '日本菜'";
            ResultSet rs = stmt.executeQuery(shopSql);
            HashMap<Integer,Integer> shopList = new HashMap<Integer,Integer>();
            while(rs.next()){
                shopList.put(rs.getInt(1),rs.getInt(2));
            }

            String pre = "https://www.dianping.com/shop/";
            String aft = "/review_more?pageno=";
            Iterator iter = shopList.entrySet().iterator();
            while(iter.hasNext()){
                Map.Entry entry = (Map.Entry)iter.next();
                int shopid = (Integer)entry.getKey();
                int num = ((Integer)entry.getValue() / 20) + 1;
                for(int i = 1; i <= num ;i++)
                    controller.addSeed(pre + shopid + aft + i);
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
