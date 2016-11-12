package inno.twitter;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Andrey_pers on 11.11.2016.
 */
@WebServlet(urlPatterns = "/twitter/*")
public class TweetDeleteServlet extends HttpServlet {

    private TweetService service;

    @Override
    public void init() throws ServletException {
        service = TweetService.getTweetService();
        super.init();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tweet> tweets = service.getAll();
        String messageId=req.getParameter("id");
        if(messageId!=null) {
            for (Tweet tweet : tweets) {
                if(tweet.getId()==Long.parseLong(messageId)) {
                    tweets.remove(tweet);
                    break;
                }
            }
            req.setAttribute("tweets", tweets);
            req.getRequestDispatcher("/tweets.jsp").forward(req, resp);
        }
    }
}
