
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Notebook {
  private List<Computer> computers = new ArrayList<>();

  public void addComputer(Computer computer) {
    computers.add(computer);
  }

  public void filterComputers() {
    Map<Integer, String> criteria = new HashMap<>();
    criteria.put(1, "RAM");
    criteria.put(2, "HDD");
    criteria.put(3, "OS");
    criteria.put(4, "Color");

    Map<String, String> filters = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    for (Integer key : criteria.keySet()) {
      System.out.println("Enter minimum value for " + criteria.get(key) + ": ");
      String value = scanner.nextLine();
      filters.put(criteria.get(key), value);
    }

    for (Computer computer : computers) {
      boolean pass = true;
      for (String key : filters.keySet()) {
        if (key.equals("RAM")) {
          if (computer.getRam() < Integer.parseInt(filters.get(key))) {
            pass = false;
            break;
          }
        } else if (key.equals("HDD")) {
          if (computer.getHdd() < Integer.parseInt(filters.get(key))) {
            pass = false;
            break;
          }
        } else if (key.equals("OS")) {
          if (!computer.getOs().equals(filters.get(key))) {
            pass = false;
            break;
          }
        } else if (key.equals("Color")) {
          if (!computer.getColor().equals(filters.get(key))) {
            pass = false;
            break;
          }
        }
      }
      if (pass) {
        System.out.println(computer);
      }
    }
  }
}

class Computer {
  private int ram;
  private int hdd;
  private String os;
  private String color;

  public Computer(int ram, int hdd, String os, String color) {
    this.ram = ram;
    this.hdd = hdd;
    this.os = os;
    this.color = color;
  }

  public int getRam() {
    return ram;
  }

  public int getHdd() {
    return hdd;
  }

  public String getOs() {
    return os;
  }

  public String getColor() {
    return color;
  }

  @Override
  public String toString() {
    return "Computer{" +
        "ram=" + ram +
        ", hdd=" + hdd +
        ", os='" + os + '\'' +
        ", color='" + color + '\'' +
        '}';
  }
}
