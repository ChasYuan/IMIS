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
        String crawlStorageFolder = "./data/comment";  //设置爬虫日志文件生成目录
        int numberOfCrawlers = 7;   //设置爬虫线程数量

        CrawlConfig config = new CrawlConfig(); //初始化配置
        config.setCrawlStorageFolder(crawlStorageFolder); //载入配置
//        config.setPolitenessDelay(1000);   //设置爬虫延时，防止激烈的反爬虫策略
        config.setIncludeHttpsPages(true);   //设置https页面爬取
        config.setMaxDepthOfCrawling(0);     //设置爬取深度为0，即爬取当前页面。因数据量大，将通过指定所有目标URL进行爬取，而非爬虫自动发现，这样减少了非目标页面的访问量，提高了数据抓取效率
        config.setResumableCrawling(true);   //设置爬虫线程的可恢复，防止爬虫因错误中止而停止运行
        config.setUserAgentString("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 YaBrowser/17.3.1.840 Yowser/2.5 Safari/537.36"); //设置User-Agent，模拟浏览器请求



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

            String shopSql = "select id,commentNum from `shop` where category = \"川菜\" or category = \"火锅\"";
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
