package com.chas.crawler;


import com.chas.dao.CategoryDao;
import com.chas.dao.CityDao;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

/**
 * Created by ShirUshI on 2017/4/6.
 */
public class ShopController {
    public static void main(String[] args) throws Exception {
        String crawlStorageFolder = "./data/shop";
        int numberOfCrawlers = 5;

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

            String citySql = "select id from `city`";
            ResultSet rscity = stmt.executeQuery(citySql);
            List<Integer> cityList = new ArrayList<Integer>();
            while(rscity.next()){
                cityList.add(rscity.getInt(1));
            }
            String categorySql = "select id,category from `category`";
            ResultSet rscategory = stmt.executeQuery(categorySql);
            List<String> categoryList = new ArrayList<String>();
            while(rscategory.next()){
                categoryList.add(rscategory.getString(1));
            }

            String pre = "https://www.dianping.com/search/category/";
            String mid = "/10/";
            String aft = "p2";
            Iterator<Integer> cityIt = cityList.iterator();
            Iterator<String> categoryIt = categoryList.iterator();
            while(cityIt.hasNext()){
                int city = cityIt.next();
                while(categoryIt.hasNext()){
                    String category = categoryIt.next();
                    if(category.equals("g113") || category.equals("g102")) {
                        controller.addSeed(pre + city + mid + category + aft);
//                        controller.addSeed(pre + city + mid + category + aft);
                    }else{
                        controller.addSeed(pre + city + mid + category);
//                        controller.addSeed(pre + city + mid + category + "p3");
                    }
//                    for(int i = 2;i < 5;i++)
//                        controller.addSeed(pre + city + mid + category + aft + i);
                }
            }

            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }




//        controller.addSeed("https://www.dianping.com/search/category/2/10/g110");
//        controller.addSeed("https://www.dianping.com/search/category/2/10/g110p2");
//        controller.addSeed("https://www.dianping.com/search/category/1/10/g110");
//        controller.addSeed("https://www.dianping.com/search/category/1/10/g110p2");
//        controller.addSeed("http://www.ics.uci.edu/~welling/");
//        controller.addSeed("http://www.ics.uci.edu/");

        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
        controller.start(ShopCrawler.class, numberOfCrawlers);

    }
}
