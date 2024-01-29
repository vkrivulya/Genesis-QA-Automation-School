package dataprovider;

import org.testng.annotations.DataProvider;

public class LanguagesDataProvider {

    @DataProvider(name = "languages")
    public Object[][] languages() {
        return new Object[][]{
                {"az", "Testng sərin öyrənəcəyəm"},
                {"en", "I will study TESTNG cool"},
                {"bg", "Ще проуча тестова готина"},
                {"hy", "Ես կսովորեմ Testng Cool"},
                {"ro","Voi studia testng cool"},
                {"la","Ego studere testng refrigescant"},
                {"fr","J'étudierai le test."},
                {"ms","Saya akan belajar testng sejuk"},
                {"nl","Ik zal testng cool bestuderen"},
                {"de","Ich werde testng cool studieren"},
                {"no","Jeg vil studere testng kult"},
                {"pl","Badam testng fajny"},
                {"pt","Vou estudar testng legal"},
                {"sk","Budem študovať testng cool"},
                {"sl","Preučeval bom testng kul"},
                {"tt","Мин салкынны салкын өйрәнәчәкмен"},
                {"tr","Testng serin çalışacağım"},
                {"hu","Tanulni fogom a tesztng cool -ot"},
                {"tl","Mag -aaral ako ng testng cool"},
                {"fi","Opiskelen testiä viileänä"}
        };
    }
}
