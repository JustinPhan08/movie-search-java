import javax.swing.*;
import java.awt.*;
import java.util.*;

public class PathfindingVisualizer extends JPanel {
    int rows = 20, cols = 20;
    boolean[][] walls = new boolean[rows][cols];
    Point start = new Point(0,0), end = new Point(19,19);

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if (walls[r][c]) g.setColor(Color.BLACK);
                else g.setColor(Color.WHITE);
                g.fillRect(c*20, r*20, 20, 20);
                g.setColor(Color.GRAY);
                g.drawRect(c*20, r*20, 20, 20);
            }
        }
        g.setColor(Color.GREEN); g.fillRect(start.x*20, start.y*20, 20, 20);
        g.setColor(Color.RED); g.fillRect(end.x*20, end.y*20, 20, 20);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Pathfinding Visualizer");
        PathfindingVisualizer panel = new PathfindingVisualizer();
        f.add(panel); f.setSize(420,440);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        // TODO: implement BFS or Dijkstra to animate search
    }
}
