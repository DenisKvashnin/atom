package ru.atom.hachaton;

import me.xdrop.fuzzywuzzy.FuzzySearch;
import org.testng.annotations.Test;

public class Fuzzy {

    @Test
    public void fuzzyTest() {
        int coef1 = FuzzySearch.partialRatio("Сасоволучшийгород", "Сасово лучший город.");
        int coef2 = FuzzySearch.partialRatio("Сасово", "Рязань лучший город.");
        int coef3 = FuzzySearch.partialRatio("Сасово", "Осово лучший город.");
        int coef4 = FuzzySearch.partialRatio("Сасово", "Cосова лучший город.");

        System.out.println(coef1);
        System.out.println(coef2);
        System.out.println(coef3);
        System.out.println(coef4);
    }
}
