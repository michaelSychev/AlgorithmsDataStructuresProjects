package census;

import java.util.*;
import java.util.Map.Entry;
//hola pedro
public class WordCensusImpl_Sychev implements WordCensus
{
	private Map<String,Integer> wordToCountMap;

	private List<Entry<String,Integer>> list;

	private ArrayList<String> m_wordList;//contains entire list of words
	public WordCensusImpl_Sychev(List<String> wordList)
	{
		final int FIRST_TIME_ADDED = 1;
		wordToCountMap = new HashMap<String,Integer>();//initialise wordToCountMap

		m_wordList = new ArrayList<String>();//initialise m_wordList

		wordToCountMap.put(null,0); //add null to map and give it value of 0
		wordList.forEach(wordListElement -> m_wordList.add(wordListElement));//iterate through wordlist and add each element to listOfWords

		//iterate through list and create map
		for(String word: wordList)
		{

			if(word == null )//check for nulls(which are counted as words)
			{
				//add one to null
				wordToCountMap.replace(word, wordToCountMap.get(word),wordToCountMap.get(word)+1);

			}
			else //check non null Strings
			{
				//check if word has been referenced before
				if(wordToCountMap.containsKey(word) == false) //if word is not in map
				{
					wordToCountMap.put(word,FIRST_TIME_ADDED);//add word to map and give it value of one since first timE
				}
				else // if wordToCountMap.contains is not false we assume word is in map
				{
					//increment value of key by one
					wordToCountMap.replace(word, wordToCountMap.get(word),wordToCountMap.get(word)+1);

				}
			}
		}
		//sort WordToCountMap by value, if tied sort them by alphabetical value(key)
		Set<Entry<String,Integer>> entrySet = wordToCountMap.entrySet();

		list = new ArrayList<>(entrySet);


		Collections.sort(list, new Comparator<Entry<String,Integer>>()
		{
			@Override
			public int compare(Entry<String,Integer> entry1, Entry<String,Integer> entry2)
			{
				final int GREATER_THAN = 1;
				final int LESS_THAN = -1;
				final int EQUALS = 0;
				int rv =GREATER_THAN;

				//CHECK FOR == VS .EQUALS
				if(entry1.getValue() == entry2.getValue())//if 2 keys have same value(word happens the same amount) we compare the alphabetical value of the keys by ascending order and give null the highest rank
				{
					if(entry1.getKey() == null || entry2.getKey() == null)//check if either entry is null
					{
						if(entry1.getKey() == null)//if entry 1 is null which entry 2 is not, we say entry1>entry2(in tie null wins)
						{
							rv = LESS_THAN;
						}
						else//since entry1 is not null, entry2 is and therefore null is the greater value
						{
							rv  = GREATER_THAN;
						}
					}
					else if(entry1.getKey().compareTo(entry2.getKey())>0)//if key1 is alphabetically larger than key2
					{
						rv = GREATER_THAN;//old value -1
					}
					else
					{
						rv = LESS_THAN;//old value 1
					}
				}
				else if(entry1.getValue()>entry2.getValue())//if key1's word happens more than key2's word then entry1>entry2
				{
					rv = LESS_THAN;//old value 1
				}
				else if(entry1.getValue()<entry2.getValue()) //if key1's word happens less than key 2 then key 2 is the greater
				{
					rv = GREATER_THAN;//old value -1
				}
				return rv;
			}

		});

	}
	//pre: nothing
	//part of post: rv >= 0
	@Override
	public int getCount(String word)
	{
		Integer countOfWord = wordToCountMap.get(word);
		int rv = 0;
		if(countOfWord == null)
		{
			rv = 0;
		}
		else {
			rv = countOfWord;
		}
		return rv;
	}
	//part of post: rv != null
	public Set<String> getDistinctWords()
	{
		HashSet<String> rv =  new HashSet<String>(m_wordList);
		return rv;
	}
	//part of pre: i > 0
	//part of post: i < getDistinctWords().size() ==> getCount(getWordWithRank(i)) >= getCount(getWordWithRank(i + 1))
	//part of post: [((i < j) && (word_i == getWordWithRank(i)) && (word_j == getWordWithRank(j))
	// && (getCount(word_i) == getCount(word_j))] ==> (getWordWithRank(i) < getWordWithRank(j))
	@Override
	public String getWordWithRank(int i)
	{
		assert i>0 && i<=getDistinctWords().size():"0<i<list.length";
		String rv = list.get(i-1).getKey();
		return rv;
	}

	public static void main(String[] args)
	{
		Map<String,Integer> map = new HashMap<String,Integer>();//initialise wordToCountMap
		map.put(null,1);
		System.out.println(map.get(null));



	}

}
