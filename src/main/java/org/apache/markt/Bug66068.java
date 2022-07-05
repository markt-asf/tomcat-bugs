package org.apache.markt;

import java.io.IOException;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = true, urlPatterns = { "/Bug66068" })
public class Bug66068 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        log("Request ip before async start: " + request.getRemoteAddr());

        final AsyncContext asyncContext = request.startAsync( request, response );
        log("Request ip after async started: " + asyncContext.getRequest().getRemoteAddr());

        new Thread( new Runnable(){
            @Override
            public void run(){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                log("Request ip after async started: " + asyncContext.getRequest().getRemoteAddr());
                asyncContext.complete();
            }
        } ).start();
    }
}
