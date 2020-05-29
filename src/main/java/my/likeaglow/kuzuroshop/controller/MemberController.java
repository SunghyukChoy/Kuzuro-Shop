package my.likeaglow.kuzuroshop.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import my.likeaglow.kuzuroshop.domain.MemberVO;
import my.likeaglow.kuzuroshop.service.MemberService;

// 매퍼 -> DAO -> Service -> Controller -> JSP 순으로 작업.
@Controller
@RequestMapping("/member")
public class MemberController {

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Inject
    MemberService service;

    @Autowired
    BCryptPasswordEncoder passEncoder;
    // 입력받은 패스워드를 BCrypt로 암호화시키고 다시 MemberVO에 넘겨줌.

    // 회원 가입 get
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public void getSignup() throws Exception {
        logger.info("get signup");
    }

    // 회원 가입 post
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String postSignup(MemberVO vo) throws Exception {
        // form 태그에서 전달 받은 속성값은 매겨변수(MemberVO)의 필드와 매칭됨.
        // form 태그의 name과 name의 값은 매개변수의 필드, 필드값으로 매칭.

        logger.info("post signup");

        String pass = vo.getUserPass();
        String encodedPassword = passEncoder.encode(pass);
        vo.setUserPass(encodedPassword);

        // TODO: 만약에 가입하려는 userId 가 같은게 들어오면 어떻게 하려고?

        service.signup(vo);

        return "redirect:/";
    }

    // 로그인 get
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public void getSignin() throws Exception {
        logger.info("get signin");
    }

    // 로그인 post
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String postSignin(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
        logger.info("post signin");

        MemberVO login = service.signin(vo);
        HttpSession session = req.getSession();

        if (login == null) { // 해당 아이디가 존재하지 않아서 login이 null일 떄
            session.setAttribute("member", null); // 세션값 제거
            rttr.addFlashAttribute("msg", false); // 특정 페이지로 이동될 때 msg의 값(false) 을 부여
            return "redirect:/member/signin"; // 특정 페이지
        }

        // boolean passMatch = passEncoder.matches(vo.getUserPass(),
        // login.getUserPass());
        // 사용자가 입력한 패스워드와 데이터베이스에 저장된 패스워드를 비교해서 동일하면 true, 그렇지 않으면 false 반환.

        if (passEncoder.matches(vo.getUserPass(), login.getUserPass())) { // passMatch가 true일 때
            session.setAttribute("member", login); // 코드 실행
        } else { // 아이디나 패스워드 중 하나라도 틀리면
            session.setAttribute("member", null); // 세션값 제거
            rttr.addFlashAttribute("msgPass", false); // 특정 페이지로 이동될 때 msg의 값(false) 을 부여
            return "redirect:/member/signin"; // 특정 페이지
        }
        return "redirect:/";
    }

    // 로그아웃
    @RequestMapping(value = "/signout", method = RequestMethod.GET)
    public String signout(HttpSession session) throws Exception {
        logger.info("get logout");

        service.signout(session);

        return "redirect:/";
    }
}