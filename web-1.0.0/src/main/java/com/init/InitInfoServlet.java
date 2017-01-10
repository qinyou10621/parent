package com.init;

        import javax.servlet.ServletConfig;
        import javax.servlet.http.HttpServlet;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
public class InitInfoServlet extends HttpServlet {
    public void init() {
        ServletConfig cfg = getServletConfig();
        System.out.println(cfg.getServletContext().getRealPath(""));
    }
}
