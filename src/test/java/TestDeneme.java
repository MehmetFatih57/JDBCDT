import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class TestDeneme {

    /*
   Given
     User connects to the database
     (Host name: medunna.com, Database name: medunna_db_v2, Username: select_user, Password: Medunna_pass_@6))

   When
     User sends the query to get the created room
     (Kullanıcı, oluşturulan odayı getirmek için sorgu gönderir)

   Then
     Assert that room is created properly
     (Odanın düzgün kaydedildiğini doğrular)

   And
     User closes the connection
  */


    @Test
    public void testDeneme() throws SQLException {

    //User connects to the database
    JdbcUtils.connectToMedunnaDataBase();
    JdbcUtils.createStatement();

    //User sends the query to get the created room
    String sql = "select * from room where room_number = 57575757;";
    ResultSet resultSet = JdbcUtils.executeQuery(sql);

    // Assert that room is created properly
    resultSet.next();
        assertEquals("123.00" , resultSet.getString(5));
        assertEquals("Team07Deneme" , resultSet.getString("description"));
        assertEquals("mark_twain" , resultSet.getString(8));
        assertEquals("2023-05-19 20:55:35.905387"  , resultSet.getString("created_date"));

    }
}
