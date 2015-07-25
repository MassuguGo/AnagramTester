package net.chrishaines.test.anagram;

import static org.junit.Assert.*;

import net.chrishaines.anagram.AnagramUtil;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class AnagramUtilTest {

  @Test
  public void testWhiteSpaceIgnore() {
    assertTrue(AnagramUtil.isAnagram("a  b", "\tba"));
    assertTrue(AnagramUtil.isAnagram("  ba", "ab  "));
    assertTrue(AnagramUtil.isAnagram("     c b a ", " a\t c b  "));
  }

  @Test
  public void testCaseInsensitive() {
    assertTrue(AnagramUtil.isAnagram("Mary", "Army"));
  }

  @Test
  public void testComplex() {
    assertTrue(AnagramUtil.isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort"));
  }

  @Test
  public void testDuplicateChars() {
    assertTrue(AnagramUtil.isAnagram("aaab", "aaba"));
  }

  @Test
  public void testStrOneHasExtra() {
    assertFalse(AnagramUtil.isAnagram("aaabc", "aaba"));
  }

  @Test
  public void testStrTwoHasExtra() {
    assertFalse(AnagramUtil.isAnagram("aaabc", "acabad"));
  }

  @Test
  public void testStrOneNull() {
    assertFalse(AnagramUtil.isAnagram(null, "acabad"));
  }

  @Test
  public void testStrTwoNull() {
    assertFalse(AnagramUtil.isAnagram("aaabc", null));
  }

  @Test
  public void testStrOneEmpty() {
    assertFalse(AnagramUtil.isAnagram("", "acabad"));
  }

  @Test
  public void testStrTwoEmpty() {
    assertFalse(AnagramUtil.isAnagram("aaabc", ""));
  }

  @Test
  public void testStrOneWhiteOnly() {
    assertFalse(AnagramUtil.isAnagram("  \t", " abac"));
  }

  @Test
  public void testStrTwoWhiteOnly() {
    assertFalse(AnagramUtil.isAnagram("aaabc", " \t\t  "));
  }

}
