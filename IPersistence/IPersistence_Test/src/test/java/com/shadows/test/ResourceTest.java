package com.shadows.test;

import com.shadows.dao.IUserMapper;
import com.shadows.io.Resource;
import com.shadows.pojo.User;
import com.shadows.sqlSession.SqlSession;
import com.shadows.sqlSession.SqlSessionFactory;
import com.shadows.sqlSession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zhuhongwu
 * @date 2020/4/26
 */
public class ResourceTest {
    @Test
    public void test() throws Exception {
        InputStream resourceAsStream = Resource.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sessionFactory.openSession();

        User user = new User();
        user.setId(1);
        user.setUsername("张三");

        User userRs = sqlSession.selectOne("user.selectOne", user);
        System.out.println(userRs);
    }

    @Test
    public void testMapperClass() throws PropertyVetoException, DocumentException {
        InputStream resourceAsStream = Resource.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession();

        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        List<User> all = mapper.findAll();
        System.out.println(all);



    }



}

