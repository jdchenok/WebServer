package cn.tedu.webserver.core;
/**
 * 主类
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    private ServerSocket serverSocket;
    /*
    构造方法初始化
     */
    public WebServer() {
        try {
            System.out.println("开始初始化服务器>>>");
            serverSocket = new ServerSocket(8080);
            System.out.println("服务器初始化完毕！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    开始方法
     */
    private void start(){
        try {
            System.out.println("等待一个客户端连接>>>");
            Socket socket = serverSocket.accept();
            System.out.println("一个客户端已连接！");

            System.out.println("调用线程解析请求>>>");
            ClientHnadler clientHnadler = new ClientHnadler(socket);
            Thread t = new Thread(clientHnadler);
            t.start();
            System.out.println("请求解析完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WebServer webServer = new WebServer();
        webServer.start();
    }

}
