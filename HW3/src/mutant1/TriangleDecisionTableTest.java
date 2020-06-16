package mutant1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleDecisionTableTest {
    @Test
    public void testCase1() {
        assertEquals(TriangleSides.TriangleType.NOTRIANGLE, new TriangleSides(4, 1, 2).reportTriangleType()); }
    @Test
    public void testCase2() {
        assertEquals(TriangleSides.TriangleType.NOTRIANGLE, new TriangleSides(1, 4, 2).reportTriangleType()); }
    @Test
    public void testCase3() {
        assertEquals(TriangleSides.TriangleType.NOTRIANGLE, new TriangleSides(1, 2, 4).reportTriangleType()); }
    @Test
    public void testCase4() {
        assertEquals(TriangleSides.TriangleType.EQUILATERAL, new TriangleSides(5, 5, 5).reportTriangleType()); }
    @Test
    public void testCase7() {
        assertEquals(TriangleSides.TriangleType.ISOSCELES, new TriangleSides(2, 2, 3).reportTriangleType()); }
    @Test
    public void testCase9() {
        assertEquals(TriangleSides.TriangleType.ISOSCELES, new TriangleSides(2, 3, 2).reportTriangleType()); }
    @Test
    public void testCase10() {
        assertEquals(TriangleSides.TriangleType.ISOSCELES, new TriangleSides(3, 2, 2).reportTriangleType()); }
    @Test
    public void testCase11() {
        assertEquals(TriangleSides.TriangleType.SCALENE, new TriangleSides(3, 4, 5).reportTriangleType()); }
}
