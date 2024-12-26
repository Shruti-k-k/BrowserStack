package modules;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.*;

public class WebPage {


    public static List<String> list = new LinkedList<>();
    public static List<String> transList = new LinkedList<>();

    public static Properties prop;
    public static boolean test;
    public static WebDriver driver;

    public static void webPage() {

        try {
//Loading web driver in headless mode
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
             driver = new ChromeDriver(options);
            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "\\Configuration\\config.properties");
            prop.load(ip);
            driver.get(prop.getProperty("webUrl"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            WebElement opinion = driver.findElement(By.xpath(("//div[@class='sm _df']//a[text()='Opinión']")));
            String url = opinion.getAttribute("href");

            Document doc = Jsoup.connect(url).get();

            // Selecting the first 5 articles
            Elements articles = doc.select("article");
            int count = 1;
            for (Element article : articles) {
                // Extracting the title and content
                String title = article.select("h2").text();
                list.add(title);
                System.out.println(list);
                String content = article.select("p").text();
                System.out.println("Article " + count + " Title: " + title);
                System.out.println("Content: " + content);
                    if (count == 5)
                        TranslateToEnglish.Translate();
                if (list.size() == 5)
                    break;

                // Saving cover image if available
                Element imgTag = article.selectFirst("img");
                if (imgTag != null) {
                    String imgUrl = imgTag.absUrl("src");
                    saveImage(imgUrl, "article_" + count + ".jpg");
                }
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Saving image to local disk
    public static void saveImage(String imageUrl, String fileName) {
        try (InputStream in = new URL(imageUrl).openStream();
             FileOutputStream out = new FileOutputStream("Screenshots/" + fileName)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            System.out.println("Image saved: " + fileName);
        } catch (Exception e) {
            System.out.println("Error saving image: " + e.getMessage());
        }
    }
}








