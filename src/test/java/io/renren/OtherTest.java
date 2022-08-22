package io.renren;

import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author:hujiehuan
 * @Date:2022/3/26 10:11
 * @Version:1.0
 */
@SpringBootTest
public class OtherTest {
    public static void main(String[] args) {
        m(9);
    }
//    测试递归调用
    public static void m(int i){
        if (i == 1) {
            System.out.println("1*1=1 ");
        } else {
            m(i - 1);
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + j * i + " ");
            }
            System.out.println();
        }
    }

}
