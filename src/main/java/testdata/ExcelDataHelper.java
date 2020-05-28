package testdata;

import org.testng.annotations.DataProvider;
import util.CommonUtil;
import util.ReadExcelUtil;

import java.util.List;
import java.util.Map;

public class ExcelDataHelper {
    @DataProvider
    public Object[][] dataMethod(){
        List<Map<String, String>> result = ReadExcelUtil.getExcuteList(CommonUtil.getProjectPath()+"testdata/demodata.xlsx");
        Object[][] files = new Object[result.size()][];
        for(int i=0; i<result.size(); i++){
            files[i] = new Object[]{result.get(i)};
        }
        return files;
    }

}
