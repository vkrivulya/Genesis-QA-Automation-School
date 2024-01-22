package pageFactories;

import pages.homeWork10.GoogleTranslatePage;

public class HomeWorksPageFactories extends PageFactories{

    public GoogleTranslatePage getGoogleTranslatePage() {
        return GoogleTranslatePage.getInstance(this);
    }
}
