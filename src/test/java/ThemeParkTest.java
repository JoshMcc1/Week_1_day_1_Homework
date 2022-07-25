import attractions.Playground;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest
{
  ThemePark themePark;
  RollerCoaster rollerCoaster;
  Playground playground;
  CandyflossStall candyflossStall;
  TobaccoStall tobaccoStall;
  Visitor visitor;

  @Before
  public void before() {
    tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 8);
    rollerCoaster = new RollerCoaster("Blue Ridge", 10);
    playground = new Playground("Fun Zone", 7);
    candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1, 6);
    ArrayList<IReviewed> stallsAndAttractions = new ArrayList<>();
    stallsAndAttractions.add(tobaccoStall);
    stallsAndAttractions.add(rollerCoaster);
    stallsAndAttractions.add(playground);
    stallsAndAttractions.add(candyflossStall);
    themePark = new ThemePark();
    themePark.setStallsAndAttractions(stallsAndAttractions);
    visitor = new Visitor(14, 1.2, 40.0);
  }

  @Test
  public void hasStallsAndAttractionsArrayList() {
    assertEquals(4, themePark.getAllReviewed().size());
  }

  @Test
  public void visitorCanVisitAttraction() {
    themePark.visit(visitor, rollerCoaster);
    assertEquals(1, visitor.getVisitedAttractions().size());
    assertEquals(1, rollerCoaster.getVisitCount());
  }

  @Test
  public void canGetReviews() {
    assertEquals(4, themePark.getReviews().size());
  }

  @Test
  public void canReturnAllIReviewedVisitorCanVisit() {
    assertEquals(2, themePark.getAllAllowedFor(visitor).size());
  }


}
