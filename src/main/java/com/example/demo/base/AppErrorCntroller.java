package com.example.demo.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @ClassName AppErrorCntroller
 * @Description TODD
 * @Author Administrator
 * @Date 2018/10/30 0030 下午 5:06
 * @Version 1.0
 **/
@Controller
public class AppErrorCntroller implements ErrorController {
    private static final String ERROR_PATH ="/error";

    private ErrorAttributes errorAttributes;
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @Autowired
    public AppErrorCntroller(ErrorAttributes errorAttributes){
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping(value = ERROR_PATH,produces = "text/html")
    public String errorPageHandler(HttpServletRequest httpServletRequest,
                                   HttpServletResponse httpServletResponse){
        int status = httpServletResponse.getStatus();
        switch (status){
            case 403:
                return "403";
            case 404:
                return "404";
            case 500:
                return "500";
        }
        return "index";
    }

    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public ApiResponse errorApiHandle(HttpServletRequest request){
        RequestAttributes requestAttributes=new ServletRequestAttributes(request);
        //Map<String, Object>attr=this.errorAttributes.getErrorAttributes((WebRequest) requestAttributes, false);
        int status=getStatus(request);
        return ApiResponse.ofMessage();
    }

    private int getStatus(HttpServletRequest request){
        Integer status = (Integer) request.getAttribute("javax.servlet,error.status_code");
        if(status != null){
            return status;
        }
        return 500;
    }
}
