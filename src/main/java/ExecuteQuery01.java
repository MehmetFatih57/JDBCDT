import java.sql.*;

public class ExecuteQuery01 {

        public static void main(String[] args) throws SQLException {

            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
            Statement statement = connection.createStatement();


            //1. Örnek:  region_id'si 1 olan "country_name" değerlerini çağırın.;
            String sql1 = "SELECT country_name FROM countries WHERE region_id = 1";
            boolean r1 = statement.execute(sql1);
            System.out.println("r1 = " + r1);//true ==> DQL ile data çağırıyoruz

            //Datayı çağırıp okumak için executeQuery methodunu kullanmalıyız. execute() methodu sadece tru yada false döner
            ResultSet resultSet = statement.executeQuery(sql1);

            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
            }

            //2. örnek: "region_id si 2 den buyuk oldugu "country_id" ve "county_name" degerini çağırın.

            System.out.println("************2. örnek****************");

            ResultSet resulset = statement.executeQuery("select country_id,country_name from countries where region_id>2 ;");
            //resulset.next();
            //System.out.println(resulset.getString(1));

            while (resulset.next()) {
                System.out.println(resulset.getString(1) + "--" + resulset.getString(2));

            }

            resulset.next();



            //3.Örnek: "number_of_employees" değeri en düşük olan satırın tüm değerlerini çağırın.

            System.out.println("**********3. örnek ************");

            ResultSet resultSet2= statement.executeQuery("select * from companies where number_of_employees= (select min(number_of_employees) from companies);");

            while (resultSet2.next()) {
                System.out.println(resultSet2.getObject(1) + "--" + resultSet2.getObject(2) + "--" + resultSet2.getObject(3));//tum değerleri alabiliriz
            }

            connection.close();
            statement.close();


        }

    }

