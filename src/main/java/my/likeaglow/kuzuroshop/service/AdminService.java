package my.likeaglow.kuzuroshop.service;

import java.util.List;

import my.likeaglow.kuzuroshop.domain.CategoryVO;
import my.likeaglow.kuzuroshop.domain.GoodsVO;

public interface AdminService {

    // 카테로기
    public List<CategoryVO> category() throws Exception;

    // 상품등록
    public void register(GoodsVO vo) throws Exception;

    // 상품목록
    public List<GoodsVO> goodslist() throws Exception;

    // 상품조회
    public GoodsVO goodsView(int gdsNum) throws Exception;
}
