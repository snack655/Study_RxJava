package third;

import java.util.Random;

public class CommonUtils {

    // 실행 시간을 표기하는 정적 변수
    public static long startTime;

    public static void exampleStart() {
        startTime = System.currentTimeMillis();
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getThreadName() {
        String threadName = Thread.currentThread().getName();
        if (threadName.length() > 30) {
            threadName = threadName.substring(0, 30) + "...";
        }
        return threadName;
    }
    public static void doSomething(){
        try{
            Thread.sleep(new Random().nextInt(100));
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
