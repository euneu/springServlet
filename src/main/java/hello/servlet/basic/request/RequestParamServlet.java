package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start");

        req.getParameterNames().asIterator()
                        .forEachRemaining(name -> System.out.println(name + "=" + req.getParameter(name)));

        System.out.println("[전체 파라미터 조회] - end");

        System.out.println("[단일 파라미터 조회] - start");
        String name = req.getParameter("username");
        System.out.println("name = " + name);
        String age = req.getParameter("age");
        System.out.println("age = " + age);

        System.out.println("[단일 파라미터 조회] - end");

        System.out.println("[이름이 같은 복수 파라미터 조회] - start");
        String[] names = req.getParameterValues("username");
        for (String s : names) {
            System.out.println("name = " + s);
        }
        System.out.println("[이름이 같은 복수 파라미터 조회] - end");


        resp.getWriter().write("ok");
    }
}
