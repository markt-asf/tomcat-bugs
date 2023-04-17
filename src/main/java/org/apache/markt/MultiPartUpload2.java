package org.apache.markt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/upload2")
@MultipartConfig()
public class MultiPartUpload2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter pw = resp.getWriter();

        pw.print("<html>");
        pw.print("<body>");
        pw.print("<form method=\"POST\" enctype=\"multipart/form-data\">");
        pw.print("<p><input name=\"source\" type=\"file\" /></p>");
        pw.print("<p><input name=\"Submit\" type=\"submit\" /></p>");
        pw.print("</form>");
        pw.print("</body>");
        pw.print("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Count the parts and bytes
        long partCount = 0;

        Collection<Part> parts = req.getParts();
        for (Part p : parts) {
            partCount++;
            p.delete();
        }

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter pw = resp.getWriter();

        pw.print("<html>");
        pw.print("<body>");
        pw.print("<p>There were [" + partCount + "] part(s).");
        pw.print("</body>");
        pw.print("</html>");
    }
}
