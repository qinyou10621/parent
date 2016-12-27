package testfunction;

import com.dao.Mappers;
import com.pojo.Classes;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestCase {
    ApplicationContext ctx;

    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext("classpath:spring/*.xml");
    }

    @Test
    public void test1() {
        List<Classes> list = new ArrayList<Classes>();
        Mappers mappers = ctx.getBean("mappers", Mappers.class);
        list = mappers.findClassesByName("一班");
        System.out.println(list.size());
        for (Classes classes : list) {
            System.out.println(classes);
        }
    }
}
