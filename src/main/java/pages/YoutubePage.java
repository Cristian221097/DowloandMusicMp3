package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YoutubePage extends BasePage{

    private By inputSearch = By.xpath("//input[@id='search']");
    private By buttonSearch = By.xpath("//button[@id='search-icon-legacy']");
    private String videoTitleXpath = "//a[@id='video-title']//*[contains(translate(text(),'%s','%s'),'%s')]";
    private String selectedVideoTitleXpath = "//*[@id='above-the-fold']//*[contains(translate(text(),'%s','%s'),'%s')]";

    private static final String URL ="https://www.youtube.com/";

    private String urlVideo = "";

    public YoutubePage(WebDriver driver) {
        super(driver);
    }

    public void goToYoutube(){
        go(URL);
    }

    public void writeMusic(String titleSong){
        writeField(inputSearch,titleSong,"search music");
    }

    public void clickButtonSearch(){
        clickElement(buttonSearch,"button search");
    }

    public void confirmIsVisibleTitleSong(String titleSong){
        videoTitleXpath = String.format(videoTitleXpath,titleSong.toUpperCase(),titleSong.toLowerCase(),titleSong.toLowerCase());
        By videoTitle = By.xpath(videoTitleXpath);
        confirmIsVisibleElement(videoTitle,"video title");
    }

    public void selectVideo(String titleSong){
        videoTitleXpath = String.format(videoTitleXpath,titleSong);
        By videoTitle = By.xpath(videoTitleXpath);
        clickElement(videoTitle,"video title");
    }

    public String getUrlVideo(){
        return urlVideo;
    }

    private void setUrlVideo(){
        urlVideo = driver.getCurrentUrl();
    }

    public void confirmIsVisibleSelectedVideo(String titleSong){
        selectedVideoTitleXpath = String.format(selectedVideoTitleXpath,titleSong.toUpperCase(),titleSong.toLowerCase(),titleSong.toLowerCase());
        By selectedVideoTitle = By.xpath(selectedVideoTitleXpath);
        confirmIsVisibleElement(selectedVideoTitle,"selected video title");
        setUrlVideo();
    }

}
