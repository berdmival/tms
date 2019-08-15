package lec_15.homework.task_08;

import java.util.ArrayList;
import java.util.HashMap;

public class MonkeyManager {
    public Integer coconutMonkey(TreeBranch branchForAnalysis) {
        return calculateFruits(branchForAnalysis).get("coconuts");
    }

    public Integer bananasMonkey(TreeBranch branchForAnalysis) {
        return calculateFruits(branchForAnalysis).get("bananas");
    }

    public HashMap<String, Integer> coconutAndBananasMapMonkey(TreeBranch branchForAnalysis) {
        return calculateFruits(branchForAnalysis);
    }

    private HashMap<String, Integer> calculateFruits(TreeBranch branchForAnalysis) {
        HashMap<String, Integer> hashMapOfCountsOfFruits = new HashMap<>();
        hashMapOfCountsOfFruits.put("coconuts", 0);
        hashMapOfCountsOfFruits.put("bananas", 0);
        if (branchForAnalysis.getChildBranches().isEmpty()) {
            hashMapOfCountsOfFruits.put("coconuts", hashMapOfCountsOfFruits.get("coconuts") + branchForAnalysis.getNumberOfCoconuts());
            hashMapOfCountsOfFruits.put("bananas", hashMapOfCountsOfFruits.get("bananas") + branchForAnalysis.getNumberOfBananas());
        } else {
            ArrayList<TreeBranch> childBranches = branchForAnalysis.getChildBranches();
            for (TreeBranch branch:childBranches) {
                hashMapOfCountsOfFruits = calculateFruits(branch);
                hashMapOfCountsOfFruits.put("coconuts", hashMapOfCountsOfFruits.get("coconuts") + branch.getNumberOfCoconuts());
                hashMapOfCountsOfFruits.put("bananas", hashMapOfCountsOfFruits.get("bananas") + branch.getNumberOfBananas());
            }
        }
        return hashMapOfCountsOfFruits;
    }
}