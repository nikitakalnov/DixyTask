package org.kalnov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisionProcessorTest {

  private final DivisionProcessor processor = new DivisionProcessor(new String[] {});

  @Test
  void sort() {
    // Preparing data
    String[] divisions = {
            "K1\\SK1",
            "K1\\SK2",
            "K1\\SK1\\SSK1",
            "K1\\SK1\\SSK2",
            "K2",
            "K2\\SK1\\SSK1",
            "K2\\SK1\\SSK2"
    };

    String[] sortedDivisions = {
            "K2",
            "K2\\SK1",
            "K2\\SK1\\SSK2",
            "K2\\SK1\\SSK1",
            "K1",
            "K1\\SK2",
            "K1\\SK1",
            "K1\\SK1\\SSK2",
            "K1\\SK1\\SSK1",
    };
    processor.setDivisions(divisions);

    // Acting
    String[] result = processor.sort();

    // Asserting
    assertArrayEquals(result, sortedDivisions);
  }
}