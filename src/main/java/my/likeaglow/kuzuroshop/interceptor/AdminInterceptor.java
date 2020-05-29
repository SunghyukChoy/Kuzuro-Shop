package my.likeaglow.kuzuroshop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import my.likeaglow.kuzuroshop.domain.MemberVO;

public class AdminInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {

        HttpSession session = req.getSession();
        MemberVO member = (MemberVO) session.getAttribute("member");

        if (member == null) {
            res.sendRedirect("/member/signin");
            return false;
        }

        if (member == null || member.getVerify() != 9) {
            res.sendRedirect("/");
            return false;
        }

        return true;
    }
}
