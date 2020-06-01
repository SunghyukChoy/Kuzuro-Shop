package my.likeaglow.kuzuroshop.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import my.likeaglow.kuzuroshop.domain.CategoryVO;
import my.likeaglow.kuzuroshop.domain.GoodsVO;
import my.likeaglow.kuzuroshop.domain.GoodsViewVO;

@Repository
public class AdminDAOImpl implements AdminDAO {

    @Inject
    private SqlSession sql;

    // 매퍼
    private static String namespace = "my.likeaglow.kuzuroshop.mappers.adminMapper";

    // 카페고리
    @Override
    public List<CategoryVO> category() throws Exception {

        return sql.selectList(namespace + ".category");
    }

    // 상품등록
    @Override
    public void register(GoodsVO vo) throws Exception {

        sql.insert(namespace + ".register", vo);
    }

    // 상품목록
    @Override
    public List<GoodsVO> goodslist() throws Exception {

        return sql.selectList(namespace + ".goodslist");
    }

    // 상품조회 + 카테고리 조인
    @Override
    public GoodsViewVO goodsView(int gdsNum) throws Exception {

        return sql.selectOne(namespace + ".goodsView", gdsNum);
    }

    // 상품 수정
    @Override
    public void goodsModify(GoodsVO vo) throws Exception {

        sql.update(namespace + ".goodsModify", vo);
    }

    // 상품 삭제
    @Override
    public void goodsDelete(int gdsNum) throws Exception {

        sql.delete(namespace + ".goodsDelete", gdsNum);
    }
}