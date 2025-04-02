package pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    // Metodo para capturar screenshot
    public static void captureScreenshot(WebDriver driver, String fileName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // Criar diretório de screenshots, se não existir
            File directory = new File("screenshots");
            if (!directory.exists()) {
                directory.mkdir();
            }
            // Copiar a imagem para o diretório "screenshots"
            FileUtils.copyFile(screenshot, new File("screenshots/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}