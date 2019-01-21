package cn.tedu.webserver.http;
/**
 * 解析请求
 */

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class HttpRequest {
    private InputStream inputStream;
    private Socket socket;

    private String method;
    private String url;
    private String protocol;
    /*
    构造方法初始化
     */
    public HttpRequest(Socket socket) {
        try {
            this.socket = socket;
            this.inputStream = socket.getInputStream();

            parseRequest();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    解析请求行
     */
    private void parseRequest(){
        System.out.println("开始解析请求行>>>");
        String line = readLine();
        String[] arrays = line.split("\\s");
        method = arrays[0];
        url = arrays[1];
        protocol = arrays[2];
        System.out.println(method+url+protocol);
        System.out.println("请求行解析完毕！");
    }
    /*
    解析请求
     */
    private String readLine(){
        try{
            StringBuilder builder = new StringBuilder();
            int d = -1;
            char c1 = 'a',c2 = 'a';
            while ((d = inputStream.read())!=-1){
                c2 = (char)d;
                if (c1 == 13 && c2 == 10){
                    break;
                }
                builder.append(c2);
                c1 = c2;
            }
            return builder.toString().trim();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
