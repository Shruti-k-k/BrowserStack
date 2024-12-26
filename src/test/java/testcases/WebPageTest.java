package testcases;

import modules.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static modules.WebPage.*;

public class WebPageTest  {

//Checking if a spanish word is present in the web page
    @Test
    public void webPageTest() {
        WebPage.webPage();
        boolean test=false;
         WebElement body = driver.findElement(By.tagName("body"));
            String pageText = body.getText().toLowerCase();
            if(pageText.contains("españa")){
               test=true;
            }
            Assert.assertTrue(test);
    }

 }
