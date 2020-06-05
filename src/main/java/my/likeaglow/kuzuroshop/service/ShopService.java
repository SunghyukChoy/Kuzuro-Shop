package my.likeaglow.kuzuroshop.service;

import java.util.List;

import my.likeaglow.kuzuroshop.domain.GoodsViewVO;
import my.likeaglow.kuzuroshop.domain.ReplyListVO;
import my.likeaglow.kuzuroshop.domain.ReplyVO;

public interface ShopService {

    // 카테고리별 상품 리스트
    public List<GoodsViewVO> list(int cateCode, int level) throws Exception;

    // 상품 조회
    public GoodsViewVO goodsView(int gdsNum) throws Exception;

    // 삼품 소감(댓글) 작성
    public void registReply(ReplyVO reply) throws Exception;

    // 상품 소감(댓글) 리스트
    public List<ReplyListVO> replyList(int gdsNum) throws Exception;

    // 상품 소감(댓글) 삭제
    public void deleteReply(ReplyVO reply) throws Exception;

    // 아이디 체크
    public String idCheck(int repNum) throws Exception;
}
