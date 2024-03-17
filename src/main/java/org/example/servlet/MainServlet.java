package org.example.servlet;

import org.example.controller.PostController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {

    private static final String PATH_API_POST = "/api/posts";
    private static final String PATH_API_POST_D = "/api/posts/\\d+";
    private static final String SLASH = "/";
    private static final String GET = "GET";
    private static final String POST = "POST";
    private static final String DELETE = "DELETE";
    private PostController controller;

    @Override
    public void init() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        controller = context.getBean(PostController.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        // если деплоились в root context, то достаточно этого
        try {
            final String path = req.getRequestURI();
            final String method = req.getMethod();
            // primitive routing
            if (method.equals(GET) && path.equals(PATH_API_POST)) {
                controller.all(resp);
                return;
            }
            if (method.equals(GET) && path.matches(PATH_API_POST_D)) {
                // easy way
                final long id = parseId(path);
                controller.getById(id, resp);
                return;
            }
            if (method.equals(POST) && path.equals(PATH_API_POST)) {
                controller.save(req.getReader(), resp);
                return;
            }
            if (method.equals(DELETE) && path.matches(PATH_API_POST_D)) {
                // easy way
                final long id = parseId(path);
                controller.removeById(id, resp);
                return;
            }
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    private long parseId(String path) {
        return Long.parseLong(path.substring(path.lastIndexOf(SLASH)));
    }
}
