package org.kalnov;

import java.util.Comparator;

public class CategoryComparator implements Comparator<Category> {
  @Override
  public int compare(Category category, Category otherCategory) {
    return category.getName().compareTo(otherCategory.getName());
  }

  public static CategoryComparator getComparator() {
    return new CategoryComparator();
  }
}
