import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class MyTest {

    @Test
    public void medunnaTest() throws SQLException {
        //     User connects to the database
        JdbcUtils.connectToMedunnaDataBase();
        JdbcUtils.createStatement();

        //User sends the query to get the created room
        String sql = "select * from room where room_number =  575757578;";
        ResultSet resultSet = JdbcUtils.executeQuery(sql);

        // Assert that room is created properly
        resultSet.next();
        assertEquals("123.00", resultSet.getString(5));
        assertEquals("", resultSet.getString(6));
        assertEquals("mark_twain", resultSet.getString("created_by"));
    }
}
