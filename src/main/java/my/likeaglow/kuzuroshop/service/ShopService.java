package my.likeaglow.kuzuroshop.service;

import java.util.List;

import my.likeaglow.kuzuroshop.domain.GoodsViewVO;

public interface ShopService {

    // 카테고리별 상품 리스트
    public List<GoodsViewVO> list(int cateCode, int level) throws Exception;
}
