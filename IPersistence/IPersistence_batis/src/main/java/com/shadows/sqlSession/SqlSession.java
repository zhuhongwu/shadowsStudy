package com.shadows.sqlSession;

import java.sql.SQLException;
import java.util.List;

/**
 * @author zhuhongwu
 * @date 2020/4/26
 */
public interface SqlSession {
    /**
     * 查询所有
     */
    <E> List<E> selectList(String statementId, Object... params) throws Exception;

    <E> E selectOne(String statementId, Object... params) throws Exception;

    <T> T getMapper(Class<?> classType);
}
