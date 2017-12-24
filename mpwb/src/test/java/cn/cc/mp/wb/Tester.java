package cn.cc.mp.wb;


import cn.cc.mp.wb.MpWbApplication;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 单元测试继承该类即可
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MpWbApplication.class)
@Transactional
@Rollback
public abstract class Tester {
    
    public static Logger log = LoggerFactory.getLogger(Tester.class);
}



