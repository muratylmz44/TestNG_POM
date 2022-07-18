package Tests.day15;

import Utilities.ConfigReader;
import Utilities.Driver;
import org.testng.annotations.Test;

public class C01_DriverClassKullanımı {



    @Test
    public void test(){

        Driver.getDriver().get(ConfigReader.getProperty("AmazonUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("FacebookUrl"));


        Driver.closeDriver();

    }
}
