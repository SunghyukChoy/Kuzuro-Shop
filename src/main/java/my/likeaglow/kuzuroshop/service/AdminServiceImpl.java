package my.likeaglow.kuzuroshop.service;

import java.util.List;

import javax.inject.Inject;

import my.likeaglow.kuzuroshop.domain.CategoryVO;
import my.likeaglow.kuzuroshop.domain.GoodsVO;
import my.likeaglow.kuzuroshop.domain.GoodsViewVO;
import my.likeaglow.kuzuroshop.domain.OrderListVO;
import my.likeaglow.kuzuroshop.domain.OrderVO;
import my.likeaglow.kuzuroshop.domain.ReplyListVO;
import my.likeaglow.kuzuroshop.persistence.AdminDAO;

public class AdminServiceImpl implements AdminService {

  @Inject
  private AdminDAO dao;

  // 카테고리
  @Override
  public List<CategoryVO> category() throws Exception {

    return dao.category();
  }

  // 상품등록
  @Override
  public void register(GoodsVO vo) throws Exception {

    dao.register(vo);
  }

  // 상품목록
  @Override
  public List<GoodsViewVO> goodslist() throws Exception {
    System.out.println("서비스");
    return dao.goodslist();
  }

  // 상품조회 + 카테고리 조인
  @Override
  public GoodsViewVO goodsView(int gdsNum) throws Exception {

    return dao.goodsView(gdsNum);
  }

  // 상품 수정
  @Override
  public void goodsModify(GoodsVO vo) throws Exception {

    dao.goodsModify(vo);
  }

  // 상품 삭제
  @Override
  public void goodsDelete(int gdsNum) throws Exception {

    dao.goodsDelete(gdsNum);
  }

  // 주문 목록
  @Override
  public List<OrderVO> orderList() throws Exception {

    return dao.orderList();
  }

  // 특정 주문 목록
  @Override
  public List<OrderListVO> orderView(OrderVO order) throws Exception {

    return dao.orderView(order);
  }

  // 배송 상태
  @Override
  public void delivery(OrderVO order) throws Exception {

    dao.delivery(order);
  }

  // 상품 수량 조절
  @Override
  public void changeStock(GoodsVO goods) throws Exception {

    dao.changeStock(goods);
  }

  // 모든 소감(댓글)
  @Override
  public List<ReplyListVO> allReply() throws Exception {

    return dao.allReply();
  }

  // 소감(댓글) 삭제
  @Override
  public void deleteReply(int repNum) throws Exception {

    dao.deleteReply(repNum);
  }
}