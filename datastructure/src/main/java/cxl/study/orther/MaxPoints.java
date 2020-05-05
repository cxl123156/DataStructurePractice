package cxl.study.orther;

import java.util.HashMap;
import java.util.Map;

public class MaxPoints {

    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public int maxPoints(Point[] points) {

        Map<Integer, Integer> xPointMap = new HashMap<>();
        Map<Integer, Integer> yPointMap = new HashMap<>();
        int samePoint = 0;

        for (Point point : points) {
            if(point.x == point.y){
                samePoint++;
            }
            if (xPointMap.get(point.x) == null) {
                xPointMap.put(point.x, 1);
            } else {
                xPointMap.put(point.x, xPointMap.get(point.x) + 1);
            }
            if (yPointMap.get(point.y) == null) {
                yPointMap.put(point.y, 1);
            } else {
                yPointMap.put(point.y, yPointMap.get(point.y) + 1);
            }
        }
        int xResult = 0;
        int yResult = 0;
        for (Integer value : xPointMap.values()) {
            xResult = Math.max(value, xResult);
        }
        for (Integer value : yPointMap.values()) {
            yResult = Math.max(value, yResult);
        }
        return Math.max(Math.max(xResult,yResult),samePoint);
    }

}
