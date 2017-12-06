import org.testng.annotations.Test;
import org.testng.*;


/**
 *
 */


public class GetDateDemoTestCase extends TestBase{

    @Test(dataProvider = "dataProviderName")
    public void getDate(final String caseNo,
                          final String description, final String host){
        System.out.println(caseNo);
        System.out.println(description);
        System.out.println(host);

        Assert.assertTrue(true);


    }

    @Test
    public void testcase2(){
        Assert.assertTrue(true);
        System.out.println("testcase2");
    }
}