package org.kalnov;

import java.util.*;

public class Category {
  public final static String DELIMITER = "\\";
  private final String name;
  private final Category parent;
  private final Set<Category> children = new HashSet<>();

  public Category(String name, Category parent) {
    this.name = name;
    this.parent = parent;
  }

  public Category getParent() {
    return this.parent;
  }

  public String getName() {
    return name;
  }

  public void addChild(Category child) {
    children.add(child);
  }

  public Set<Category> getChildren() {
    return children;
  }

  @Override
  public boolean equals(Object obj) {
    if(Objects.nonNull(obj) && obj instanceof Category) {
      Category otherCategory = (Category)obj;
      return name.equals(otherCategory.name) && Objects.equals(this.parent, otherCategory.parent);
    }
    else
      return false;
  }

  @Override
  public String toString() {
    StringBuilder nameBuilder = new StringBuilder();
    nameBuilder.append(name);
    if(Objects.nonNull(parent)) {
      nameBuilder.insert(0, DELIMITER);
      nameBuilder.insert(0, parent.toString());
    }


    return nameBuilder.toString();
  }

  @Override
  public int hashCode() {
    return name.hashCode() + Objects.hashCode(this.parent);
  }
}
