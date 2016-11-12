package inno.twitter.Comments;

import java.util.*;


/**
 * Created by Andrey_pers on 10.11.2016.
 */
public class CommentService {
    private static int id;
    private static CommentService service;
    private  Map<Integer,List<Comment>> comments = new HashMap<Integer, List<Comment>>() ;

    private CommentService(){}

    public List<Comment> getAllComments(int id) {
        return comments.get(id);
    }

    public static CommentService getCommentService()
    {
        if(service==null){
            service=new CommentService();
        }
        return service;
    }

    public void addComment(String comment, int id) {
        Comment comm = new Comment();
        comm.setComment(comment);
        comm.setId(this.id++);

        List<Comment> list;
        if(comments.get(id)==null){
            list = new ArrayList<Comment>();
        }else {
            list=comments.get(id);
        }

        list.add(comm);
        comments.put(id,list);
        }
    }







