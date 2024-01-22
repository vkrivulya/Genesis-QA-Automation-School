package homeWork10;

import base.BaseTest;
import dataprovider.LanguagesDataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.homeWork10.GoogleTranslatePage;

import static com.codeborne.selenide.Selenide.open;
import static constants.GoogleTranslateConstants.TEXT_FOR_TRANSLATE;
import static enums.Urls.GOOGLE_TRANSLATE_URL;
import static org.testng.Assert.assertTrue;

public class GoogleTranslateTest extends BaseTest {

    GoogleTranslatePage googleTranslatePage;

    @BeforeTest
    public void beforeTest() {
        googleTranslatePage = pageFactories.getGoogleTranslatePage();
        open(GOOGLE_TRANSLATE_URL.getUrl());
        googleTranslatePage.setTextForTranslateByLangCode(TEXT_FOR_TRANSLATE, "uk");
    }

    @Test(dataProviderClass = LanguagesDataProvider.class, dataProvider = "languages")
    public void testTranslation(String languageCode, String expectedTranslation) {
        googleTranslatePage.selectByCodeLanguageToTranslateTo(languageCode);
        assertTrue(googleTranslatePage.isTextAfterTranslateVisible(expectedTranslation), "Text after translate isn't correct or visible");
    }
}
