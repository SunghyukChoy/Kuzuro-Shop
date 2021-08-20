package my.likeaglow.kuzuroshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.likeaglow.kuzuroshop.domain.CategoryVO;
import my.likeaglow.kuzuroshop.domain.GoodsVO;
import my.likeaglow.kuzuroshop.domain.GoodsViewVO;
import my.likeaglow.kuzuroshop.domain.OrderListVO;
import my.likeaglow.kuzuroshop.domain.OrderVO;
import my.likeaglow.kuzuroshop.domain.ReplyListVO;
import my.likeaglow.kuzuroshop.persistence.AdminRepository;

@Service
public class AdminServiceJPAImpl implements AdminService {

  @Autowired
  AdminRepository adminRepository;

  @Override
  public List<CategoryVO> category() throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void register(GoodsVO vo) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public List<GoodsViewVO> goodslist() throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public GoodsViewVO goodsView(int gdsNum) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void goodsModify(GoodsVO vo) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void goodsDelete(int gdsNum) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public List<OrderVO> orderList() throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<OrderListVO> orderView(OrderVO order) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void delivery(OrderVO order) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void changeStock(GoodsVO goods) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public List<ReplyListVO> allReply() throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void deleteReply(int repNum) throws Exception {
    // TODO Auto-generated method stub

  }

}
