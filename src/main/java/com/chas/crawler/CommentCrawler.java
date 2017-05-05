package com.chas.crawler;


import com.csvreader.CsvWriter;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.apache.http.Header;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by ShirUshI on 2017/4/6.
 */
public class CommentCrawler extends WebCrawler{
    private final static Pattern FILTERS = Pattern
            .compile(".*(\\.(css|js|bmp|gif|jpe?g|ico"
                    + "|png|tiff?|mid|mp2|mp3|mp4"
                    + "|wav|avi|mov|mpeg|ram|m4v|pdf"
                    + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");


    private final static String CSV_PATH = "./data/comment.csv";
    private CsvWriter cw;
    private File csv;

    public CommentCrawler() throws IOException {

        csv = new File(CSV_PATH);

        if(!csv.exists()) {
            if (csv.isFile()) {
                csv.delete();
            }

            cw = new CsvWriter(new FileWriter(csv, true), ',');
            cw.write("commentid");
            cw.write("shopid");
            cw.write("contribution");
            cw.write("remark");
            cw.write("taste");
            cw.write("envir");
            cw.write("service");
            cw.write("detail");
            cw.write("date");
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
                && href.startsWith("https://www.dianping.com/shop/77298586/review_more?pageno=");
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


            Element shopUL = doc.select("div.revitew-title").first();
            String shopid = shopUL.select("a").first().attr("href").replace("/shop/","");
            Elements comments = doc.select("div.comment-list > ul");
            Elements commentList = comments.select("li[data-id]");
            for(Element c : commentList){

                String commentid = c.attr("data-id");

                Element contributionE = c.select("p.contribution").first();
                String contributionCeche = contributionE.select("span").first().attr("class");
                String contribution = contributionCeche.substring(contributionCeche.length() - 2);

                Element remarkE = c.select("span.item-rank-rst").first();
                String remarkCache = remarkE.attr("class");
                String remark = remarkCache.substring(remarkCache.length() - 2);

                Element commentRst = c.select("div.comment-rst").first();
                Elements comCache = commentRst.select("span.rst");
                String taste = comCache[1].substring(2,3);
                String envir = comCache[2].substring(2,3);
                String service = comCache[3].substring(2,3);

                String detail = c.select("div.J_brief-cont").text();

                Element dateE = c.select("span.time").first();
                String dateCache = dateE.text();
                String date;
                if(dateCache.length() == 5)
                    date = "2017-" + dateCache;
                else if(dateCache.length() == 8)
                    date = "20" + dateCache;
                else {
                    int length = dateCache.length();
                    date = "20" + dateCache.substring(length - 14, length - 6);
                }


                try {
                    cw = new CsvWriter(new FileWriter(csv, true), ',');
                    cw.write(commentid);
                    cw.write(shopid);
                    cw.write(contribution);
                    cw.write(remark);
                    cw.write(taste);
                    cw.write(envir);
                    cw.write(service);
                    cw.write(detail);
                    cw.write(date);
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
