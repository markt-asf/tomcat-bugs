package org.apache.markt;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/MultiPartUpload")
@MultipartConfig()
public class MultiPartUpload extends HttpServlet {

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
        long byteCount = 0;

        byte[] buf = new byte[8192];

        Collection<Part> parts = req.getParts();
        for (Part p : parts) {
            partCount++;
            try  {
                InputStream is = p.getInputStream();
                int read = is.read(buf);
                while (read > 0) {
                    byteCount += read;
                    read = is.read(buf);
                }
            } catch (IOException ioe) {

            }
        }

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter pw = resp.getWriter();

        pw.print("<html>");
        pw.print("<body>");
        pw.print("<p>There are [" + byteCount + "] bytes in [" + partCount + "] part(s).");
        pw.print("</body>");
        pw.print("</html>");
    }
}
