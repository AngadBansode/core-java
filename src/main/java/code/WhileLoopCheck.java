package code;

public class WhileLoopCheck {

    static int cnt;

    public static void main(String[] args) throws InterruptedException {
        int cntWhile = 0;
        while (!serverHealthCheck() ) {
            cntWhile++;
            if(cntWhile>3)
                break;
            Thread.sleep(3000l);
            System.out.println("while looop-:" + cntWhile);
        }
        resume();
        System.out.println("Done");
    }

    private static void resume() {
        System.out.println("resume called");
    }

    private static boolean serverHealthCheck() {

        System.out.println("Inside server check....!");
        if (cnt >2) {
            return true;
        }
        cnt++;
        return false;
    }
}
