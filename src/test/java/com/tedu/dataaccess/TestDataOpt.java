package com.tedu.dataaccess;

import com.tedu.dataaccess.entity.Category;
import com.tedu.dataaccess.entity.User;
import com.tedu.dataaccess.mapper.CategoryMapper;
import com.tedu.dataaccess.mapper.UserMapper;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author chenjl
 * @date 2022/5/5
 * @desc TODO
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDataOpt {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    
    @Test
    public void testInsert() {
        User user=new User();
        user.setUsername("aaaa");
        user.setPassword("1111");
        user.setUserImg("img/default.png");
        user.setUserRegtime(new Date());
        user.setUserModtime(new Date());
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void addData(){
        Category category = new Category(0,"测试类别3",1,0,"03.png","xixi","aaa.jpg","black");
        //int i = categoryMapper.insert(category);
        int i = categoryMapper.insertUseGeneratedKeys(category);
        System.out.println(category.getCategoryId());
        assertEquals(1,i);
    }
    
    @Test
    public void update(){
        Category category = new Category(48,"测试类别4",1,0,"04.png","heihei","aaa.jpg","black");
        int i = categoryMapper.updateByPrimaryKey(category);
        // 根据自定义条件修改，Example example就是封装条件的
        // int i1 = categoryDAO.updateByExample( Example example);
        assertEquals(1,i);
    }
    
    @Test
    public void delete(){
        int i = categoryMapper.deleteByPrimaryKey(48);
        // 根据条件删除
        //int i1 = categoryDAO.deleteByExample(Example example);
        assertEquals(1,i);

    }

    /**
     * 查询所有
     */
    @Test
    public void queryAll(){
        //查询所有
        List<Category> categories = categoryMapper.selectAll();
        for (Category category: categories) {
            System.out.println(category);
        }
    }

    /**
     * 根据主键查询
     */
    public void acoordingKey(){
        //条件查询
        //1.创建一个Example封装 类别Category查询条件
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("categoryLevel",1);
        criteria.orLike("categoryName","%干%");

        List<Category> categories = categoryMapper.selectByExample(example);
        for (Category category: categories) {
            System.out.println(category);
        }
    }

    /**
     * 根据条件查询
     */
    public void selectByCondition(){
        //条件查询
        //1.创建一个Example封装 类别Category查询条件
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("categoryLevel",1);
        criteria.orLike("categoryName","%干%");

        List<Category> categories = categoryMapper.selectByExample(example);
        for (Category category: categories) {
            System.out.println(category);
        }
    }

    /**
     * 分页查询
     */
    public void pageHelperSelect(){
        //分页查询
        int pageNum = 2;
        int pageSize = 10;
        int start = (pageNum-1)*pageSize;

        RowBounds rowBounds = new RowBounds(start,pageSize);
        List<Category> categories = categoryMapper.selectByRowBounds(new Category(), rowBounds);
        for (Category category: categories) {
            System.out.println(category);
        }

        //查询总记录数
        int i = categoryMapper.selectCount(new Category());
        System.out.println(i);

    }

    /**
     * 带条件分页查询
     */
    public void selectPageByCondition() {
        //带条件分页
        //条件
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("categoryLevel",1);
        //分页
        int pageNum = 2;
        int pageSize = 3;
        int start = (pageNum-1)*pageSize;
        RowBounds rowBounds = new RowBounds(start,pageSize);

        List<Category> categories = categoryMapper.selectByExampleAndRowBounds(example,rowBounds);
        for (Category category: categories) {
            System.out.println(category);
        }

        //查询总记录数（满足条件）
        int i = categoryMapper.selectCountByExample(example);
        System.out.println(i);

    }

    @Test
    public void testResult(){
        System.out.println("aaaa");
    }
    
    
}
