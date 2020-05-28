package testdata;

import org.testng.annotations.Test;

import java.util.Map;

public class TestDataUtil extends ExcelDataHelper {


    @Test(dataProvider="dataMethod")
    public void testmethod1(Map<?, ?> param){
        System.out.println(param.get("name")+"\t"+param.get("method")+"\t"+param.get("value"));
    }


}