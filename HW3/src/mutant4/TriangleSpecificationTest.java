package mutant4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleSpecificationTest {
    @Test
    public void testCase1() {
        assertEquals(TriangleSides.TriangleType.NOTRIANGLE, new TriangleSides(0, -1, 1).reportTriangleType()); }
    @Test
    public void testCase2() {
        assertEquals(TriangleSides.TriangleType.NOTRIANGLE, new TriangleSides(1, 1, 0).reportTriangleType()); }
    @Test
    public void testCase3() {
        assertEquals(TriangleSides.TriangleType.SCALENE, new TriangleSides(4, 5, 6).reportTriangleType()); }
    @Test
    public void testCase4() {
        assertEquals(TriangleSides.TriangleType.ISOSCELES, new TriangleSides(2, 1, 2).reportTriangleType()); }
    @Test
    public void testCase5() {
        assertEquals(TriangleSides.TriangleType.EQUILATERAL, new TriangleSides(1, 1, 1).reportTriangleType()); }
}
