package lec_15.homework.task_08;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonkeyManager {
    public Integer coconutMonkey(TreeBranch branchForAnalysis) {
        return calculateFruits(branchForAnalysis).get("coconuts");
    }

    public Integer bananasMonkey(TreeBranch branchForAnalysis) {
        return calculateFruits(branchForAnalysis).get("bananas");
    }

    public Map<String, Integer> coconutAndBananasMapMonkey(TreeBranch branchForAnalysis) {
        return calculateFruits(branchForAnalysis);
    }

    private Map<String, Integer> calculateFruits(TreeBranch branchForAnalysis) {
        Map<String, Integer> hashMapOfCountsOfFruits = new HashMap<>();
        hashMapOfCountsOfFruits.put("coconuts", branchForAnalysis.getNumberOfCoconuts());
        hashMapOfCountsOfFruits.put("bananas", branchForAnalysis.getNumberOfBananas());

        if (branchForAnalysis.getChildBranches() != null && !branchForAnalysis.getChildBranches().isEmpty()) {
            List<TreeBranch> childBranches = branchForAnalysis.getChildBranches();
            for (TreeBranch branch : childBranches) {
                Map<String, Integer> childBranchFruits = calculateFruits(branch);
                hashMapOfCountsOfFruits.put("coconuts", hashMapOfCountsOfFruits.get("coconuts") + childBranchFruits.get("coconuts"));
                hashMapOfCountsOfFruits.put("bananas", hashMapOfCountsOfFruits.get("bananas") + childBranchFruits.get("bananas"));
            }
        }
        return hashMapOfCountsOfFruits;
    }
}