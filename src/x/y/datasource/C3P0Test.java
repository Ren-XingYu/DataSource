package x.y.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Test {
    @Test
    public void c3p0Test01(){

        try {
            ComboPooledDataSource cpds = new ComboPooledDataSource();
            cpds.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver
            cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/bank" );
            cpds.setUser("root");
            cpds.setPassword("root");
            Connection connection=cpds.getConnection();
            System.out.println(connection);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void c3p0Test02(){
        try {
            ComboPooledDataSource cpds = new ComboPooledDataSource();
            Connection connection=cpds.getConnection();
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
