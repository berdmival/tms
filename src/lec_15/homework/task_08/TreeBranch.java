package lec_15.homework.task_08;


import java.util.ArrayList;

public class TreeBranch {
    private ArrayList<TreeBranch> childBranches;
    private int numberOfBananas;
    private int numberOfCoconuts;

    private static final int MAX_RANDOM_NUMBER_OF_FRUITS = 10;

    public TreeBranch(int numberOfBananas, int numberOfCoconuts, ArrayList<TreeBranch> childBranches) {
        this.childBranches = childBranches;
        this.numberOfBananas = numberOfBananas;
        this.numberOfCoconuts = numberOfCoconuts;
    }

    public TreeBranch(ArrayList<TreeBranch> childBranches) {
        this((int) (Math.random() * MAX_RANDOM_NUMBER_OF_FRUITS), (int) (Math.random() * MAX_RANDOM_NUMBER_OF_FRUITS), childBranches);
    }

    public TreeBranch() {
        this(null);
    }

    public void setNumberOfCoconuts(int numberOfCoconuts) {
        this.numberOfCoconuts = numberOfCoconuts;
    }

    public int getNumberOfCoconuts() {
        return numberOfCoconuts;
    }

    public void setNumberOfBananas(int numberOfBananas) {
        this.numberOfBananas = numberOfBananas;
    }

    public int getNumberOfBananas() {
        return numberOfBananas;
    }

    public void setChildBranches(ArrayList<TreeBranch> childBranches) {
        this.childBranches = childBranches;
    }

    public ArrayList<TreeBranch> getChildBranches() {
        return childBranches;
    }
}
