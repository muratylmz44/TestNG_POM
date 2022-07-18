package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


    // 1---)  Properties objesi oluşturacağız

    static Properties properties;

    //2---)Bu classın amacı configuraion.properties dosyasını  okumak
    // ve oradaki key value ikililerini kullanarak  istediğimiz key e ait value yu bize getirmek


    static {

        String dosyaYolu="configuration.properties";
        try {
            FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
            properties=new Properties();
            properties.load(fileInputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //3---)Test Classlarından ConfigReader Clasına ulasıp yukarıda kı işlemleri yapmamızı sağlayacak bir method
    //oluşturacağız

public static String getProperty(String key){


        String value=properties.getProperty(key);
        return value;



}
}
