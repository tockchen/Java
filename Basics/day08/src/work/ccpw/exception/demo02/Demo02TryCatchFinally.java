package work.ccpw.exception.demo02;

import java.io.IOException;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-07 16:51
 **/
public class Demo02TryCatchFinally {
    public static void main(String[] args) {
        try {
            //可能会产生异常的代码
            readFile("c:\\a.tx");
        } catch (IOException e) {
            //异常的处理逻辑
            e.printStackTrace();
        } finally {
            //无论是否出现异常,都会执行
            System.out.println("资源释放");
        }
    }

    /**
     * 如果传递的路径,不是.txt结尾
     * 那么我们就抛出IO异常对象,告知方法的调用者,文件的后缀名不对
     * @param fileName 文件名
     * @throws IOException 输入输出异常
     */
    public static void readFile(String fileName) throws IOException {

        if(!fileName.endsWith(".txt")){
            throw new IOException("文件的后缀名不对");
        }

        System.out.println("路径没有问题,读取文件");
    }
}
