import basetest.BaseTest;
import org.testng.annotations.Test;
import pages.YoutubePage;

public class Download extends BaseTest {

    private YoutubePage youtubePage;
    private static final String TITLEVIDEO = "Aventura el malo";

    @Test(description = "Download music mp3")
    public void downloadMusic(){
        youtubePage = new YoutubePage(BaseTest.getDriver());
        youtubePage.goToYoutube();
        youtubePage.writeMusic(TITLEVIDEO);
        youtubePage.clickButtonSearch();
        youtubePage.confirmIsVisibleTitleSong(TITLEVIDEO);
        youtubePage.writeMusic(TITLEVIDEO);
    }
}
