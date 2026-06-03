import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionManager {

    public static String getTimeStamp() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(
                        "dd-MM-yyyy HH:mm:ss");

        return LocalDateTime.now().format(formatter);
    }

    public static void saveTransaction(String text) {

        try {

            FileWriter writer =
                    new FileWriter(
                            "transactions.txt",
                            true);

            writer.write(text + "\n");
            writer.close();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static String receipt(
            String type,
            double amount,
            double balance) {

        return
                "\n========================\n" +
                "ATM RECEIPT\n" +
                "Date : " + getTimeStamp() + "\n" +
                "Type : " + type + "\n" +
                "Amount : ₹" + amount + "\n" +
                "Balance : ₹" + balance +
                "\n========================";
    }
}