package org.prvn;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for App.
 */
public class AppTest {
    @Test
    public void shouldFindMaxPoint() {
         /* Test Data
          1<------------->6
             2<------------->7
                3<------------->8
                   4<------------->9
                       5<------------->10
         */
        int[] startX = {1, 2, 3, 4, 5};
        int[] endX = {6, 7, 8, 9, 10};
        App.Result result = App.findMaxSegmentIntersectingPoint(startX, endX, startX.length);
        assertTrue(result.getMaxIntersections() == 5);
        assertTrue(result.getPoint() == 5);
    }

    @Test
    public void shouldFindMaxPointWithSameStartAndEnd() {
         /* Test Data
          1<---------->5
                       5<------------->8
               2<------------->7
                       5<------------------>9
                       5<----------------------->10
         */
        int[] startX = {1, 5, 2, 5, 5};
        int[] endX = {5, 8, 7, 9, 10};
        App.Result result = App.findMaxSegmentIntersectingPoint(startX, endX, startX.length);
        assertTrue(result.getMaxIntersections() == 5);
        assertTrue(result.getPoint() == 5);
    }

    @Test
    public void shouldFindMaxPointWithNoSegmentOverlap() {
        /* Test Data
               4<------------->10
                                      20<------->25
                                                           30<----------->40
         */
        int[] startX = {4, 20, 30};
        int[] endX = {10, 25, 40};
        App.Result result = App.findMaxSegmentIntersectingPoint(startX, endX, startX.length);
        assertTrue(result.getMaxIntersections() == 1);
        assertTrue(result.getPoint() == 4);
    }

    @Test
    public void shouldFindMaxPointWithNegativeCoordinates() {
        /* Test Data
               -10<------------->10
        -20<----------------------------->20
                                                   30<----------->40
         */
        int[] startX = {-20, -10, 30};
        int[] endX = {20, 10, 40};
        App.Result result = App.findMaxSegmentIntersectingPoint(startX, endX, startX.length);
        assertTrue(result.getMaxIntersections() == 2);
        assertTrue(result.getPoint() == -10);
    }
}
