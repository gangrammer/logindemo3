package service;


import mapper.BrandMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Brand;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class service1 {
    public static SqlSession sqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }

    public List<Brand> selectAll() throws IOException {
        //创建mapper的步骤
        // 1 加载 mybatis-config.xml文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        sqlSession.commit();
        sqlSession.close();
        return brands;
    }

    public void add(Brand brand) {
        try {
            SqlSession sqlSession = sqlSession();
            BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
            mapper.add(brand);
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Brand selectbyid(int id) {
        Brand brand1 = new Brand();
        try {
            SqlSession sqlSession = sqlSession();
            BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
            brand1 = mapper.selectbyid(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return brand1;
    }

    public void update(Brand brand) {
        try {
            SqlSession sqlSession = sqlSession();
            BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
            mapper.upate(brand);
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(Brand brand){
        try {
            SqlSession sqlSession = sqlSession();
            BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
            mapper.delete(brand);
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }


