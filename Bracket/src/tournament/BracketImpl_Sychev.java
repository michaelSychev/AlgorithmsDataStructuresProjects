package tournament;

import java.util.*;
import java.lang.Math;

import static org.junit.Assert.assertEquals;
import static tournament.FIFASoccerTeam.*;
import static tournament.FIFASoccerTeam.USA;

public class BracketImpl_Sychev<P> extends BracketAbstract<P>
{


	public BracketImpl_Sychev(List<P> participantMatchups)
	{
		super(participantMatchups);
		final P EMPTY_SPOT = null;
		//initialise instance variable
	}
	//pre: true
	//part of post: getGroupings(rv).size() == 1
	@Override
	public int getMaxLevel()
	{
		final int SIZE_OF_BRACKET = predictions.size();//31 if 1 based, should be 30 if 0 based
		int rv =(int) Math.floor(Math.log10(SIZE_OF_BRACKET)/Math.log10(2));//log2(nodes) is the max height
		return rv;
	}
	//part of pre: 0 <= level <= getMaxLevel()
	//part of post: rv != null
	//part of post: !rv.contains(null)
	//part of post: rv.contains(s) ==> (s != null)
	//part of post: rv.contains(s) ==> (!s.contains(null))
	//part of post: rv.contains(s) ==> (s.size() == 2^(level))
	//part of post: (rv.contains(s) && rv.contains(t)) ==> (s.equals(t) || (s.removeAll(t).size() == t.removeAll(s).size() == 0))
	//part of post: (rv.contains(s) && level > 0) ==> s.equals(a.addAll(b)) for some a, b in getGroupings(level-1)
	@Override
	public Set<Set<P>> getGroupings(int level)
	{
		//check for valid levels
		assert 0 <= level && level <= getMaxLevel():"Must be a valid level from 0 to " +getMaxLevel()+"!!!!!!!!!!!!!!!!!!";
		Set<Set<P>> rv = new HashSet<Set<P>>();//create set of groups
		List<Integer> requiredNodes = new ArrayList<Integer> ();
		requiredNodes.addAll(getRequestedNodeIndices(0,level)) ;//list that
				//find nodes that meet the specific level
		//return ALL children including node into set for each node that is of requested level
		for(Integer nodeElement:requiredNodes)
		{
			HashSet<P> subtree = new HashSet<P>();
			subtree.addAll(getParticipantsOfSubtree(nodeElement));
			rv.add(subtree);
		}
		//add set to rv
		System.out.println(rv);

		return rv;
	}
	private List getRequestedNodeIndices(int index, int requestedLevel)//index is the entry point to any branch
	{
		final P EMPTY_SPOT = null;
		final int CONVERT_ZERO_TO_ONE_BASE_COUNTING = 1;
		List<Integer> requestedIndices = new ArrayList<Integer>();
		if(index >= predictions.size())//base case
		{

		}
		else
		{
			int LEFT_NODE = (2*index)+1;
			int RIGHT_NODE = (2*index)+2;
			int loggedLevel = (int)Math.floor(Math.log10(index+CONVERT_ZERO_TO_ONE_BASE_COUNTING)/Math.log10(2));
			int nodeLevel = Math.abs(loggedLevel-getMaxLevel());
			if(nodeLevel == requestedLevel)//we found node that has index of requested level
			{
				requestedIndices.add(index);
			}
			requestedIndices.addAll(getRequestedNodeIndices(RIGHT_NODE, requestedLevel));//advance to right node
			requestedIndices.addAll(getRequestedNodeIndices(LEFT_NODE, requestedLevel));//advance to left node

		}
		return requestedIndices;
	}

	//called for getGroupings
	//given root, returns the
	private Set<P> getParticipantsOfSubtree(int root)
	{
		Set<P> desiredNodes = new HashSet<P>();
		if(root >= predictions.size())//base case
		{

		}
		else
		{
			int LEFT_NODE = (2*root)+1;
			int RIGHT_NODE = (2*root)+2;
			desiredNodes.add(predictions.get(root));//
			desiredNodes.addAll(getParticipantsOfSubtree(RIGHT_NODE));//advance to right node
			desiredNodes.addAll(getParticipantsOfSubtree(LEFT_NODE));//advance to left node

		}
		desiredNodes.remove(null);
		return desiredNodes;
	}

