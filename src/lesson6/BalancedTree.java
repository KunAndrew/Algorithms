package lesson6;

import javax.swing.*;
import java.util.Random;

public class BalancedTree {
    public static final int AmountOfTrees = 20;

    public static void main(String[] args) {
        int AmountBalanced = 0;
        int AmountNONBalanced = 0;
        for (int i = 0; i < AmountOfTrees; i++) {
            BinaryTree bt = getBinaryTree();

            System.out.println(bt.isBalanced());
            System.out.println(bt.getSize());
            System.out.println("------");

//            SwingUtilities.invokeLater(new Runnable() {
//                @Override
//                public void run() {
//                    new ShowTree(bt);
//                }
//            });
            if (bt.isBalanced()) {
                AmountBalanced++;
            } else {
                AmountNONBalanced++;
            }
        }
        System.out.println("Процент несбалансированных деревьев: " + AmountNONBalanced / (double) AmountOfTrees); //При выборке в 10000 деревьев - примерно равен 0,89
    }

    private static BinaryTree getBinaryTree() {
        BinaryTree bt = new BinaryTree();
        Random rnd = new Random();
        for (int i = 0; i < 100; i++) {
            bt.add(rnd.nextInt(200) - 100);
            if (bt.getSize() == 6) {
                break;
            }
        }
        return bt;
    }
}
