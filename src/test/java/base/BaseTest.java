package base;

import org.testng.annotations.BeforeSuite;
import pageFactories.HomeWorksPageFactories;

public abstract class BaseTest {

    protected HomeWorksPageFactories pageFactories;

    @BeforeSuite
    protected void beforeTestStart() {
        getPageFactories();
    }

    public HomeWorksPageFactories getPageFactories() {
        if (pageFactories == null) {
            pageFactories = new HomeWorksPageFactories();
        }
        return pageFactories;
    }
}
