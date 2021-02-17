package com.cybage;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class MyCustomView implements View {

    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request,
                       HttpServletResponse response) throws Exception {
        response.setContentType(getContentType());
        PrintWriter writer = response.getWriter();
        writer.println("This is my custom dummy view.<br/>");
        writer.println("<h3>Model attributes</h3>");
        for (Map.Entry<String, ?> entry : model.entrySet()) {
            writer.printf("%s = %s<br/>", entry.getKey(), entry.getValue());
        }
    }
}