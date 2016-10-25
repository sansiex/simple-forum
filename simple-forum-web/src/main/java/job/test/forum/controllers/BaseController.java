package job.test.forum.controllers;

import job.test.forum.dto.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zuhai.jiang on 2016/1/5.
 */
public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
    }

    protected <T> Response<T> suc(T value){
        Response<T> resp = new Response<T>(value);
        return resp;
    }

    protected Response err(int code, String msg){
        Response resp = new Response();
        resp.setSuccess(false);
        resp.setResultMessage(msg);
        resp.setResultCode(code);
        return resp;
    }

    protected Response err(int code, String s, Object... args){
        String msg = String.format(s, args);
        return err(code, msg);
    }

    protected Response err(String s, Object... args){
        String msg = String.format(s, args);
        Response resp = new Response();
        resp.setSuccess(false);
        resp.setResultMessage(msg);
        return resp;
    }

}
