package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

import com.surelogic.ThreadSafe;

public class Example {
  private List<String> names;
  private List<? extends List<String>> listOfLists;
  
  public void initForConcurrency() {
    names = new CopyOnWriteArrayList<String>(); // GOOD
    listOfLists = new CopyOnWriteArrayList<CopyOnWriteArrayList<String>>(); // GOOD
  }
  
  public void initForSequential() {
    names = new ArrayList<String>(); // not checked
    listOfLists = new ArrayList<List<String>>(); // not checked
  }
  
  public ConcurrentMap<Location, Player> getGameMap() { return null; } // GOOD
}

@ThreadSafe
class Location {}

@ThreadSafe
class Player {}

