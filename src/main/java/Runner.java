public class Runner {

    public static void main(String[] args) {
        //Databes'e baglan
        JDBCUtils.connectToDataBase();

        //Statement oluştur
        JDBCUtils.createStatement();

        //Qquery calistir
        String sql = "CREATE TABLE workers (worker_id VARCHAR(20), worker_name VARCHAR(20), worker_salary INT)";
        JDBCUtils.execute(sql);


    }
}


