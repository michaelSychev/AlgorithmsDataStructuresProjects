package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import census.WordCensus;

public class WordCensus_TestCasesSubsetForStudents_4_BIZARRE_EXOTIC extends WordCensus_TestCasesSubsetForStudents_3_ADVANCED
{
	@Points(5)
	@Test(timeout=2000)
	public void twoWord_CLEAR_getCountTest()
	{
		final String AARDVARK = "aardvark7876";
		final String TURTLE = "turtle";
		final String GIRAFFE = "giraffe";
		final String WORDS = AARDVARK + " " + AARDVARK + " " + TURTLE;
		
		final int EXPECTED_AARDVARK_COUNT = 2;
		final int EXPECTED_TURTLE_COUNT = 1;
		final int EXPECTED_GIRAFFE_COUNT = 0;
		
		Scanner scanner = new Scanner(WORDS);
		List<String> wordListLowercase = getWordListLowercase(scanner);
		WordCensus wordCensus = getWordCensus(wordListLowercase);
		
		wordListLowercase.clear();
		
		assertEquals(EXPECTED_AARDVARK_COUNT, wordCensus.getCount(AARDVARK));
		assertEquals(EXPECTED_TURTLE_COUNT, wordCensus.getCount(TURTLE));
		assertEquals(EXPECTED_GIRAFFE_COUNT, wordCensus.getCount(GIRAFFE));
	}

	@Points(5)
	@Test(timeout=2000)
	public void fiveNulls_getCountTest()
	{		
		final int EXPECTED_NULL_COUNT = 5;
		
		List<String> wordListLowercase = Arrays.asList(null, null, null, null, null);
		WordCensus wordCensus = getWordCensus(wordListLowercase);
		
		assertEquals(EXPECTED_NULL_COUNT, wordCensus.getCount(null));
	}
	@Points(20)
	@Test()
	public void threeequalvalues()
	{
		final String AARDVARK = "aardvark";
		final String TURTLE = "turtle";
		final String GIRAFFE = "giraffe";
		final String WORDS = AARDVARK + " " + AARDVARK + " " + AARDVARK + " " + TURTLE+" " + TURTLE +" " + TURTLE + " "+ GIRAFFE + " "+ GIRAFFE +" "+ GIRAFFE;
		Scanner scanner = new Scanner(WORDS);
		List<String> wordListLowercase = getWordListLowercase(scanner);
		final String EXPECTED_WORD_RANK_1 = AARDVARK;
		final String EXPECTED_WORD_RANK_2 = GIRAFFE;
		final String EXPECTED_WORD_RANK_3 = TURTLE;

		WordCensus wordCensus = getWordCensus(wordListLowercase);
		assertEquals(EXPECTED_WORD_RANK_1, wordCensus.getWordWithRank(1));
		assertEquals(EXPECTED_WORD_RANK_2, wordCensus.getWordWithRank(2));
		assertEquals(EXPECTED_WORD_RANK_3, wordCensus.getWordWithRank(3));
	}
	@Test()
	public void whatHappensIfISomeHowGetANullValueOfRank()
	{
		final String AARDVARK = "aardvark";
		final String TURTLE = "turtle";
		final String GIRAFFE = "giraffe";
		final String WORDS = AARDVARK + " " + AARDVARK + " " + AARDVARK + " " + TURTLE+" " + TURTLE +" " + TURTLE + " "+ GIRAFFE + " "+ GIRAFFE +" "+ GIRAFFE;
		Scanner scanner = new Scanner(WORDS);
		List<String> wordListLowercase = getWordListLowercase(scanner);
		final String EXPECTED_WORD_RANK_1 = AARDVARK;
		final String EXPECTED_WORD_RANK_2 = GIRAFFE;
		final String EXPECTED_WORD_RANK_3 = TURTLE;

		WordCensus wordCensus = getWordCensus(wordListLowercase);
		assertEquals(EXPECTED_WORD_RANK_1, wordCensus.getWordWithRank(1));
		assertEquals(EXPECTED_WORD_RANK_2, wordCensus.getWordWithRank(2));
		assertEquals(EXPECTED_WORD_RANK_3, wordCensus.getWordWithRank(3));
	}

}
