import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewTestt {
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
    public void test() throws SQLException {

        // User connects to the database
        JdbcUtils.connectToMedunnaDataBase();
        JdbcUtils.createStatement();

        // User sends the query to get the created room
        String sql = "SELECT * FROM room WHERE room_number = 8888;";
        ResultSet resultSet = JdbcUtils.executeQuery(sql);

        // Assert that room is created properly
        resultSet.next();
        Assert.assertEquals("777.00" , resultSet.getString("price"));
        Assert.assertEquals("SUITE" , resultSet.getString(3));
        Assert.assertEquals("8888" , resultSet.getString("room_number"));
        Assert.assertEquals("Database Test Icin Olusturuldu" , resultSet.getString(6));
        Assert.assertEquals("2023-05-25 09:13:09.659621" , resultSet.getString("created_date"));
        Assert.assertEquals("mark_twain" , resultSet.getString(8));



    }
}
