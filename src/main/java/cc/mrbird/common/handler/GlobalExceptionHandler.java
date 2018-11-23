package cc.mrbird.common.handler;

import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.common.exception.FileDownloadException;
import cc.mrbird.common.exception.LimitAccessException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.session.ExpiredSessionException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AuthorizationException.class)
    public Object handleAuthorizationException(HttpServletRequest request) {
        if (isAjaxRequest(request)) {
            return ResponseBo.error("暂无权限，请联系管理员！");
        } else {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("error/403");
            return mav;
        }
    }

    @ExceptionHandler(value = ExpiredSessionException.class)
    public String handleExpiredSessionException() {
        return "login";
    }

    @ExceptionHandler(value = LimitAccessException.class)
    public ResponseBo handleLimitAccessException(LimitAccessException e) {
        return ResponseBo.error(e.getMessage());
    }

    @ExceptionHandler(value = FileDownloadException.class)
    public ResponseBo handleFileDownloadException(FileDownloadException e) {
        return ResponseBo.error(e.getMessage());
    }

    private static boolean isAjaxRequest(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null
                && "XMLHttpRequest".equals(request.getHeader("X-Requested-With")));
    }

}
