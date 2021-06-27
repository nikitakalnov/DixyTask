package org.kalnov;

import java.util.Comparator;
import java.util.Objects;

public class CategoryComparator implements Comparator<Category> {
  @Override
  public int compare(Category category, Category otherCategory) {
    if(Objects.equals(category, otherCategory))
      return 0;
    else
      return category.getName().compareTo(otherCategory.getName());
  }

  public static CategoryComparator getComparator() {
    return new CategoryComparator();
  }
}
