package lec_15.homework.task_08;


import java.util.ArrayList;
import java.util.Random;

public class TreeBranch {
    private ArrayList<TreeBranch> childBranches;
    private int numberOfBananas;
    private int numberOfCoconuts;

    private static final int MAX_RANDOM_NUMBER_OF_EACH_TYPE_OF_FRUIT_ON_BRANCH = 100;
    private static final int MIN_RANDOM_NUMBER_OF_EACH_TYPE_OF_FRUIT_ON_BRANCH = 2;

    public TreeBranch(int numberOfBananas, int numberOfCoconuts, ArrayList<TreeBranch> childBranches) {
        this.childBranches = childBranches;
        this.numberOfBananas = numberOfBananas;
        this.numberOfCoconuts = numberOfCoconuts;
    }

    public TreeBranch(int numberOfBananas, int numberOfCoconuts) {
        this(numberOfBananas, numberOfCoconuts, null);
    }

    public TreeBranch(ArrayList<TreeBranch> childBranches) {
        this(new Random().nextInt(MAX_RANDOM_NUMBER_OF_EACH_TYPE_OF_FRUIT_ON_BRANCH + 1
                        - MIN_RANDOM_NUMBER_OF_EACH_TYPE_OF_FRUIT_ON_BRANCH)
                        + MIN_RANDOM_NUMBER_OF_EACH_TYPE_OF_FRUIT_ON_BRANCH,
                new Random().nextInt(MAX_RANDOM_NUMBER_OF_EACH_TYPE_OF_FRUIT_ON_BRANCH + 1
                        - MIN_RANDOM_NUMBER_OF_EACH_TYPE_OF_FRUIT_ON_BRANCH)
                        + MIN_RANDOM_NUMBER_OF_EACH_TYPE_OF_FRUIT_ON_BRANCH,
                childBranches);
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

    public void addBranch(TreeBranch branch) {
        if (this.childBranches != null) {
            this.childBranches.add(branch);
        } else {
            this.childBranches = new ArrayList<>();
            this.childBranches.add(branch);
        }
    }

    @Override
    public String toString() {
        return "TreeBranch{" +
                "childBranches=" + childBranches +
                ", numberOfBananas=" + numberOfBananas +
                ", numberOfCoconuts=" + numberOfCoconuts +
                '}';
    }
}
