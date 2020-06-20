package pro.edu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class LogsServiceImpl {

    private String dateTime;

    public LogsServiceImpl() {
    }

    public LogsServiceImpl(String dateTime) {
        this.dateTime = dateTime;
    }
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

/*
*
* @param String str - a date of searching in a format yyyy-mm-dd
*
* */

    public int getLogsByDate(String str) throws IOException {
        LocalDateTime start = LocalDateTime.now();
        System.out.println(str + " search is started at - " + start);
  /*        String myString = new String(Files.readAllBytes(
                Paths.get("/home/george/Desktop/13-14.txt")));

        String myString2 = myString
             .toLowerCase()
                .replaceAll(",", "")
                .replaceAll("!", "")
                .replaceAll("\\?", "")
                .replaceAll("\\.", "")
                .replaceAll("\"", "")

                .replaceAll("[^A-Za-z ]", "")
                ;
                String[] array = myString2.split("\\n");
   */
        int count = (int) Files.lines(Paths.get("/home/george/Desktop/logs.txt"))
                .filter(line -> line.contains(str))
               // .filter(line -> line.contains("ERROR"))
                .count();

        LocalDateTime finish = LocalDateTime.now();


        long duration = ChronoUnit.MILLIS.between(start, finish);

        System.out.println(str + " search is OVER at - " + LocalDateTime.now() + ". duration - "+ duration);
        System.out.println("lines amount - " + count);

        return count;
    }

    private void toFile(List<String> list, String fileAndPath) throws IOException {

        String stringToFile = "";

        for (String line:list){
            stringToFile += line + System.lineSeparator();
        }
        Files.write(Paths.get(fileAndPath), stringToFile.getBytes());

    }


}
