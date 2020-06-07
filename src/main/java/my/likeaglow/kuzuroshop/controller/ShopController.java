package my.likeaglow.kuzuroshop.controller;

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
    public void getCartList(HttpSession session, Model model) throws Exception {
        logger.info("get cart list");

        MemberVO member = (MemberVO) session.getAttribute("member");
        String userId = member.getUserId();

        List<CartListVO> cartList = service.cartList(userId);

        model.addAttribute("cartList", cartList);
    }
}