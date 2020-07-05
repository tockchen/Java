package work.ccpw.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-21 13:28
 **/
public class JsoupDemo7 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo7.class.getClassLoader().getResource("student.xml").getPath();
        Document parse = Jsoup.parse(new File(path), "utf-8");
        String s = parse.toString();
        System.out.println(s);

    }
}
