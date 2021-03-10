package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mvc.entity.Blog;
import org.example.mybatis.BlogMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XingKe
 * @date 2021-03-06 22:05
 */
public class Test {


    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-MVC.xml");
        BlogMapper blogMapper = applicationContext.getBean(BlogMapper.class);
        System.out.println(blogMapper.selectAllReturnMap());
    }

    private static void testChoose() throws IOException {
        BlogMapper blogMapper = getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setName("aaa");
        System.out.println(blogMapper.testChoose(blog));
    }

    private static void insertEntity() throws IOException {
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建一个SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 开启一个会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setName("aaa");
        blogMapper.insertEntity(blog);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(blog);
    }

    private static void markVsDollar() throws IOException {
        BlogMapper blogMapper = getMapper(BlogMapper.class);
        blogMapper.selectByMark("1", "张三");
    }

    private static void selectAllReturnMap() throws IOException {
        BlogMapper blogMapper = getMapper(BlogMapper.class);
        System.out.println(blogMapper.selectAllReturnMap());
    }

    private static void selectBlogByArray() throws IOException {
        BlogMapper blogMapper = getMapper(BlogMapper.class);
        Long[] idArray = new Long[2];
        idArray[0] = 1L;
        idArray[1] = 2L;
        System.out.println(blogMapper.selectBlogByArray(idArray));
    }

    private static void selectBlogByCollection() throws IOException {
        BlogMapper blogMapper = getMapper(BlogMapper.class);
        List<Long> idLongList = new ArrayList<>();
        idLongList.add(1L);
        System.out.println(blogMapper.selectBlogByList(idLongList));
    }

    private static void selectByMap() throws IOException {
        BlogMapper blogMapper = getMapper(BlogMapper.class);
        Map<String, Object> params = new HashMap<>();
        params.put("id", "1");
        Blog blog = blogMapper.selectBlogByMap(params);
        System.out.println(blog);
    }

    private static void selectByObj() throws IOException {
        BlogMapper blogMapper = getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(1L);
        blog.setName("aa");
        blog = blogMapper.selectBlogByObj(blog);
        System.out.println(blog);
    }

    public static <T> T getMapper(Class<T> t) throws IOException {
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建一个SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 开启一个会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return (T) sqlSession.getMapper(t);
    }

    private static void selectMapperMultipleParams() throws IOException {
        BlogMapper blogMapper = getMapper(BlogMapper.class);
        Blog blog = blogMapper.selectBlog(1L, null);
        System.out.println(blog);
    }

}
