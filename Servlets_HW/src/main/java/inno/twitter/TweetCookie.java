package inno.twitter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrey_pers on 12.11.2016.
 */

public class TweetCookie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("select")!=null){
            String selectedColour = req.getParameter("select");
            Cookie cookie = new Cookie("colour",selectedColour);
            cookie.setMaxAge(10);
        }
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getValue()!=null) {
                req.setAttribute("colour", cookie.getValue());
            }else{
                req.setAttribute("colour", "white");
            }
        }

    }
}
