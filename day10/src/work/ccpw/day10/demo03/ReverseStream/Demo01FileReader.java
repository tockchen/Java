package work.ccpw.day10.demo03.ReverseStream;

import java.io.FileReader;
import java.io.IOException;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-09 12:49
 * FileReader可以读取IDE默认编码格式(UTF-8)的文件
 * FileReader读取系统默认编码(中文GBK)会产生乱码���
 **/
public class Demo01FileReader {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("day10\\我是GBK格式的文本.txt");
        int len = 0;
        while((len = fr.read())!=-1){
            System.out.print((char)len);
        }
        fr.close();
    }
}
