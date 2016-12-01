package inno.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLDataException;

@Controller
public class ErrorsController {

    @RequestMapping("/errorTest")
    public String errorTest() throws SQLDataException {
        if (true) {
            throw new SQLDataException("test");
        }
        return "redirect:/posts";
    }

    @RequestMapping(value = "/error**", method = RequestMethod.GET)
    public String Error() {
        return "errors/error";
    }
    @ExceptionHandler(SQLDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String errorHandler() {
        return "errors/test";
    }

}

