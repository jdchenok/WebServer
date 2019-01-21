package cn.tedu.webserver.http;
/*
响应对象
 */
import sun.java2d.pipe.OutlineTextRenderer;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class HttpResponse {
    private File entity;
    private Socket socket;
    private OutputStream outputStream;

    public HttpResponse(Socket socket) {
        try {
            this.socket = socket;
            this.outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /*
    将当前响应以http回复给客户端
     */
    public void flush(){

    }
    /*
    发送状态行
     */
    private void sendStatusLine(){
        String line = "HTTP/1.1 200 OK";
        println(line);
    }
    /*
    发送响应头
     */
    private void sendHeaders(){
        String line = "Content-Type:text/html";
    }
    /*
    发送响应正文
     */
    private void sendContext(){


    }
    /*
    向客户端发送一串字符，以CRLF结尾
     */
    private void println(String line){
        try {
            outputStream.write(line.getBytes("ISO8859-1"));
            outputStream.write(13);
            outputStream.write(10);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
