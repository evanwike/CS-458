package correct;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ISBN10PartitioningTest {

    @ParameterizedTest
    @ValueSource(strings = {"0306406152", "080442957X"})
    void isValidISBN(String isbn) { assertTrue(ISBN10.isValidISBN(isbn)); }

    @ParameterizedTest
    @ValueSource(strings = {
            "0306406153", "080442957W", "080442957Y", "123456789", "/2345678:", "0306406150X",
            "0306406159x", "/306406152", "030640615/", "030640615Y", "980442957X"})
    void isInvalidISBN(String isbn) { assertFalse(ISBN10.isValidISBN(isbn)); }
}













