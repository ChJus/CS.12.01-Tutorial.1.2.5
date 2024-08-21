import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class WordScramblerTest {
  private WordScrambler ws1;
  private WordScrambler ws2;
  private WordScrambler ws3;
  private WordScrambler ws4;

  private String[] words1;
  private String[] words2;
  private String[] words3;
  private String[] words4;
  private String[] words5;

  @BeforeEach
  void setUp() {
    words1 = new String[]{"apple", "pear", "this", "cat"};
    words2 = new String[]{"Batman", "Superman", "Goku", "Vegeta"};
    words3 = new String[]{"Dua", "Billie", "Coi", "Baby"};
    words4 = new String[]{"Titan", "Death", "Monster", "Parasyte"};
    words5 = new String[]{"Attack on Titan", "Death Note", "Monster", "Parasyte"};

    ws1 = new WordScrambler(words1);
    ws2 = new WordScrambler(words2);
    ws3 = new WordScrambler(words3);
    ws4 = new WordScrambler(words4);
  }

  @AfterEach
  void tearDown() {
    words1 = null;
    words2 = null;
    words3 = null;
    words4 = null;
    words5 = null;

    ws1 = null;
    ws2 = null;
    ws3 = null;
    ws4 = null;
  }

  @org.junit.jupiter.api.Test
  void newWordScramblerEvenWordArr() {
    String[] words = {"the", "number", "of", "elements", "here", "is", "odd"};
    Exception exception = assertThrows(IllegalArgumentException.class, () -> new WordScrambler(words));

    String expectedMessage = "Word Array must contain an even number of elements!";
    String actualMessage = exception.getMessage();

    assertEquals(expectedMessage, actualMessage);
  }

  @org.junit.jupiter.api.Test
  void newWordScrambler1() {
    String[] scrambledWords = ws1.getScrambledWords();
    assertEquals("apar", scrambledWords[0]);
    assertEquals("peple", scrambledWords[1]);
    assertEquals("that", scrambledWords[2]);
    assertEquals("cis", scrambledWords[3]);
  }

  @org.junit.jupiter.api.Test
  void newWordScrambler2() {
    String[] scrambledWords = ws2.getScrambledWords();
    assertEquals("Batrman", scrambledWords[0]);
    assertEquals("Supeman", scrambledWords[1]);
    assertEquals("Goeta", scrambledWords[2]);
    assertEquals("Vegku", scrambledWords[3]);
  }

  @org.junit.jupiter.api.Test
  void newWordScrambler3() {
    String[] scrambledWords = ws3.getScrambledWords();
    assertEquals("Dlie", scrambledWords[0]);
    assertEquals("Bilua", scrambledWords[1]);
    assertEquals("Cby", scrambledWords[2]);
    assertEquals("Baoi", scrambledWords[3]);
  }

  @org.junit.jupiter.api.Test
  void newWordScrambler4() {
    String[] scrambledWords = ws4.getScrambledWords();
    assertEquals("Tiath", scrambledWords[0]);
    assertEquals("Detan", scrambledWords[1]);
    assertEquals("Monsyte", scrambledWords[2]);
    assertEquals("Paraster", scrambledWords[3]);
  }

  @org.junit.jupiter.api.Test
  void newWordScramblerInvalidInput() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> new WordScrambler(words5));

    String expectedMessage = "Word Array must contain single words only! Attack on Titan contains more than one word!";
    String actualMessage = exception.getMessage();

    assertEquals(expectedMessage, actualMessage);
  }
}
