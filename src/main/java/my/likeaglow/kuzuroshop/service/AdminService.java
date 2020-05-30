package my.likeaglow.kuzuroshop.service;

import java.util.List;

import my.likeaglow.kuzuroshop.domain.CategoryVO;

public interface AdminService {

    // 카테로기
    public List<CategoryVO> category() throws Exception;
}
