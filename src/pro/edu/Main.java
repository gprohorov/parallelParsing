package pro.edu;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Main {

    static class MyFirstThread extends Thread {

        @Override
        public void run() {
            LogsServiceImpl service1 = new LogsServiceImpl();
            try {
                service1.getLogsByDate("2019-10-14");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyThread extends Thread {

         private String date;

         MyThread(String date){
             this.date = date;
         }

        @Override
        public void run() {
            LogsServiceImpl service = new LogsServiceImpl();
            try {
                service.getLogsByDate(date);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws IOException {

        LogsServiceImpl service1 = new LogsServiceImpl();
        LocalDateTime start = LocalDateTime.now();

/**/
        new MyFirstThread().start();  // 13 October
        new MyThread("2019-10-16").start();
        new MyThread("2019-10-17").start();
        new MyThread("2019-10-18").start();
        new MyThread("2019-10-19").start();






        System.out.println("TOTAL DURATION of threads"
                + ChronoUnit.MILLIS.between(start, LocalDateTime.now()) + " ms");

      System.out.println("---------------------");
        start = LocalDateTime.now();

        service1.getLogsByDate("2019-10-14");
        service1.getLogsByDate("2019-10-16");
        service1.getLogsByDate("2019-10-17");
        service1.getLogsByDate("2019-10-18");
        service1.getLogsByDate("2019-10-19");

        System.out.println("TOTAL DURATION concequently "
                + ChronoUnit.MILLIS.between(start, LocalDateTime.now()) + " ms");
 /*
*/
    }
}
