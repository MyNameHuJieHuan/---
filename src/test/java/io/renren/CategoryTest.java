package io.renren;

import io.renren.modules.bookmanager.controller.CategoryController;
import io.renren.modules.bookmanager.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author:hujiehuan
 * @Date:2022/3/26 12:44
 * @Version:1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryTest {
    @Autowired
    private CategoryController categoryController;

    @Test
    public void Category(){
        String category = "教材教辅考试/教辅/中学教辅/初一";
        categoryController.insertCategory(category);
    }

    @Test
    public void Category02(){
        String category = "TP311.11";
        String [] nums = category.split("");
        for (int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
}
