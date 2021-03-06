package org.apache.tomcat;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Bug57485")
public class Bug57485 extends HttpServlet {

    private static final long serialVersionUID = 1L;


	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("doPost start");
        Enumeration<String> pem = request.getParameterNames();
        while (pem.hasMoreElements()) {
            String k = pem.nextElement();
            String v = request.getParameter(k);
            System.out.println(k + "=" + v);
        }
        System.out.println("doPost end");
    }
}
