package pages;

import helpers.DateHelper;
import helpers.FakerHelper;

public class HomeworkFirstPage {


    public static void main(String[] args) {
        System.out.println("Homework 1: ");
        System.out.println("Name: " + FakerHelper.generateRandomName());
        System.out.println("Current date: "+ DateHelper.getCurrentDate());
    }

}
