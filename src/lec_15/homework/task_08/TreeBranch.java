package lec_15.homework.task_08;

import java.util.*;

public class TreeBranch
{
	private TreeSet<TreeBranch> childBranches;
	private int numberOfBananas;
	private int numberOfCoconuts;
	
	private static final int MAX_NUMBER_OF_FRUITS = 10;

	public TreeBranch(TreeSet<TreeBranch> childBranches, int numberOfBananas, int numberOfCoconuts)
	{
		this.childBranches = childBranches;
		this.numberOfBananas = numberOfBananas;
		this.numberOfCoconuts = numberOfCoconuts;
	}
	
	public TreeBranch(TreeSet<TreeBranch> childBranches)
	{
		this(childBranches, (int)(Math.random()*MAX_NUMBER_OF_FRUITS), (int)(Math.random()*MAX_NUMBER_OF_FRUITS));
	}

	public void setNumberOfCoconuts(int numberOfCoconuts)
	{
		this.numberOfCoconuts = numberOfCoconuts;
	}

	public int getNumberOfCoconuts()
	{
		return numberOfCoconuts;
	}

	public void setNumberOfBananas(int numberOfBananas)
	{
		this.numberOfBananas = numberOfBananas;
	}

	public int getNumberOfBananas()
	{
		return numberOfBananas;
	}

	public void setChildBranches(TreeSet<TreeBranch> childBranches)
	{
		this.childBranches = childBranches;
	}

	public TreeSet<TreeBranch> getChildBranches()
	{
		return childBranches;
	}
}
