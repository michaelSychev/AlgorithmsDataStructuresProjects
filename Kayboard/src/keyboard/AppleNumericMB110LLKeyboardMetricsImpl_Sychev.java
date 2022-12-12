package keyboard;

import static keyboard.Key.*;
import static keyboard.KeyLayout.COLEMAK;
import static keyboard.KeyLayout.DVORAK;
import static keyboard.KeyLayout.QWERTY;
import static keyboard.KeyLayout.ROTATION_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import combinatorics.Permutation;

public class AppleNumericMB110LLKeyboardMetricsImpl_Sychev implements KeyboardMetrics {
	private List<Key> vertexLabels;
	private int[][] adjacencyMatrix;
	private int[][] distanceMatrix;
	private Key homeKey;
	
	private static Map<KeyLayout, Key> keyLayoutToHomeKeyMap;
	private static Map<KeyLayout, Map<Key, Set<Key>>> keyLayoutToKeyToNeighborMapMap;
	
	static
	{
		keyLayoutToHomeKeyMap = new HashMap<KeyLayout, Key>();
		kesteyLayoutToHomeKeyMap.put(QWERTY, J);
		keyLayoutToHomeKeyMap.put(DVORAK, H);
		keyLayoutToHomeKeyMap.put(COLEMAK, N);
		keyLayoutToHomeKeyMap.put(ROTATION_13, W);
		
		keyLayoutToKeyToNeighborMapMap = new HashMap<KeyLayout, Map<Key, Set<Key>>>();
		Map<Key, Set<Key>> keyToNeighborMap_QWERTY = getKeyToNeighborMap_QWERTY();
		Map<Key, Set<Key>> keyToNeighborMap_DVORAK = applyPermutationToMap(keyToNeighborMap_QWERTY, getQWERTYToDvorakPermutation());
		Map<Key, Set<Key>> keyToNeighborMap_COLEMAK = applyPermutationToMap(keyToNeighborMap_QWERTY, getQWERTYToColemakPermutation());
		Map<Key, Set<Key>> keyToNeighborMap_ROT_13 = applyPermutationToMap(keyToNeighborMap_QWERTY, getQWERTYToRotation13Permutation());
		keyLayoutToKeyToNeighborMapMap.put(QWERTY, keyToNeighborMap_QWERTY);
		keyLayoutToKeyToNeighborMapMap.put(DVORAK, keyToNeighborMap_DVORAK);
		keyLayoutToKeyToNeighborMapMap.put(COLEMAK, keyToNeighborMap_COLEMAK);
		keyLayoutToKeyToNeighborMapMap.put(ROTATION_13, keyToNeighborMap_ROT_13);
	}
	
	public AppleNumericMB110LLKeyboardMetricsImpl_Sychev(KeyLayout keyLayout)
	{
		this.homeKey = keyLayoutToHomeKeyMap.get(keyLayout);
		Map<Key, Set<Key>> keyToNeighborsMap = keyLayoutToKeyToNeighborMapMap.get(keyLayout);
		init(keyToNeighborsMap, new ArrayList<Key>(keyToNeighborsMap.keySet()));
	}
	
	public void init(Map<Key, Set<Key>> physicalKeyToNeighborsMap, List<Key> vertexLabels)
	{
		this.vertexLabels = vertexLabels;
		this.adjacencyMatrix = getAdjacencyMatrix(physicalKeyToNeighborsMap, vertexLabels);
		this.distanceMatrix = getDistanceMatrix(adjacencyMatrix);
	}
	
	private static int[][] getAdjacencyMatrix(Map<Key, Set<Key>> physicalKeyToNeighborsMap, List<Key> vertexLabels)
	{
		assert physicalKeyToNeighborsMap.keySet().equals(new HashSet<Key>(vertexLabels)) : "vertexLabels inconsistent with physicalKeyToNeighborsMap! : vertexLabels = " + vertexLabels + " physicalKeyToNeighborsMap.keySet() = " + physicalKeyToNeighborsMap.keySet();
		final int SIZE = physicalKeyToNeighborsMap.keySet().size();
		int[][] adjacencyMatrix = new int[SIZE][SIZE];
		
		//build adjacencyMatrix here...
		
		return adjacencyMatrix;
	}
	
	//Matrix multiplication
	private static int[][] multiply(int[][] A, int[][] B)
	{
		int rowCount_A = A.length;
		assert rowCount_A > 0 : "rowCount_A = 0!";
		int columnCount_A = A[0].length;
		int rowCount_B = B.length;
		assert rowCount_B > 0 : "rowCount_B = 0!";
		int columnCount_B = B[0].length;
		assert columnCount_A == rowCount_B : "columnCount_A = " + columnCount_A + " <> " + rowCount_B + " = rowCount_B!";
		
		int[][] C = new int[rowCount_A][columnCount_B];
        for (int i = 0; i < rowCount_A; i++)
            for (int j = 0; j < columnCount_B; j++)
                for (int k = 0; k < columnCount_A; k++)
                    C[i][j] += A[i][k] * B[k][j];
        
        return C;
	}
	
