import io.qameta.allure.Feature;
import io.qameta.allure.Stories;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.*;

/**
 *
 */
public class demo1TestCase{
    @Feature("demo例子ceshi")
    @Test
    @Story("Base support for bdd annotations")
        public void testcase1(){
           Assert.assertTrue(true);
           System.out.println("testcase1");
        }
        @Test
        public void testcase2(){
           Assert.assertTrue(true);
           System.out.println("testcase2");
        }

}