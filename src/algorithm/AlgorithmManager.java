package algorithm;

public class AlgorithmManager {
    public void start(int opt) {
        switch (opt) {
            case 1:
                System.out.println("A-star selected.");
                break;
            case 2:
                System.out.println("CSP selected.");
                break;
        }
    }
}
