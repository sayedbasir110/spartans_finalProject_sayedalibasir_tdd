package tek_insurance.tdd.api.test;

import org.testng.annotations.Test;
import tek_insurance.tdd.base.ApiTestBase;
import tek_insurance.tdd.utility.DataBaseUtility;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoreDataBaseTest extends ApiTestBase {
    @Test
    public void convertResultToMap() throws SQLException {
        DataBaseUtility dataBaseUtility = new DataBaseUtility();
        ResultSet result = dataBaseUtility.executeQuery("select * from primary_person order by id desc limit 5;");
        ResultSetMetaData metaData = result.getMetaData();
        List<Map<String, Object>> AllResult = new ArrayList<>();
        while (result.next()){
            Map<String, Object> row = new HashMap<>();
            for (int col=1; col<= metaData.getColumnCount(); col++){
                row.put(metaData.getColumnName(col), result.getObject(col));
            }
            AllResult.add(row);
        }
        for (int i=0 ; i< AllResult.size(); i++){
            System.out.println(AllResult.get(i));
        }
    }
}
