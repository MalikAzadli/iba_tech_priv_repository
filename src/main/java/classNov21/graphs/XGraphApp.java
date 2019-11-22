package classNov21.graphs;

import java.util.List;

public class XGraphApp {
  public static void main(String[] args) {
    XGraph g = new XGraph(10);// 0..9
    g.add(0,1);
    g.add(0,2);

    g.add(1,3);
    g.add(1,4);

    g.add(2,5);
    g.add(2,6);

    g.add(3,4);
    g.add(3,5);
    g.add(3,6);
    g.add(3,7);

    g.add(3,8);
    boolean b1 = g.check(3,8);
    System.out.println(b1);

    g.remove(3, 8);
    boolean b2 = g.check(3,8);
    System.out.println(b2);

    g.add(3,9);

    g.add(8,9);

    GraphPath gp = new GraphPath(g);
    List<Integer> path = gp.path(0, 6);

    System.out.println(path.toString());


  }
}
