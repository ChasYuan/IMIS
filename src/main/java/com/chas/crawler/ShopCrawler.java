package com.chas.crawler;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.regex.Pattern;

import com.csvreader.CsvWriter;
import org.apache.http.Header;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by ShirUshI on 2017/4/6.
 */
public class ShopCrawler extends WebCrawler{
    private final static Pattern FILTERS = Pattern
            .compile(".*(\\.(css|js|bmp|gif|jpe?g|ico"
                    + "|png|tiff?|mid|mp2|mp3|mp4"
                    + "|wav|avi|mov|mpeg|ram|m4v|pdf"
                    + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");


    private final static String CSV_PATH = "./data/shop.csv";
    private CsvWriter cw;
    private File csv;

    public ShopCrawler() throws IOException {

        csv = new File(CSV_PATH);

        if(!csv.exists()) {
            if (csv.isFile()) {
                csv.delete();
            }

            cw = new CsvWriter(new FileWriter(csv, true), ',');
            cw.write("shopid");
            cw.write("shopName");
            cw.write("star");
            cw.write("city");
            cw.write("address");
            cw.write("detailAddr");
            cw.write("commentNum");
            cw.write("meanPrice");
            cw.write("category");
            cw.write("taste");
            cw.write("envir");
            cw.write("service");
            cw.endRecord();
            cw.close();
        }
    }

    /**
     * You should implement this function to specify whether the given url
     * should be crawled or not (based on your crawling logic).
     */
    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        return !FILTERS.matcher(href).matches()
                && href.startsWith("https://www.dianping.com/");
    }

    /**
     * This function is called when a page is fetched and ready to be processed
     * by your program.
     */
    @Override
    public void visit(Page page) {
//        int docid = page.getWebURL().getDocid();
//        String url = page.getWebURL().getURL();
//        String domain = page.getWebURL().getDomain();
//        String path = page.getWebURL().getPath();
//        String subDomain = page.getWebURL().getSubDomain();
//        String parentUrl = page.getWebURL().getParentUrl();
//        String anchor = page.getWebURL().getAnchor();
//
//        logger.debug("Docid: {}", docid);
//        logger.info("URL: {}", url);
//        logger.debug("Domain: '{}'", domain);
//        logger.debug("Sub-domain: '{}'", subDomain);
//        logger.debug("Path: '{}'", path);
//        logger.debug("Parent page: {}", parentUrl);
//        logger.debug("Anchor text: {}", anchor);



        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String text = htmlParseData.getText();
            String html = htmlParseData.getHtml();
            Set<WebURL> links = htmlParseData.getOutgoingUrls();

            Document doc = Jsoup.parse(html);


            Elements shopUL = doc.select("div#shop-all-list > ul");
            String city = doc.select("a.city.J-city").first().text();
            Elements shopList = shopUL.select("li");
            for(Element c : shopList){
                Element tit = c.select("div.tit").first();
                Element titleC = tit.select("a[href]").first();
                String shopName = titleC.attr("title");
                String shop = titleC.attr("href");
                String shopid = shop.replace("/shop/","");

                Element commentC = c.select("div.comment").first();
                Element commentCp = commentC.select("span[title]").first();
                String star = commentCp.attr("class").substring(22);


                Elements tag_addr = c.select("div.tag-addr");
                String category = tag_addr.select("span.tag").first().text();
                String address = tag_addr.select("span.tag").last().text();
                String detailAddr = c.select("span.addr").first().text();

                String commentList = c.select("span.comment-list").first().text();
                String[] comCache = commentList.split(" ");
                String taste = comCache[0].replace("口味","");
                String envir = comCache[1].replace("环境","");
                String service = comCache[2].replace("服务","");

                String commentNum = c.select("a.review-num > b").text();
                String meanPrice = c.select("a.mean-price > b").text().replace("￥","");

                try {
                    cw = new CsvWriter(new FileWriter(csv, true), ',');
                    cw.write(shopid);
                    cw.write(shopName);
                    cw.write(star);
                    cw.write(city);
                    cw.write(address);
                    cw.write(detailAddr);
                    cw.write(commentNum);
                    cw.write(meanPrice);
                    cw.write(category);
                    cw.write(taste);
                    cw.write(envir);
                    cw.write(service);
                    cw.endRecord();
                    cw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


            logger.debug("Text length: {}", text.length());
            logger.debug("Html length: {}", html.length());
            logger.debug("Number of outgoing links: {}", links.size());
        }

        Header[] responseHeaders = page.getFetchResponseHeaders();
        if (responseHeaders != null) {
            logger.debug("Response headers:");
            for (Header header : responseHeaders) {
                logger.debug("\t{}: {}", header.getName(), header.getValue());
            }
        }

        logger.debug("=============");
    }
}
