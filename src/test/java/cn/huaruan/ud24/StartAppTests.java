package cn.huaruan.ud24;

import cn.huaruan.ud24.query.entity.Aaa;
import cn.huaruan.ud24.query.mapper.AaaMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Point;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StartAppTests {


    @Autowired
    AaaMapper aaaMapper;

    @Test
    public void test1() {
        Aaa aaa = new Aaa();
        aaa.setId(1);
        aaa.setPointA(new Point(1,1));
        aaaMapper.insert(aaa);
        System.out.println(1);
//        List<Point> points = AmapUtils.batchGetLocations(s);
//        System.out.println(points);
    }

}
