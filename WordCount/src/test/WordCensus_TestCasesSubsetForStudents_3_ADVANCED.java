package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import census.WordCensus;

public class WordCensus_TestCasesSubsetForStudents_3_ADVANCED extends WordCensus_TestCasesSubsetForStudents_2_BASIC
{
	@Points(5)
	@Test(timeout=60000)
	public void warAndPeaceTest_60sec()
	{
		warAndPeaceTest();
	}

	@Points(10)
	@Test(timeout=15000)
	public void warAndPeaceTest_15sec()
	{
		warAndPeaceTest();
	}

	@Points(20)
	@Test(timeout=2000)
	public void warAndPeaceTest_2sec()
	{
		warAndPeaceTest();
	}

	public void warAndPeaceTest() {
		Scanner warAndPeaceScanner = null;
		try {
			warAndPeaceScanner = getWarAndPeaceScanner();
		} catch (IOException e) {
			fail("War and Peace not read!");
		}
		List<String> wordListLowercase = getWordListLowercase(warAndPeaceScanner);
		WordCensus warAndPeaceCensus = getWordCensus(wordListLowercase);
		assertEquals(288, warAndPeaceCensus.getCount("war"));
		assertEquals(109, warAndPeaceCensus.getCount("peace"));
		assertEquals(22063, warAndPeaceCensus.getCount("and"));
		assertEquals(10454, warAndPeaceCensus.getCount("a"));
		assertEquals(34341, warAndPeaceCensus.getCount("the"));
		assertEquals(0, warAndPeaceCensus.getCount("tomato"));
		assertEquals(1612, warAndPeaceCensus.getCount("an"));

		assertEquals(21642, warAndPeaceCensus.getDistinctWords().size());
	}

