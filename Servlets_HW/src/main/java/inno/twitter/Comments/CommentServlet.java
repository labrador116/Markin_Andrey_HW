package inno.twitter.Comments;

import inno.twitter.Tweet;
import inno.twitter.TweetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/comment")
public class CommentServlet extends HttpServlet {
    private CommentService commentService;
    private TweetService tweetService;

    @Override
    public void init() throws ServletException {
        commentService=CommentService.getCommentService();
        tweetService = TweetService.getTweetService();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int id = Integer.parseInt(req.getParameter("id"));

        Tweet myTweet = tweetService.getById(id);
        req.setAttribute("message",myTweet.getMessage());
        List<Comment> comments=commentService.getAllComments(id);
        req.setAttribute("comments",comments);
        req.setAttribute("id",id);
        req.getRequestDispatcher("/TweetComment.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String comment=req.getParameter("comm");
        commentService.addComment(comment,id);
        resp.sendRedirect("/comment?id="+id);
    }


}
