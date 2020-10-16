package org.prvn;

import java.util.Arrays;

public class App {
    //each segment has a start point (Xs) and endpoint (Xe)
    public static Result findMaxSegmentIntersectingPoint(int xStart[], int xEnd[], int n) {
        // Sort start and end point arrays
        Arrays.sort(xStart);
        Arrays.sort(xEnd);

        // startNewX indicates new intersecting point
        int startNewSegment = 1, maxIntersectingSegments = 1, maxIntersectionPoint = xStart[0];
        int i = 1, j = 0;

        // all segments in sorted order
        while (i < n && j < n) {
            // If next point in sorted order is start segment, increment count
            if (xStart[i] <= xEnd[j]) {
                startNewSegment++;

                // Update max intersections if needed
                if (startNewSegment > maxIntersectingSegments) {
                    maxIntersectingSegments = startNewSegment;
                    maxIntersectionPoint = xStart[i];
                }
                i++; //increment index of start segment array
            } else // If point is segment end, decrement count
            {
                startNewSegment--;
                j++;
            }
        }

        System.out.println("Maximum Number of intersections = " +
                maxIntersectingSegments + " at point " + maxIntersectionPoint);

        return new Result(maxIntersectionPoint, maxIntersectingSegments);
    }

    public static class Result {
        private int point;
        private int maxIntersections;

        public Result(int point, int maxIntersections) {
            this.point = point;
            this.maxIntersections = maxIntersections;
        }

        public int getPoint() {
            return point;
        }

        public int getMaxIntersections() {
            return maxIntersections;
        }
    }
}
