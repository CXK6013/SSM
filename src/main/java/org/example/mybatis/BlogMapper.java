package org.example.mybatis;

import org.apache.ibatis.annotations.Param;
import org.example.mvc.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author XingKe
 * @date 2021-03-08 10:37
 */

public interface BlogMapper {
    /**
     * 参数是多个
     *
     * @param id
     * @param name
     * @return
     */
    Blog selectBlog(@Param("id") Long id, @Param("name") String name);

    /**
     * 参数是对象
     *
     * @param blog
     * @return
     */
    Blog selectBlogByObj(Blog blog);

    /**
     * @param params
     * @return
     */
    Blog selectBlogByMap(Map<String, Object> params);

    /**
     * @param idList
     * @return
     */
    List<Blog> selectBlogByList(List<Long> idList);

    /**
     * @param idLongArray
     * @return
     */
    List<Blog> selectBlogByArray(Long[] idLongArray);


    List<Map<String, Object>> selectAllReturnMap();

    /**
     * 测试井号站位符和$占位符的不同
     *
     * @return
     */
    List<Blog> selectByMark(@Param("id") String id,@Param("name") String name);

    /**
     * 测试井号站位符和$占位符的不同
     *
     * @return
     */
    List<Blog>  selectByDollar(@Param("id") String id, @Param("name") String name);

    Long insertEntity(Blog blog);

    List<Blog>  testChoose(Blog blog);
}
