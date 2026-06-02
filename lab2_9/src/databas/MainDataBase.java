package src.databas;

import java.util.Date;

public class MainDataBase {
    public static void main(String[] args) {
        try {
//            Many many1 = new Many(4, (byte)-1, "Автобус", new Date(),46f,  "");
//            Many many2 = new Many(3, (byte)-1, "Троллейбус", new Date(),46f,  "");

            DataBaseUtils dataBaseUtils = new DataBaseUtils();

//            dataBaseUtils.save(many1);
//            dataBaseUtils.save(many2);

//            Many many3 = dataBaseUtils.findById(4);
//            System.out.println(many3);
//
//            dataBaseUtils.deleteById(4);
//
//            many3 = dataBaseUtils.findById(4);
//            System.out.println(many3);

            Many many3 = dataBaseUtils.findById(3);
            System.out.println(many3);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
