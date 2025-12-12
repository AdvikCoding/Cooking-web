import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class SimpleHttpServerDemo {

    public static void main(String[] args) throws IOException {
        int port = 5501;
        // Create an HttpServer instance binding to localhost and the specified port
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", port), 0);
        
        // Create a context for the "/" path and assign a handler
        server.createContext("/", new MyHandler());
        
        // Use a thread pool for handling requests
        server.setExecutor(Executors.newFixedThreadPool(10));
        
        // Start the server
        server.start();
        
        System.out.println("Server started on port " + port);
        System.out.println("Access the server at http://localhost:" + port + "/");
    }

    // Handler class to process HTTP requests
    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "<h1>Hello from Java HttpServer!</h1>";
            
            // Set response headers and status code (200 OK)
            exchange.sendResponseHeaders(200, response.length());
            
            // Get the response body output stream and write the response
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            
            // Close the output stream to complete the response
            os.close();
        }
    }
}
