package my.likeaglow.kuzuroshop.service;

import javax.servlet.http.HttpSession;

import my.likeaglow.kuzuroshop.domain.LoginVO;
import my.likeaglow.kuzuroshop.domain.MemberVO;

public interface MemberService {

    // 회원 가입
    public void signup(MemberVO vo) throws Exception;

    // 로그인
    public MemberVO signin(LoginVO vo) throws Exception;

    // 로그아웃
    public void signout(HttpSession session) throws Exception;
}
