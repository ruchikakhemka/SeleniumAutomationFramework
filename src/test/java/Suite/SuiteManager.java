package Suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import util.ConfigFileReader;
import util.DriverManager;

public class SuiteManager {
    DriverManager driverManager;
    private static ConfigFileReader configFileReader = new ConfigFileReader();

    @BeforeSuite(alwaysRun = true )
    public void startDriver()
    {
        driverManager = new DriverManager();
    }

    @AfterSuite(alwaysRun = true)
    public void closeDriver()
    {
        DriverManager.driver.quit();
    }

    @BeforeClass
    public void launchUrl()
    {
        DriverManager.driver.manage().window().maximize();
        String baseurl = configFileReader.getProperty("baseurl");
        DriverManager.driver.get(baseurl);
    }
}
