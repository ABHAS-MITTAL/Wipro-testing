package utils;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

    // Login Data Provider
    @DataProvider(name = "logInTestData", parallel = false)
    public static Object[][] logInData() throws IOException {
        return Excelutils.getTestData("src/test/resources/RegisterData.xlsx", "LoginSheet");
    }

    // Register Data Provider
    @DataProvider(name = "registerData", parallel = false)
    public static Object[][] registerData() throws IOException {
        return Excelutils.getTestData("src/test/resources/RegisterData.xlsx", "RegisterSheet");
    }
}
