package my.likeaglow.kuzuroshop.persistence;

import my.likeaglow.kuzuroshop.domain.LoginVO;
import my.likeaglow.kuzuroshop.domain.MemberVO;

public interface MemberDAO {

    // 회원 가입
    public void signup(MemberVO vo) throws Exception;

    // 로그인
    public MemberVO signin(LoginVO vo) throws Exception;
}