	private static int[][] getDistanceMatrix(int[][] adjacencyMatrix)
	{
		int vertexCount = adjacencyMatrix.length;
		assert vertexCount > 0 : "rowCount = 0!";
		
		int[][] distanceMatrix = new int[vertexCount][vertexCount];
		
		//Figure out distanceMatrix here...
		
		return distanceMatrix;
	}
	
	/* (non-Javadoc)
	 * @see keyboard.KeyboardMeasurements#getDistance(keyboard.PhysicalKey, keyboard.PhysicalKey)
	 */
	@Override
	public double getDistance(Key key1, Key key2) {
		int index1 = getIndex(vertexLabels, key1);
		int index2 = getIndex(vertexLabels, key2);
		return distanceMatrix[index1][index2];
	}

	private static <E> int getIndex(List<E> list, E element)
	{
		boolean foundIndex = false;
		int i = 0;
		while(!foundIndex && i < list.size())
		{
			foundIndex = (list.get(i) == element);
			if(!foundIndex) i++;
		}
		int rv = -1;
		if(foundIndex) rv = i;
		return rv;
	}

	@Override
	public double getDistance(String str) {
		double distance = 0;
		Key currentKey = homeKey;
		
		//Calculate distance here
		
		return distance;
	}
	
	private Key getClosestKey(Set<Key> keySet, Key key)
	{
		double minDistance = 0.0;
		List<Key> keyList = new ArrayList<Key>(keySet);
		Key minDistanceKey = null;
		
		//DO SOMETHING HERE...
		//getDistance() is involved...
		
		return minDistanceKey;
	}

	private static Set<Key> getKeySet(char character)
	{
		List<Key> keyList = Arrays.asList(Key.values());
		Set<Key> characterProducingKeysSet = new HashSet<Key>();
		for(int i = 0; i < keyList.size(); i++)
		{
			Key key = keyList.get(i);
			assert key != null : "key is null!";
			boolean keyProducesCharacter = (key.getNormalCharacter() != null && key.getNormalCharacter() == character) || (key.getShiftModifiedCharacter() != null && key.getShiftModifiedCharacter() == character);
			if(keyProducesCharacter) characterProducingKeysSet.add(key);
		}
		return characterProducingKeysSet;
	}
	
	private static Map<Key, Set<Key>> getKeyToNeighborMap_QWERTY()
	{
		Map<Key, Set<Key>> keyToNeighborSetMap = new HashMap<Key, Set<Key>>();
		
		//Produce keyToNeighborSetMap here
		//You might want to take a look at getSet()
		
		return keyToNeighborSetMap;
	}
	
	private static Set<Key> getSet(Key... keys)
	{
		return new HashSet<Key>(Arrays.asList(keys));
	}
	
	private static Permutation_Sychev<Key> getQWERTYToDvorakPermutation()
	{
		//Figure out what Permutation_Skeleton should be and QWERTYToDvorakPermutation if you want to use...
		//If you invent your own Permutation type, remember to name it Permutation_LastName...
	}
	
	private static Permutation_Skeleton<Key> getQWERTYToColemakPermutation()
	{
		//Figure out what Permutation_Skeleton should be and QWERTYToColemakPermutation if you want to use...
		//If you invent your own Permutation type, remember to name it Permutation_LastName...
	}
	
	private static Permutation_Skeleton<Key> getQWERTYToRotation13Permutation()
	{
		//Figure out what Permutation_Skeleton should be and QWERTYToRotation13Permutation if you want to use...
		//If you invent your own Permutation type, remember to name it Permuation_LastName...
	}
	
	private static <E> Map<E, Set<E>> applyPermutationToMap(Map<E, Set<E>> map, Permutation_Skeleton<E> permutation)
	{
		//Ex: map = {A -> {B, E}, B -> {A, C, D}, C -> {B}, D -> {B}, E -> {A}}, permutation(A) = B, permutation(B) = C, permutation(C) = A
		Map<E, Set<E>> newMap = new HashMap<E, Set<E>>();

		//DO SOMETHING HERE...

		//Ex: map = {C -> {B, E}, A -> {A, C, D}, B -> {B}, D -> {B}, E -> {A}}, permutation(A) = B, permutation(B) = C, permutation(C) = A

		//DO SOMETHING ELSE HERE...

		//Ex: map = {C -> {A, E}, A -> {C, B, D}, B -> {A}, D -> {A}, E -> {C}}, permutation(A) = B, permutation(B) = C, permutation(C) = A
		return newMap;
	}
}