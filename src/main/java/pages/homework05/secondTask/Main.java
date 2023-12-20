package pages.homework05.secondTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Tester> testers = new ArrayList<>();
        testers.add(new Tester("Vitalii", "Bucha", "Ukraine"));
        testers.add(new Tester("Alona", "Warsaw", "Poland"));
        testers.add(new Tester("Julia", "Paris", "France"));

        Collections.sort(testers);
        testers.forEach(System.out::println);
    }
}
