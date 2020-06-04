package my.likeaglow.kuzuroshop.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import my.likeaglow.kuzuroshop.domain.GoodsViewVO;
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
}