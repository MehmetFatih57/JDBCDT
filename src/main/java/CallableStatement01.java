import java.sql.*;

public class CallableStatement01 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Sss230628.");
        Statement statement = connection.createStatement();

        //Selamlama yapan bir function olusturup calistiriniz
        //Callable Statement Adimlari:

        //1.Adim: Function kodunu yaziniz
        String sql = "create or replace function selamlama(x text) returns text as " +
                     "$$ begin return 'Merhaba ' || x || ', nasilsin?'; " +
                     "end; $$ language plpgsql;";

        //2.Adim: Function kodunu calistiriniz
        statement.execute(sql);//Function olusturan query'yi calistirdik

//        String sql2 = "select selamlama('Ayse');"; ==> Burasi Callable Statement kullanmadan function cagirma islemi
//        ResultSet resultSet = statement.executeQuery(sql2);//Function'i parametre ile cagirdik. BIze bir table dondu
//        resultSet.next();
//        System.out.println(resultSet.getObject(1));

//        1. Ornek: Selamlama yapan bir function'i Callable Statement ile cagiriniz
        //3. Adim: Function'i cagir
        CallableStatement callableStatement = connection.prepareCall("{? = call selamlama(?)}");//Callable Statement ile yapma

       //4. Adim: Return icin registerOutParameter() methodunu, parametreler icin setInt() , setString()... methodlarini kullaniniz
        callableStatement.registerOutParameter(1, Types.VARCHAR);
        callableStatement.setString(2, "Fatih");

       //5. Adim: execute() methodu ile callableStatement'i calistir
       callableStatement.execute();

       //6. Adim: Sonucu gormek icin callableStatement'tan data turunu cagiralim
       //callableStatement'ta data resultSet icine alinmaz. Direkt callableStatement'tan alinir
        System.out.println(callableStatement.getString(1));



        //2. Ornek: Iki sayiyi toplayan bir funtion yaziniz ve Callable Statement ile cagiriniz
        //1.Adim: Function kodunu yaziniz
        String sql2 = "create or replace function toplama(x int , y int) \n" +
                "returns numeric as $$ begin return x+y; end; $$ language plpgsql;\n";

        //2.Adim: Function kodunu calistiriniz
        statement.execute(sql2);//Function olusturan query'yi calistirdik

        //3. Adim: Function'i cagir
        CallableStatement callableStatement2 = connection.prepareCall("{? = call toplama(? , ?)}");//Callable Statement ile yapma

        //4. Adim: Return icin registerOutParameter() methodunu, parametreler icin setInt() , setString()... methodlarini kullaniniz
        callableStatement2.registerOutParameter(1, Types.NUMERIC);
        callableStatement2.setInt(2, 6);
        callableStatement2.setInt(3, 4);

        //5. Adim: execute() methodu ile callableStatement'i calistir
        callableStatement2.execute();

        //6. Adim: Sonucu gormek icin callableStatement'tan data turunu cagiralim
        //callableStatement'ta data resultSet icine alinmaz. Direkt callableStatement'tan alinir
        System.out.println(callableStatement2.getBigDecimal(1));


        connection.close();
        statement.close();
    }
}
