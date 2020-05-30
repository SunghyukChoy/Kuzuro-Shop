package my.likeaglow.kuzuroshop.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import my.likeaglow.kuzuroshop.domain.CategoryVO;

@Repository
public class AdminDAOImpl implements AdminDAO {

    @Inject
    private SqlSession sql;

    // 매퍼
    private static String namespace = "my.likeaglow.kuzuroshop.mappers.adminMapper";

    @Override
    public List<CategoryVO> category() throws Exception {

        return sql.selectList(namespace + ".category");
    }

}
