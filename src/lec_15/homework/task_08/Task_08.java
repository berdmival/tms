package lec_15.homework.task_08;

/* Есть дерево на котором растут бананы и кокосы.
 * Дерево состоит из веток (само дерево - главная ветка).
 * На ветке могут быть фрукты (т.е. бананы или кокосы) и другие ветки.
 * Для каждой ветки при ее создании можно задать кол-во фруктов, а если не задавать - то рандом.
 * Есть 3 обезьяны, одна умеет считать кокосы, вторая бананы, а третья - и кокосы и бананы.
 * Есть класс - MonkeyManager, в котором есть метод - попросить любую обезьяну посчитать фрукты на дереве
 */

public class Task_08 {
    public static void main(String[] args) {
        TreeBranch mainTree = new TreeBranch();
        mainTree.addBranch(new TreeBranch(7, 18));
        System.out.println("mainTree = " + mainTree);

        MonkeyManager monkeyManager = new MonkeyManager();
        System.out.println("bananas: " + monkeyManager.bananasMonkey(mainTree));
        System.out.println("coconuts: " + monkeyManager.coconutMonkey(mainTree));
        System.out.println(monkeyManager.coconutAndBananasMapMonkey(mainTree));
    }
}
