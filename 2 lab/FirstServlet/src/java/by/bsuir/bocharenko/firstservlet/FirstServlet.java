package by.bsuir.bocharenko.firstservlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/simpleservlet")
public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String req=request.toString();
        Enumeration<String> headerJsp=request.getHeaderNames();
        String header=headerJsp.toString();
        StringBuffer urlJsp=request.getRequestURL();
        String url=urlJsp.toString();
        Map<String,String[]> parametersJsp=request.getParameterMap();
        String paramJsp=parametersJsp.toString();

        request.setAttribute("req", req);
        request.setAttribute("header", header);
        request.setAttribute("requestURL", url);
        request.setAttribute("param", paramJsp);
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