	//********************** SUPPORT *******************************************************************************************
	protected Scanner getWarAndPeaceScanner() throws IOException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream("resources/WarAndPeace.txt");
		assert input != null : "input is null! : Check that the resources folder is on the classpath, the file name is correct, and the file is in the resources folder";
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
		Scanner warAndPeaceScanner = new Scanner(bufferedReader);
		warAndPeaceScanner.useDelimiter("(" + warAndPeaceScanner.delimiter().pattern() + "|[.!,?\"\'])+");
		return warAndPeaceScanner;
	}
	@Points(5)
	@Test()
	public void fiveNulls_getRank()
	{
		final String EXPECTED_NULL= null;
		final String EXPECTED_AAA= "aaa";

		List<String> wordListLowercase = Arrays.asList(null, null, null, null, null,  "bbbbb", "bbbbb", "aaa", "aaa", "ccccccccc");
		WordCensus wordCensus = getWordCensus(wordListLowercase);

		assertEquals(EXPECTED_NULL, wordCensus.getWordWithRank(1));
		assertEquals(EXPECTED_AAA, wordCensus.getWordWithRank(2));
	}

	@Points(5)
	@Test(timeout=2000)
	public void nullsMultiple()
	{
		final String EXPECTED_NULL= null;
		final String EXPECTED_AAA= "aaa";
		final String EXPECTED_B= "bbbbb";
		final String EXPECTED_c = "c";

		List<String> wordListLowercase = Arrays.asList(null, null, null, null, null,  "bbbbb", "bbbbb", "aaa", "aaa", "c");
		WordCensus wordCensus = getWordCensus(wordListLowercase);

		assertEquals(EXPECTED_NULL, wordCensus.getWordWithRank(1));
		assertEquals(EXPECTED_AAA, wordCensus.getWordWithRank(2));
		assertEquals(EXPECTED_B, wordCensus.getWordWithRank(3));
		assertEquals(EXPECTED_c, wordCensus.getWordWithRank(4));

	}



	@Points(5)
	@Test(timeout=2000)
	public void emptyList()
	{
		try {
			List<String> wordListLowercase = new ArrayList<String>();
			WordCensus wordCensus = getWordCensus(wordListLowercase);

			String word = wordCensus.getWordWithRank(1);
		}

		catch (AssertionError ae){

		}

	}


	@Points(5)
	@Test()
	public void numbersAndLettersAndNullsCountAndRankTest()
	{
		final String AARDVARK = "123zzzzz";
		final String TURTLE = "turtle";
		final String GIRAFFE = "giraffe";
		final String NULL= null;


		final int EXPECTED_AARDVARK_COUNT = 2;
		final int EXPECTED_TURTLE_COUNT = 1;
		final int EXPECTED_GIRAFFE_COUNT = 1;

		List<String> wordListLowercase = Arrays.asList(NULL, NULL, NULL, NULL, NULL,
				AARDVARK, AARDVARK, TURTLE, GIRAFFE);
		WordCensus wordCensus = getWordCensus(wordListLowercase);


		assertEquals(EXPECTED_AARDVARK_COUNT, wordCensus.getCount(AARDVARK));
		assertEquals(EXPECTED_TURTLE_COUNT, wordCensus.getCount(TURTLE));
		assertEquals(EXPECTED_GIRAFFE_COUNT, wordCensus.getCount(GIRAFFE));

		assertEquals(NULL, wordCensus.getWordWithRank(1));
		assertEquals(AARDVARK, wordCensus.getWordWithRank(2));
		assertEquals(GIRAFFE, wordCensus.getWordWithRank(3));
		assertEquals(TURTLE, wordCensus.getWordWithRank(4));
	}
	@Points(5)
	@Test()
	public void emailKartSentMe()
	{
		final String poodle = "poodle";
		final String NULL= null;


		final int EXPECTED_POODLE_COUNT = 3;
		final int EXPECTED_NULL_COUNT = 3;

		List<String> wordListLowercase = Arrays.asList(NULL,NULL,NULL,poodle,poodle,poodle);
		WordCensus wordCensus = getWordCensus(wordListLowercase);


		assertEquals(EXPECTED_POODLE_COUNT, wordCensus.getCount(poodle));
		assertEquals(EXPECTED_NULL_COUNT, wordCensus.getCount(NULL));

		assertEquals(NULL, wordCensus.getWordWithRank(1));
		assertEquals(poodle, wordCensus.getWordWithRank(2));
	}


	@Points(5)
	@Test()
	public void getRankNonExistant()
	{
		final String AARDVARK = "123zzzzz";
		final String TURTLE = "turtle";
		final String GIRAFFE = "giraffe";
		final String NULL= null;


		List<String> wordListLowercase = Arrays.asList(NULL, NULL, NULL, NULL, NULL,
				AARDVARK, AARDVARK, TURTLE, GIRAFFE);
		WordCensus wordCensus = getWordCensus(wordListLowercase);

		try {
			assertEquals(TURTLE, wordCensus.getWordWithRank(5));
		}
		catch(AssertionError ae) {}

	}

	@Points(5)
	@Test()
	public void getRank0()
	{
		final String AARDVARK = "123zzzzz";
		final String TURTLE = "turtle";
		final String GIRAFFE = "giraffe";
		final String NULL= null;


		final int EXPECTED_AARDVARK_COUNT = 2;
		final int EXPECTED_TURTLE_COUNT = 1;
		final int EXPECTED_GIRAFFE_COUNT = 1;

		List<String> wordListLowercase = Arrays.asList(NULL, NULL, NULL, NULL, NULL,
				AARDVARK, AARDVARK, TURTLE, GIRAFFE);
		WordCensus wordCensus = getWordCensus(wordListLowercase);

		try {
			assertEquals(TURTLE, wordCensus.getWordWithRank(0));
		}
		catch(AssertionError ae) {}

	}

	@Points(5)
	@Test()
	public void getRankNegative()
	{
		final String AARDVARK = "123zzzzz";
		final String TURTLE = "turtle";
		final String GIRAFFE = "giraffe";
		final String NULL= null;


		final int EXPECTED_AARDVARK_COUNT = 2;
		final int EXPECTED_TURTLE_COUNT = 1;
		final int EXPECTED_GIRAFFE_COUNT = 1;

		List<String> wordListLowercase = Arrays.asList(NULL, NULL, NULL, NULL, NULL,
				AARDVARK, AARDVARK, TURTLE, GIRAFFE);
		WordCensus wordCensus = getWordCensus(wordListLowercase);
		System.out.println("");
		try {
			assertEquals(TURTLE, wordCensus.getWordWithRank(-1));
		}
		catch(AssertionError ae) {}

	}
}
