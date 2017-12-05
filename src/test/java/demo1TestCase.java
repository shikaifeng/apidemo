import org.testng.annotations.Test;
import org.testng.*;


public class demo1TestCase{
        @Test
        public void testcase1(){
           Assert.assertTrue(false);
           System.out.println("testcase1");
        }
        @Test
        public void testcase2(){
           Assert.assertTrue(true);
           System.out.println("testcase1");
        }
}