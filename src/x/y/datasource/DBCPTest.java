package x.y.datasource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBCPTest {
    @Test
    public void testDBCP01(){

        try {
            //1、创建数据源
            BasicDataSource dataSource=new BasicDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/bank");
            dataSource.setUsername("root");
            dataSource.setPassword("root");
            Connection connection=dataSource.getConnection();
            System.out.println(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDBCP02(){
        try {
            Properties properties=new Properties();
            InputStream is=DBCPTest.class.getClassLoader().getResourceAsStream("dbcp.properties");
            properties.load(is);
            BasicDataSource dataSource=BasicDataSourceFactory.createDataSource(properties);
            Connection connection=dataSource.getConnection();
            System.out.println(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