	//part of pre: getGroupings(level).contains(grouping) for some 0 <= level <= getMaxLevel()
	//part of post: rv != null
	//part of post: rv.size() > 0
	//part of post: grouping.containsAll(rv)
	//part of post: For each participant t:
	//				[(0 < level)
	//				&& (g in getGroupings(level - 1) ==> !getViableParticipants(g).contains(t))]
	//						==> !rv.contains(t)
	@Override
	public Set<P> getViableParticipants(Set<P> grouping)
	{
		double maxGroupLevel = (Math.log10(grouping.size())/Math.log10(2));
		boolean participantMatchupsSizeIsAPowerOf2 = (maxGroupLevel == (int)maxGroupLevel);
		assert participantMatchupsSizeIsAPowerOf2 : "participantMatchups.size() = " + grouping.size() + " is not a power of 2!";
		assert findSmallestParent(grouping) != -1: "Not a valid grouping";
		//set max level to the floored binary log of the participants(done at maxGroupLevel)
		//get starting index abd throw it into find absolute parent
		 Set<P> rv = new HashSet<P>();
		 rv.addAll(getPotentialSubBracketWinner(findSmallestParent(grouping)));
		System.out.println(rv);
		return rv;
	}
	//given index returns the potential winners of the node
	private Set<P> getPotentialSubBracketWinner(int index)
	{
		int LEFT_NODE = (2*index)+1;
		int RIGHT_NODE = (2*index)+2;
		Set<P> potentialWinners = new HashSet<P>();
		if(predictions.get(index) == null)//if node is null check for left and right nodes
		{
			getPotentialSubBracketWinner(LEFT_NODE);
			getPotentialSubBracketWinner(RIGHT_NODE);
		}
		else if(predictions.get(index) != null)
		{
			potentialWinners.add(predictions.get(index));
		}

		return potentialWinners;
	}
	//given an valid grouping the smallest  parent index is returned
	public int findSmallestParent(Set<P> grouping)
	{
		double maxGroupLevel = (Math.log10(grouping.size())/Math.log10(2));//find the level of our potential node
		List<Integer>  requestedIndices = new ArrayList<Integer>();
		requestedIndices.addAll(getRequestedNodeIndices(0,(int) maxGroupLevel));//add potential nodes to set
		int rv = -1;
		for(Integer index : requestedIndices )
		{
			Set<P> potentialNodes = new HashSet<P>();
			potentialNodes.addAll(getParticipantsOfSubtree(index));
			if(potentialNodes.containsAll(grouping))
			{
				rv = index;
			}
		}
		return rv;

	}



