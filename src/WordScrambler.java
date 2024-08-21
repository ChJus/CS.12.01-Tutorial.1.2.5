public class WordScrambler {
  private String[] scrambledWords;

  public WordScrambler(String[] wordArr) {
    // Ensure there are an even number of elements
    if (wordArr.length % 2 != 0)
      throw new IllegalArgumentException("Word Array must contain an even number of elements!");

    // Scramble words
    scrambledWords = mixedWords(wordArr);
  }

  public String[] getScrambledWords() {
    return scrambledWords;
  }

  // Appends the first half of the first string and the second half of the second string.
  // Note: integer rounding (floor/rounding down) ensures that if the first word has
  // n characters (with n odd), only (n-1)/2 are taken for the first half.
  // Similarly, (n+1)/2 are taken from the second string if it is of odd length.
  // Even length words are similarly handled correctly by integer rounding.
  private String recombine(String word1, String word2) {
    return word1.substring(0, word1.length() / 2) + word2.substring(word2.length() / 2);
  }

  // Mixes an array of word pairs.
  // For every pair (a, b), stores the outcome of recombine(a, b) and recombine(b, a)
  private String[] mixedWords(String[] words) {
    String[] result = new String[words.length];
    for (int i = 0; i < words.length; i += 2) {
      // Ensure each word actually only contains one word
      if (words[i].contains(" "))
        throw new IllegalArgumentException("Word Array must contain single words only! " + words[i] + " contains more than one word!");

      // Store result of recombine(a, b), recombine(b, a)
      result[i] = recombine(words[i], words[i + 1]);
      result[i + 1] = recombine(words[i + 1], words[i]);
    }
    return result;
  }
}
