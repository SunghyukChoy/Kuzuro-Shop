package my.likeaglow.kuzuroshop.persistence;

import java.util.List;

import my.likeaglow.kuzuroshop.domain.CategoryVO;
import my.likeaglow.kuzuroshop.domain.GoodsVO;

public interface AdminDAO {

    // 카테고리
    public List<CategoryVO> category() throws Exception;

    // 상품등록
    public void register(GoodsVO vo) throws Exception;
}
