package com.java.masterclass;

import com.java.masterclass.basics.VariablesDemo;
import com.java.masterclass.java26.Java26FeatureCatalog;
import com.java.masterclass.strings.StringAlgorithms;
import com.java.masterclass.projects.student.StudentManagementApp;

public class App {
    public static void main(String[] args) {
        System.out.println("Core Java Masterclass - " + Java26FeatureCatalog.latestVersion());
        VariablesDemo.run();
        System.out.println("Is 'listen' an anagram of 'silent'? "
                + StringAlgorithms.isAnagram("listen", "silent"));
        System.out.println("Tracked latest-feature items: " + Java26FeatureCatalog.totalFeatureItems());
        StudentManagementApp.demo();
    }
}
