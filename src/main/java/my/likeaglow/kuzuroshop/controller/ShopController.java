package my.likeaglow.kuzuroshop.controller;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import my.likeaglow.kuzuroshop.domain.CartListVO;
import my.likeaglow.kuzuroshop.domain.CartVO;
import my.likeaglow.kuzuroshop.domain.GoodsViewVO;
import my.likeaglow.kuzuroshop.domain.MemberVO;
import my.likeaglow.kuzuroshop.domain.OrderDetailVO;
import my.likeaglow.kuzuroshop.domain.OrderListVO;
import my.likeaglow.kuzuroshop.domain.OrderVO;
import my.likeaglow.kuzuroshop.domain.ReplyListVO;
import my.likeaglow.kuzuroshop.domain.ReplyVO;
import my.likeaglow.kuzuroshop.service.ShopService;

@Controller
@RequestMapping(value = "/shop/*")
public class ShopController {

  private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

  @Inject
  ShopService service;

  // 카테고리별 상품 리스트
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public void getList(@RequestParam("c") int cateCode, @RequestParam("l") int level, Model model) throws Exception {
    // @RequestParam을 이용, URL에 있는 값을 가져와 변수에 저장하여 사용
    logger.info("get list");

    List<GoodsViewVO> list = null;
    list = service.list(cateCode, level);

    model.addAttribute("list", list);
  }

  // 상품 조회
  @RequestMapping(value = "/view", method = RequestMethod.GET)
  public void getView(@RequestParam("n") int gdsNum, Model model) throws Exception {
    logger.info("get view");

    GoodsViewVO view = service.goodsView(gdsNum);
    model.addAttribute("view", view);

//        List<ReplyListVO> reply = service.replyList(gdsNum);
//        model.addAttribute("reply", reply);
  }

  /*
   * // 상품 조회 - 소감(댓글) 작성
   * 
   * @RequestMapping(value = "/view", method = RequestMethod.POST) public String
   * registReply(ReplyVO reply, HttpSession session) throws Exception { //
   * HttpSession을 이용해 member 세션에 있는 userId를 가져옴. logger.info("regist reply");
   * 
   * MemberVO member = (MemberVO) session.getAttribute("member");
   * reply.setUserId(member.getUserId());
   * 
   * service.registReply(reply);
   * 
   * return "redirect:/shop/view?n=" + reply.getGdsNum(); }
   */

  // 상품 소감(댓글) 작성
  @ResponseBody
  @RequestMapping(value = "/view/registReply", method = RequestMethod.POST)
  public void registReply(ReplyVO reply, HttpSession session) throws Exception {
    logger.info("regist post");

    MemberVO member = (MemberVO) session.getAttribute("member");
    reply.setUserId(member.getUserId());

    service.registReply(reply);
  }

  // 상품 소감(댓글) 목록
  @ResponseBody
  @RequestMapping(value = "/view/replyList", method = RequestMethod.GET)
  public List<ReplyListVO> getReplyList(@RequestParam("n") int gdsNum) throws Exception {
    logger.info("get reply list");

    List<ReplyListVO> reply = service.replyList(gdsNum);

    return reply;
  }

  // 상품 소감(댓글) 삭제
  @ResponseBody
  @RequestMapping(value = "/view/deleteReply", method = RequestMethod.POST)
  public int getReplyList(ReplyVO reply, HttpSession session) throws Exception {
    logger.info("post delete reply");

    int result = 0;

    MemberVO member = (MemberVO) session.getAttribute("member"); // 현재 세션을 가져와 변수 member에 저장
    String userId = service.idCheck(reply.getRepNum()); // 아이디 체크 쿼리의 결과를 가져와 변수 userId에 저장

    if (member.getUserId().equals(userId)) { // 변수 member에서 userId를 가져오고 위의 userId와 비교
      reply.setUserId(member.getUserId());
      service.deleteReply(reply); // 삭제 실행

      result = 1; // 아이디 삭제 후 result에 1 저장
    }

    return result;
  }

