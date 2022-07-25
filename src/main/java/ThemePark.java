import attractions.Attraction;
import attractions.Playground;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.TobaccoStall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {
  public void setStallsAndAttractions(ArrayList<IReviewed> stallsAndAttractions)
  {
    this.stallsAndAttractions = stallsAndAttractions;
  }

  private ArrayList<IReviewed> stallsAndAttractions;

  public ThemePark() {
    this.stallsAndAttractions = new ArrayList<IReviewed>();
  }

  public ArrayList<IReviewed> getAllReviewed() {
    return this.stallsAndAttractions;
  }

  public void visit(Visitor visitor, Attraction attraction) {
    attraction.increaseVisitCount();
    visitor.addAttractionToList(attraction);
  }

  public HashMap<String, Integer> getReviews() {
    HashMap<String, Integer> reviews = new HashMap<>();
    for (IReviewed review : stallsAndAttractions) {
      reviews.put(review.getName(), review.getRating());
    }
    return reviews;
  }

  public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor) {
    ArrayList<IReviewed> allowedToVisit = new ArrayList<>();
    for (IReviewed review : stallsAndAttractions) {
      if (review instanceof ISecurity) {
        ISecurity check = (ISecurity) review;
        if (check.isAllowedTo(visitor)) {
          allowedToVisit.add(review);
        }
      }
      else if (!(review instanceof ISecurity)) {
        allowedToVisit.add(review);
      }
    }
    return allowedToVisit;
  }
}
