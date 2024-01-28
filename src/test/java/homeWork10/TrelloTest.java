package homeWork10;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.homeWork10.trello.*;

import static com.codeborne.selenide.Selenide.open;
import static constants.TrelloConstants.*;
import static enums.Urls.TRELLO_URL;
import static org.testng.Assert.*;
import static users.TrelloUsers.TRELLO_USER;

public class TrelloTest extends BaseTest {

    private TrelloMainBoardsPage trelloMainBoardsPage;
    private TrelloLoginPage loginPage;
    private TrelloHomePage trelloHomePage;
    private TrelloBoardPage trelloBoardPage;
    private TrelloCardPopupPage trelloCardPopupPage;

    @BeforeTest
    public void beforeTest() {
        trelloHomePage = pageFactories.getTrelloHomePage();
        open(TRELLO_URL.getUrl());
    }

    @Test(priority = 1)
    public void checkLoginPageHeader() {
        loginPage = trelloHomePage.clickLoginButton();
        assertTrue(loginPage.isHeaderSuffixVisible(), "Header suffix should be displayed");
    }

    @Test(priority = 2)
    public void checkLoginTrello() {
        loginPage.setEmail(TRELLO_USER);
        loginPage.clickLoginSubmitButton();
        loginPage.setPassword(TRELLO_USER);
        trelloMainBoardsPage = loginPage.clickLoginSubmitButton();
        assertTrue(trelloMainBoardsPage.isHeaderTrelloBoardVisible());
    }

    @Test(priority = 3)
    public void checkBoardIsSelected() {
        trelloBoardPage = trelloMainBoardsPage.selectBoardByTitle(FIRST_BOARD_TITLE);
        assertTrue(trelloBoardPage.isBoardNameDisplayed(), "Board name should be displayed");
    }

    @Test(priority = 4)
    public void checkCardTextareaIsDisplayed() {
        trelloBoardPage.clickAddCardByIndexButton(0);
        assertTrue(trelloBoardPage.isCardTitleTextareaVisible(), "Card textarea should be displayed");
    }

    @Test(priority = 5)
    public void checkCardIsAdded() {
        trelloBoardPage.setCardTextarea(CARD_NAME);
        trelloBoardPage.clickSubmitAddCardButton();
        assertTrue(trelloBoardPage.isCardTitleTextareaVisible(), "Card textarea should be displayed");
        assertEquals(trelloBoardPage.getCardName(), CARD_NAME);
    }

    @Test(priority = 6)
    public void checkCardPopupIsOpened() {
        trelloCardPopupPage = trelloBoardPage.openCard();
        assertTrue(trelloCardPopupPage.isCardPopupHeaderVisible(), "Card popup header should be displayed");
    }

    @Test(priority = 7)
    public void checkDescriptionIsAdded() {
        trelloCardPopupPage.setCardDescriptionTextarea(0, CARD_DESCRIPTION);
        trelloCardPopupPage.clickSaveDescriptionButton();
        assertEquals(trelloCardPopupPage.getCardPopupDescription(), CARD_DESCRIPTION);
    }


    @Test(priority = 8)
    public void checkCommentIsAdded() {
        trelloCardPopupPage.setComment(1, CARD_COMMENT);
        trelloCardPopupPage.clickSaveCommentButton();
        assertEquals(trelloCardPopupPage.getCurrentComment(), CARD_COMMENT);
    }

    @Test(priority = 9)
    public void checkCardDescriptionAndCommentIcons() {
        trelloCardPopupPage.clickClosePopupButton();
        assertTrue(trelloBoardPage.isCardDescriptionIconDisplayed(), "Card description icon should be displayed");
        assertTrue(trelloBoardPage.isCardCommentIconDisplayed(), "Card comment icon should be displayed");
    }

    @Test(priority = 10)
    public void checkCardIsDeleted() {
        trelloBoardPage.archiveCard();
        assertFalse(trelloBoardPage.isCardTitleTextareaVisible(), "Card textarea should not be displayed");
    }
}