	//part of pre: participant != null
	//part of pre: participant is in getGroupings(getMaxLevel()).iterator().next()
	//part of pre: 0 <= winCount
	//part of pre: winCount <= getMaxLevel()
	//part of post: (0 < level <= winCount())) ==>
	//						getViableParticipants(getGrouping(level)).contains(participant)
	//part of post: (getViableParticipants(getGrouping(exactWinCount)).contains(t) &&
	//					(winCount < level <= getMaxLevel())) ==>
	//						!getViableParticipants(getGrouping(level)).contains(t)
	@Override
	public void setWinCount(P participant, int winCount)
	{
		assert winCount >= 0 && winCount<=getMaxLevel() : "Wincount must be from 0 to " + getMaxLevel();
		assert participant != null : "no null P";
		for (Set<P> currSet: getGroupings(this.getMaxLevel()))
		{
			assert currSet.contains(participant) == true: "invalid entree";
		}
		//find the leaf of the requested particpant
		List<Integer> allIndexesOfMRequestedNode = new ArrayList<>();
		allIndexesOfMRequestedNode.addAll(getAllIndicesOfMatch(0,participant));
		int leaf = Collections.min(allIndexesOfMRequestedNode);
		//set winCount amount of parent nodes starting at found leaf to participant
		writeWinnerToTree(leaf,winCount, participant);


	}
	//pre:none
	//post:checks that bracket is of proper structure
	public void restructureTree(int index, P participantWeJustWroteTo)
	{
		final P EMPTY_SPOT = null;
		final int CONVERT_ZERO_TO_ONE_BASE_COUNTING = 1;
		P emptySpot = null;
		final int ROOT = 0;
		if(index < ROOT || predictions.get(index) == emptySpot)//begininning of array or null element means we are done
		{
		}
		else //other wise
		{
			P currentNodeWeAreIteratingThrough = predictions.get(index);

			if(currentNodeWeAreIteratingThrough != EMPTY_SPOT  && isInSameSubGroup(currentNodeWeAreIteratingThrough,participantWeJustWroteTo,index) == false)//current node is not null and is not in same subgroup leave is alone
			{

			}
			else
			{
				predictions.set(index, emptySpot);
				int potentialNextIndex  =  index%2 ==0 ? (index-2)/2 : (index-1)/2;
				restructureTree(potentialNextIndex, participantWeJustWroteTo);
			}
			//next, if node it not null and does belong to same group we remove it
		}
	}
	//returns true if both nodes are in same subgroup
	public boolean isInSameSubGroup(P currentNodeWeAreIteratingThrough, P nodeWeJustWroteToo, int currentIndex)
	{
		int LEFT_NODE = (2*currentIndex)+1;
		int RIGHT_NODE = (2*currentIndex)+2;
		boolean rv = false;
		final P EMPTY_SPOT = null;
		final int CONVERT_ZERO_TO_ONE_BASE_COUNTING = 1;
		int loggedLevelLeft = (int)Math.floor(Math.log10(LEFT_NODE+CONVERT_ZERO_TO_ONE_BASE_COUNTING)/Math.log10(2));
		int nodeLevelLeft = Math.abs(loggedLevelLeft-getMaxLevel());
		int loggedLevelRight = (int)Math.floor(Math.log10(RIGHT_NODE+CONVERT_ZERO_TO_ONE_BASE_COUNTING)/Math.log10(2));
		int nodeLevelRight = Math.abs(loggedLevelRight-getMaxLevel());

		Set<P> groupLeft = getGrouping(predictions.get(LEFT_NODE),nodeLevelLeft);
		Set<P> groupRight = getGrouping(predictions.get(RIGHT_NODE),nodeLevelRight);
		Set<P> myNodes = new HashSet<>();
		myNodes.add(currentNodeWeAreIteratingThrough);
		myNodes.add(nodeWeJustWroteToo);
		//check that none of these groups contain eachother
		if(groupLeft.containsAll(myNodes)||groupRight.containsAll(myNodes))
		{
			rv = true;
		}

		return rv;
	}
	//pre: none
	//post: writes to tree the requested amount of times participant wins
	public void writeWinnerToTree(int index, int winCount, P participant)
	{
		final P EMPTY_SPOT = null;
		final int CONVERT_ZERO_TO_ONE_BASE_COUNTING = 1;
		int loggedLevel = (int)Math.floor(Math.log10(index+CONVERT_ZERO_TO_ONE_BASE_COUNTING)/Math.log10(2));
		int nodeLevel = Math.abs(loggedLevel-getMaxLevel());
		if(nodeLevel == winCount)//base case, we arrive at the level we want
		{
			predictions.set(index, participant);
			final int ROOT = 0;
			//execute restructure tree
			int potentialNextIndex  =  index%2 ==0 ? (index-2)/2 : (index-1)/2;
			if(potentialNextIndex > ROOT)//if availble next node is not out of bounds
			{
				restructureTree(potentialNextIndex, participant);//call potential next index
			}
		}
		else //otherwise we continute writing to true
		{
//			if(predictions.get(index) == participant)//if node already contains participant
//			{
//				//do nothig, this is wanted.
//			}
//			else // otherwise write to index
//			{
				predictions.set(index, participant);//write participant to node
//			}
			//travel up to parent and repeat
			int newIndex  =  index%2 ==0 ? (index-2)/2 : (index-1)/2;//asserts correct parent is being called for next call
			writeWinnerToTree(newIndex, winCount, participant);
		}
	}
	//pre: none
	//post:returns all indices of requested participant
	public List getAllIndicesOfMatch(int index, P requestedParticipant)
	{
		List<Integer> allIndexesOfMRequestedNode = new ArrayList<>();
		if(index >= predictions.size()) //we hit end of tree(a leaf)
		{

		}
		else //otherwise we keep going
		{
			if(predictions.get(index) == requestedParticipant)//if the node contains an participant we want
			{
				//add index to allIndxesOfRequwestedNode
				allIndexesOfMRequestedNode.add(index);
			}
			int LEFT_NODE = (2*index)+1;
			int RIGHT_NODE = (2*index)+2;
			//call for left and right node
			allIndexesOfMRequestedNode.addAll(getAllIndicesOfMatch(LEFT_NODE, requestedParticipant));
			allIndexesOfMRequestedNode.addAll(getAllIndicesOfMatch(RIGHT_NODE, requestedParticipant));
		}

		return allIndexesOfMRequestedNode;
	}



	public void printTree(int index)//index is the entry point to any branch
	{
		if(index >= predictions.size())//base case
		{
			//System.out.println(index+":arrived at end of branch");
		}
		else
		{
			 int LEFT_NODE = (2*index)+1;
			 int RIGHT_NODE = (2*index)+2;
			System.out.println(index+":"+predictions.get(index));
			printTree(RIGHT_NODE);//advance to right node
			printTree(LEFT_NODE);//advance to left node
		}

	}


