package mutant6;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleMutationTest {
    @Test   // Mutant 1
    public void testCase1() {
        assertEquals(TriangleSides.TriangleType.NOTRIANGLE, new TriangleSides(3, 1, 1).reportTriangleType()); }
    @Test   // Mutants 2, 3
    public void testCase2() {
        assertEquals(TriangleSides.TriangleType.ISOSCELES, new TriangleSides(1, 2, 2).reportTriangleType()); }
    @Test   // Mutants 4, 6
    public void testCase3() {
        assertEquals(TriangleSides.TriangleType.SCALENE, new TriangleSides(4, 5, 6).reportTriangleType()); }
    @Test   // Mutant 5
    public void testCase4() {
        assertEquals(TriangleSides.TriangleType.NOTRIANGLE, new TriangleSides(1, 2, 3).reportTriangleType()); }
    @Test   // Mutant 7
    public void testCast5() {
        assertEquals(TriangleSides.TriangleType.NOTRIANGLE, new TriangleSides(1, 2, 1).reportTriangleType()); }
    @Test   // Mutant 8
    public void testCase6() {
        assertEquals(TriangleSides.TriangleType.NOTRIANGLE, new TriangleSides(1, 2, 0).reportTriangleType()); }
    @Test   // Mutant 9
    public void testCase7() {
        assertEquals(TriangleSides.TriangleType.NOTRIANGLE, new TriangleSides(-4, -5, -6).reportTriangleType()); }
}


