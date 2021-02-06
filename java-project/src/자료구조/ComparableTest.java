package 자료구조;


import java.io.IOException;
import java.util.*;

public class ComparableTest {
    public static void main(String args[]) throws IOException {

        ArrayList<Point> qu = new ArrayList<>();
        qu.add(new Point(1,2));
        qu.add(new Point(2,5));
        qu.add(new Point(4,2));
        qu.add(new Point(4,8));
        qu.add(new Point(3,3));
        qu.add(new Point(2,5));
        qu.add(new Point(3,2));
        qu.add(new Point(4,6));
        Collections.sort(qu);
        for(Point p : qu){
            System.out.println(p.toString());
        }

    }




    public static class Point implements Comparable<Point>{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public int compareTo(Point o) {
            if(this.x > o.x)
                return 1;
            else if( this.x == o.x){
                if(this.y > o.y)
                    return -1;
            }
            return -1;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
