package org.kalnov;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DivisionProcessor {

  private String[] originalDivisions;
  private Set<Category> divisions = new HashSet<>();

  public DivisionProcessor(String[] divisions) {
    setDivisions(divisions);
  }

  public void setDivisions(String[] divisions) {
    this.originalDivisions = divisions;
  }


  public String[] sort() {
    initDivisions(originalDivisions);
    List<String> sorted = new LinkedList<>();

    // Find top level divisions
    Set<Category> topLevelDivisions = divisions
            .stream()
            .filter(d -> Objects.isNull(d.getParent()))
            .collect(Collectors.toSet());

    sort(topLevelDivisions, sorted);
    return sorted.toArray(new String[]{});
  }

  protected void sort(Set<Category> divisions, Collection<String> sorted) {
    divisions
            .stream()
            .sorted(CategoryComparator.getComparator().reversed())
            .forEach(d -> {
              sorted.add(d.toString());
              sort(d.getChildren(), sorted);
            });
  }

  protected void initDivisions(String[] originalDivisions) {

    for(String division : originalDivisions) {
      String[] divisionsWithParents = division.split(Pattern.quote(Category.DELIMITER));
      Category parent = null;
      for(String name : divisionsWithParents) {
        Category div = getOrCreate(name, parent);
        if(Objects.nonNull(parent))
          parent.addChild(div);

        parent = div;
        divisions.add(parent);
      }
    }
  }

  protected Category getOrCreate(String name, Category parent) {
    Category category = new Category(name, parent);
    for(Category c : divisions)
      if(c.equals(category))
        return c;

    return category;
  }
}
