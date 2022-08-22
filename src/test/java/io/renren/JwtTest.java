package io.renren;

import io.renren.modules.app.utils.JwtUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtTest {
    @Autowired
    private JwtUtils jwtUtils;

    @Test
    public void test() {
        String token = jwtUtils.generateToken(3);

        System.out.println(token);
    }

    @Test
    public void TimeTest(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
        String dates = format.format(date);
        System.out.println(dates);
    }

    @Test
    public void TimeTest2(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
        String dates = format.format(date);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -1);
        System.out.println("date1"+dates);
        System.out.println("date2"+format.format(calendar.getTime()));
    }

    @Test
    public void TimeTest3(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(format.format(date));
    }

    @Test
    public void JdbcTest(){
        System.out.println("\uD83C\uDFB5".length());
        System.out.println("\uD83C\uDFB5");
        int i =1;
        Integer j =1;
        System.out.println(i == j);
    }

    @Test
    public void TimeTest04(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        System.out.println(calendar.getTime());
    }
    @Test
    public void TimeTest05() throws ParseException {
        String date1 = "2022-03-08 23:08:00";
        String date2 = "2022-03-07 23:08:00";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (format.parse(date1).compareTo(format.parse(date2))<0){
            System.out.println(date1);
        }else {
            System.out.println(date2);
        }
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
