package my.likeaglow.kuzuroshop.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import my.likeaglow.kuzuroshop.domain.GoodsViewVO;
import my.likeaglow.kuzuroshop.domain.ReplyListVO;
import my.likeaglow.kuzuroshop.domain.ReplyVO;

@Repository
public class ShopDAOImpl implements ShopDAO {

    @Inject
    private SqlSession sql;

    // 매퍼
    private static String namespace = "my.likeaglow.kuzuroshop.mappers.shopMapper";

    // 카테고리별 상품 리스트 : 1차 분류
    @Override
    public List<GoodsViewVO> list(int cateCode, int cateCodeRef) throws Exception {

        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("cateCode", cateCode); // cateCode를 매개변수로 받아온 뒤 해시맵을 이용해 두 값을 하나의 맵으로 합침
        map.put("cateCodeRef", cateCodeRef); // cateCodeRef를 매개변수로 받아온 뒤 해시맵을 이용해 두 값을 하나의 맵으로 합침

        return sql.selectList(namespace + ".list_1", map); // 두 값을 하나의 맵으로 합쳐 매퍼로 보냄
    }

    // 카테고리별 상품 리스트 : 2차 분류
    @Override
    public List<GoodsViewVO> list(int cateCode) throws Exception {

        return sql.selectList(namespace + ".list_2", cateCode);
    }

    // 상품 조회
    @Override
    public GoodsViewVO goodsView(int gdsNum) throws Exception {

        return sql.selectOne("my.likeaglow.kuzuroshop.mappers.adminMapper" + ".goodsView", gdsNum);
        // adminMapper를 사용하므로 직접 입력해 주었음.
    }

    // 상품 소감(댓글) 작성
    @Override
    public void registReply(ReplyVO reply) throws Exception {

        sql.insert(namespace + ".registReply", reply);
    }

    // 상품 소감(댓글) 리스트
    @Override
    public List<ReplyListVO> replyList(int gdsNum) throws Exception {

        return sql.selectList(namespace + ".replyList", gdsNum);
    }
}