  // 상품 소감(댓글) 수정
  @ResponseBody
  @RequestMapping(value = "/view/modifyReply", method = RequestMethod.POST)
  public int modifyReply(ReplyVO reply, HttpSession session) throws Exception {
    logger.info("modify reply");

    int result = 0;

    MemberVO member = (MemberVO) session.getAttribute("member");
    String userId = service.idCheck(reply.getRepNum());

    if (member.getUserId().equals(userId)) {

      reply.setUserId(member.getUserId());
      service.modifyReply(reply);
      result = 1;
    }

    return result;
  }

  // 카트 담기
  @ResponseBody
  @RequestMapping(value = "/view/addCart", method = RequestMethod.POST)
  public int addCart(CartVO cart, HttpSession session) throws Exception {

    int result = 0;

    MemberVO member = (MemberVO) session.getAttribute("member");

    if (member != null) {
      cart.setUserId(member.getUserId());
      service.addCart(cart);
      result = 1;
    }
    return result;
  }

  // 카트 목록
  @RequestMapping(value = "/shop/cartList", method = RequestMethod.GET)
  public String getCartList(HttpSession session, Model model) throws Exception {
    logger.info("get cart list");

    MemberVO member = (MemberVO) session.getAttribute("member");
    String userId = member.getUserId();

    List<CartListVO> cartList = service.cartList(userId);

    model.addAttribute("cartList", cartList);

    return "shop/cartList";
  }

  // 카트 삭제
  @ResponseBody
  @RequestMapping(value = "/deleteCart", method = RequestMethod.POST)
  public int deleteCart(HttpSession session, @RequestParam(value = "chbox[]") List<String> chArr, CartVO cart)
      throws Exception {
    logger.info("delete cart");

    MemberVO member = (MemberVO) session.getAttribute("member");
    String userId = member.getUserId();

    int result = 0;
    int cartNum = 0;

    if (member != null) {
      cart.setUserId(userId);

      for (String i : chArr) {
        cartNum = Integer.parseInt(i);
        cart.setCartNum(cartNum);
        service.deleteCart(cart);
      }
      result = 1;
    }
    return result;
  }

  // 주문
  @RequestMapping(value = "/cartList", method = RequestMethod.POST)
  public String order(HttpSession session, OrderVO order, OrderDetailVO orderDetail) throws Exception {
    logger.info("order");

    MemberVO member = (MemberVO) session.getAttribute("member");
    String userId = member.getUserId();

    Calendar cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR);
    String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
    String ymd = ym + new DecimalFormat("00").format(cal.get(Calendar.DATE));
    String subNum = "";

    for (int i = 1; i <= 6; i++) {
      subNum += (int) (Math.random() * 10);
    }

    String orderId = ymd + "_" + subNum; // 날짜와 랜덤 번호를 이용한 orderId 생성

    order.setOrderId(orderId);
    order.setUserId(userId);

    service.orderInfo(order);

    orderDetail.setOrderId(orderId);
    service.orderInfo_Details(orderDetail);

    service.cartAllDelete(userId); // 주문 후 카트 비우기

    return "redirect:/shop/orderList";
  }

  // 주문 목록
  @RequestMapping(value = "orderList", method = RequestMethod.GET)
  public void getOrderList(HttpSession session, OrderVO order, Model model) throws Exception {
    logger.info("get order list");

    MemberVO member = (MemberVO) session.getAttribute("member");
    String userId = member.getUserId();

    order.setUserId(userId);

    List<OrderVO> orderList = service.orderList(order);

    model.addAttribute("orderList", orderList);
  }

  // 주문 상세 목록
  @RequestMapping(value = "/orderView", method = RequestMethod.GET)
  public void getOrderList(HttpSession session, @RequestParam("n") String orderId, OrderVO order, Model model)
      throws Exception {
    logger.info("get order view");

    MemberVO member = (MemberVO) session.getAttribute("member");
    String userId = member.getUserId();

    order.setUserId(userId);
    order.setOrderId(orderId);

    List<OrderListVO> orderView = service.orderView(order);

    model.addAttribute("orderView", orderView);
  }
}