  	public void printTreeLevels(int index)//index is the entry point to any branch
	{
		final int CONVERT_ZERO_TO_ONE_BASE_COUNTING = 1;
		if(index >= predictions.size())//base case
		{
			//System.out.println(index+":arrived at end of branch");
		}
		else
		{
			 int LEFT_NODE = (2*index)+1;
			 int RIGHT_NODE = (2*index)+2;
			int loggedLevel = (int)Math.floor(Math.log10(index+CONVERT_ZERO_TO_ONE_BASE_COUNTING)/Math.log10(2));
			int level = Math.abs(loggedLevel-getMaxLevel());
			System.out.println("level of " +index+" is:"+level);
			printTreeLevels(RIGHT_NODE);//advance to right node
			printTreeLevels(LEFT_NODE);//advance to left node

		}

	}




	//each grouping should have the same viable participants
	@Override
	public boolean equals(Object obj)
	{
		assert obj!=null && this != null:"no null";
		boolean rv = true;
		//use method instanceOf, and isAssignableFrom
		if(Bracket.class.isAssignableFrom(obj.getClass()))//cast object is
		{
			Bracket otherBracket = (Bracket)obj;
			if(otherBracket.getMaxLevel() != this.getMaxLevel())//we must have equal levels
			{
				rv =false;
			}
			else
			{
				for(int i =0;i<this.getMaxLevel()+1;i++)
				{
					Set<Set<P>> thisSet = this.getGroupings(i);
					Set<Set<P>> otherSet = otherBracket.getGroupings(i);
					for(Set<P> setP:thisSet)
					{
						if(getViableParticipants(setP).containsAll(getViableParticipants(setP))==false)
						{
							return false;
						}
					}
				}
			}
		}
		return rv;
	}
	public Set<P> getrecursiveparticipant(int index)
	{
		Set<P> viableParticipant = new HashSet<>();
		if(index*2 > predictions.size())
		{
			viableParticipant.add(predictions.get(index));
		}
		else
		{
			int LEFT_NODE = (2*index)+1;
			int RIGHT_NODE = (2*index)+2;
			viableParticipant.addAll(getrecursiveparticipant(LEFT_NODE));
			viableParticipant.addAll(getrecursiveparticipant(RIGHT_NODE));

		}
		return viableParticipant;
	}
	//given a group of teams, find the absolute parent
	//absolute parent is the smallest root of teams



	private Set<P> getGrouping(P member, int level)
	{
		Set<Set<P>> groupings = getGroupings(level);

		Set<P> groupingNotFound = null;

		for (Set<P> grouping : groupings) {

			if (grouping.contains(member)) {
				return grouping;
			}
		}

		return groupingNotFound;
	}

	public static void main(String[] args)
	{
		List<FIFASoccerTeam> worldCup2014KnockoutRoundMatchups = Arrays.asList(BRAZIL, CHILE, COLOMBIA, URUGUAY, FRANCE, NIGERIA, GERMANY, ALGERIA, NETHERLANDS, MEXICO, COSTA_RICA, GREECE, ARGENTINA, SWITZERLAND, BELGIUM, USA);

		BracketImpl_Sychev<FIFASoccerTeam> worldCup2014KnockoutResults = new BracketImpl_Sychev<FIFASoccerTeam>(worldCup2014KnockoutRoundMatchups);
		worldCup2014KnockoutResults.setWinCount(GERMANY, 4);
		worldCup2014KnockoutResults.setWinCount(NETHERLANDS, 3);
		worldCup2014KnockoutResults.setWinCount(BRAZIL, 2);
//		worldCup2014KnockoutResults.setWinCount(ARGENTINA, 2);
//		worldCup2014KnockoutResults.setWinCount(COLOMBIA, 1);
//		worldCup2014KnockoutResults.setWinCount(FRANCE, 1);
//		worldCup2014KnockoutResults.setWinCount(COSTA_RICA, 1);
//		worldCup2014KnockoutResults.setWinCount(BELGIUM, 1);
		//assertEquals(getSet(new FIFASoccerTeam[]{GERMANY}), worldCup2014KnockoutResults.getViableParticipants(new HashSet<FIFASoccerTeam>(getSet(new FIFASoccerTeam[] {BRAZIL, CHILE, COLOMBIA, URUGUAY, FRANCE, NIGERIA, GERMANY, ALGERIA}))));
		Set<FIFASoccerTeam> Group1 = worldCup2014KnockoutResults.getGrouping(GERMANY,3);
		System.out.println(Group1);
		//bracketOne.getViableParticipants(new HashSet<FIFASoccerTeam>(BRAZIL,CHILE,COLOMBIA,URUGUAY,FRANCE,NIGERIA,GERMANY,ALGERIA,NETHERLANDS,MEXICO,COSTA_RICA,GREECE,ARGENTINA,SWITZERLAND,BELGIUM,USA));
//		for(int i = 0; i< worldCup2014KnockoutResults.predictions.size();i++)
//		{
//			System.out.println(i+":"+worldCup2014KnockoutResults.predictions.get(i));
//		}


	}


}
