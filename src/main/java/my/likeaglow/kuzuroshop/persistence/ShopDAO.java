package my.likeaglow.kuzuroshop.persistence;

import java.util.List;

import my.likeaglow.kuzuroshop.domain.GoodsViewVO;

public interface ShopDAO {

    // 카테고리별 상품 리스트 : 1차 분류
    public List<GoodsViewVO> list(int cateCode, int cateCodeRef) throws Exception;

    // 카테고리별 상품 리스트 : 2차 분류
    public List<GoodsViewVO> list(int cateCode) throws Exception;

    // 상품 조히
    public GoodsViewVO goodsView(int gdsNum) throws Exception;
}
