import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import au.com.bytecode.opencsv.CSVReader;


public class TestBase {

    // 定义csv文件的分割符
    public static char csvSeprator = ',';
    // 定义@DataProvider的name
    public static final String DATA_PROVIDER_NAME = "dataProviderName";
    // 定义测试数据存放的路径
    public static final String DATA_PROVIDER_PACKAGENAME = "/src/test/testdata/";

    /**
     * @DataProvider 从csv文件获取测试数据
     * @return Object[][] 返回一个二维数组，第一维代表行号，第二维代表每行数据
     */
    @SuppressWarnings("resource")
    @DataProvider(name = DATA_PROVIDER_NAME)
    public static Object[][] getCsvData(Method method, ITestContext context)
            throws IOException {
        TestBase mecTestBase = new TestBase();
        // 获取配置文件的class路径
        String retPath =  System.getProperty("user.dir")+DATA_PROVIDER_PACKAGENAME;
        // 获取调用方法的方法名
        String methodName = method.getName();
        // 获取调用方法的类名
        String className = null;
        String[] packageName = method.getDeclaringClass().getName().toString()
                .split("\\.");
        className = packageName[packageName.length - 1];

        // 指定当前类当前方法对应的csv文件retPath
        String csvPath = retPath + className + "." + methodName + ".csv";

        // 从CSV文件中读取数据
        CSVReader reader = new CSVReader(new FileReader(csvPath), csvSeprator);

        // 不读第一行,第一行统一为参数的字段名字
        reader.readNext();

        // csv中每行的数据都是一个string数组
        String[] csvRow = null;
        ArrayList<Object[]> csvList = new ArrayList<Object[]>();
        // 将读取的数据，按行存入到csvList中
        while ((csvRow = reader.readNext()) != null) {
            csvList.add(csvRow);
        }

        // 定义返回值
        Object[][] results = new Object[csvList.size()][];
        // 设置二维数组每行的值，每行是个object对象
        for (int i = 0; i < csvList.size(); i++) {
            results[i] = csvList.get(i);
        }
        return results;
    }

}
