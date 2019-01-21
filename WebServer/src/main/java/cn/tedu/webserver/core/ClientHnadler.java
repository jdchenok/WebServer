package cn.tedu.webserver.core;
/**
 * 启动线程
 */

import cn.tedu.webserver.http.HttpRequest;

import java.net.Socket;

public class ClientHnadler implements Runnable {
    private Socket socket;
    /*
    构造方法初始化
     */
    public ClientHnadler(Socket socket) {
        this.socket = socket;
    }
    /*
    重写run方法
     */
    @Override
    public void run() {
        HttpRequest httpRequest = new HttpRequest(socket);
    }
}
