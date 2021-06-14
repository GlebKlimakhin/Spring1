package com.geekbrains.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(ProductServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Log: GET");
        List<Product> productsList = new ArrayList<>();
                productsList.add(new Product((int) (Math.random() * 32), "soap", 100));
                        productsList.add(new Product((int) (Math.random() * 32), "plate", (int) (Math.random() * 200)));
                        productsList.add(new Product((int) (Math.random() * 32), "fork", (int) (Math.random() * 300)));
        resp.getWriter().printf("<html><body>");
        for (int i = 0; i < productsList.size(); i++) {
            resp.getWriter().printf("<h1>" +"new Product -> "+ productsList.get(i) + "</h1>" + '\'');
        }
        resp.getWriter().printf("</body></html>");
    }
}
