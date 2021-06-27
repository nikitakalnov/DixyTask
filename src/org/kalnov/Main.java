package org.kalnov;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String[] divisions = {
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };

        String[] sortedDivisions = sortDivisions(divisions);
        for(String d : sortedDivisions)
            System.out.println(d);
    }

    public static String[] sortDivisions(String[] divisions) {
        DivisionProcessor processor = new DivisionProcessor(divisions);
        return processor.sort();
    }
}
