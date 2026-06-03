import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<BankAccount> accounts =
                new ArrayList<>();

        accounts.add(
                new BankAccount(
                        "1001",
                        "Lahya",
                        50000,
                        1111));

        accounts.add(
                new BankAccount(
                        "1002",
                        "Rahul",
                        35000,
                        2222));

        accounts.add(
                new BankAccount(
                        "1003",
                        "Priya",
                        80000,
                        3333));

        new LoginFrame(accounts);
    }
}