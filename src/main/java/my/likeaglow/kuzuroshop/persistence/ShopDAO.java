package my.likeaglow.kuzuroshop.persistence;

import java.util.List;

import my.likeaglow.kuzuroshop.domain.CartListVO;
import my.likeaglow.kuzuroshop.domain.CartVO;
import my.likeaglow.kuzuroshop.domain.GoodsViewVO;
import my.likeaglow.kuzuroshop.domain.ReplyListVO;
import my.likeaglow.kuzuroshop.domain.ReplyVO;

public interface ShopDAO {

    // 카테고리별 상품 리스트 : 1차 분류
    public List<GoodsViewVO> list(int cateCode, int cateCodeRef) throws Exception;

    // 카테고리별 상품 리스트 : 2차 분류
    public List<GoodsViewVO> list(int cateCode) throws Exception;

    // 상품 조히
    public GoodsViewVO goodsView(int gdsNum) throws Exception;

    // 상품 소감(댓글) 작성
    public void registReply(ReplyVO reply) throws Exception;

    // 상품 소감(댓글 ) 리스트
    public List<ReplyListVO> replyList(int gdsNum) throws Exception;

    // 상품 소감(댓글) 삭제
    public void deleteReply(ReplyVO reply) throws Exception;

    // 아이디 체크
    public String idCheck(int repNum) throws Exception;

    // 상품 소감(댓글) 수정
    public void modifyReply(ReplyVO reply) throws Exception;

    // 카트 담기
    public void addCart(CartVO cart) throws Exception;

    // 상품 리스트
    public List<CartListVO> cartList(String userId) throws Exception;

    // 카트 삭제
    public void deleteCart(CartVO cart) throws Exception;
}
