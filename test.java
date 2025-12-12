import java.io.IOException;
import java.nert com.sun.net.httpserver.*;
public class test{
    public static void main(String args[]) throws Exception {
        System.err.println("hi");
        HttpServer server = HttpServer.create(new InetSocketAddress("0.0.0.0",8000), 0);
        server.createContext("/", new HttpHandler() {
            public void handle(HttpExchange exchange) throws IOE
}