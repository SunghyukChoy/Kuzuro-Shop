package my.likeaglow.kuzuroshop.persistence;

import java.util.List;

import my.likeaglow.kuzuroshop.domain.CategoryVO;

public interface AdminDAO {

    // 카테고리
    public List<CategoryVO> category() throws Exception;
}
