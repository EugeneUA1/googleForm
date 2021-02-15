package SeleniumSuits;

import DriverFactories.ChromeDriverFactory;
import Pages.SimpleGoogleForm;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class GoogleFormTests extends BaseTest {


    @Test(dataProvider = "getValidData", groups = "google_form")
    public void UserFillOnAllFieldsByValidTestData_FormShouldBeSent(TestData data)
    {
        SimpleGoogleForm form = new SimpleGoogleForm(driver);
        boolean isFormSent = form.openPage()
                .setEmail(data.email)
                .setAge(data.age)
                .setName(data.name)
                .selectMood("Excellent")
                .clickOnButtonSend()
                .isFormSent();
        Assert.assertTrue(isFormSent, "Form wasn't send");
    }

    @DataProvider
    public Object[][] getValidData() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/jsonFiles/validFormData"));
        List<TestData> testData = new Gson().fromJson(jsonData, new TypeToken<List<TestData>>() {
        }.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }


    @Test(dataProvider = "getInvalidData", groups = "google_form")
    public void UserFillOnAllFieldsByInvalidTestData_FormShouldBeNotSent(TestData data)
    {
        SimpleGoogleForm form = new SimpleGoogleForm(driver);
        boolean isErrorPresent = form
                .openPage()
                .setEmail(data.email)
                .setAge(data.age)
                .setName(data.name)
                .selectMood("Excellent")
                .clickOnButtonSend()
                .isErrorPresent();
        Assert.assertTrue(isErrorPresent, "Form was send");
    }

    @DataProvider
    public Object[][] getInvalidData() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/jsonFiles/invalidFormData"));
        List<TestData> testData = new Gson().fromJson(jsonData, new TypeToken<List<TestData>>() {
        }.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }

}
