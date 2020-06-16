package mutant4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ISBN10DecisionTableTest {

    @ParameterizedTest
    @ValueSource(strings = {"0306406152", "080442957X"})
    void isValidISBN(String isbn) {
        assertTrue(ISBN10.isValidISBN(isbn));
    }

    @ParameterizedTest
    @ValueSource(strings = {"030640615x", "0273170060", "0273AB009X", "0273$"})
    void isInvalidISBN(String isbn) {
        assertFalse(ISBN10.isValidISBN(isbn));
    }
}

