import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.DecimalFormat;

public class ATMFrame extends JFrame {

    private BankAccount account;
    private JTextArea area;
    private JLabel balanceLabel;

    private DecimalFormat df =
        new DecimalFormat("#,##0.00");

    public ATMFrame(BankAccount account) {

        this.account = account;

        setTitle("ATM Banking Dashboard");
        setSize(1300, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // ================= HEADER =================

        JPanel header = new JPanel();

        header.setBackground(
                new Color(
                        0,
                        45,
                        110));

        header.setPreferredSize(
                new Dimension(
                        100,
                        80));

        JLabel title =
                new JLabel(
                        "ATM BANKING SYSTEM");

        title.setForeground(
                Color.WHITE);

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28));

        header.add(title);

        add(header,
                BorderLayout.NORTH);

        // ================= PROFILE PANEL =================

        JPanel profilePanel =
                new JPanel();

        profilePanel.setLayout(
                new BoxLayout(
                        profilePanel,
                        BoxLayout.Y_AXIS));

        profilePanel.setBackground(
                new Color(
                        20,
                        30,
                        50));

        profilePanel.setPreferredSize(
                new Dimension(
                        300,
                        100));

        profilePanel.setBorder(
                new EmptyBorder(
                        30,
                        20,
                        30,
                        20));

        JLabel icon =
        new JLabel("USER");

icon.setFont(
        new Font(
                "Segoe UI Emoji",
                Font.PLAIN,
                50));

icon.setForeground(Color.WHITE);

profilePanel.add(icon);
profilePanel.add(Box.createVerticalStrut(15));

        JLabel welcome =
                new JLabel(
                        "Welcome");

        welcome.setForeground(
                Color.WHITE);

        welcome.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        22));

        JLabel name =
                new JLabel(
                        account.getAccountHolder());

        name.setForeground(
                new Color(
                        0,
                        180,
                        255));

        name.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28));

        JLabel accNo =
                new JLabel(
                        "Account : "
                                + account.getAccountNumber());

        accNo.setForeground(
                Color.LIGHT_GRAY);

        accNo.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16));

        balanceLabel =
                new JLabel(
                        "Balance : Rs."
                                + df.format(
                                            account.getBalance()));

        balanceLabel.setForeground(
                new Color(
                        0,
                        220,
                        120));

        balanceLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        20));

        profilePanel.add(welcome);
        profilePanel.add(Box.createVerticalStrut(10));
        profilePanel.add(name);
        profilePanel.add(Box.createVerticalStrut(20));
        profilePanel.add(accNo);
        profilePanel.add(Box.createVerticalStrut(20));
        profilePanel.add(balanceLabel);

        add(profilePanel,
                BorderLayout.WEST);

        // ================= TRANSACTION AREA =================

        area =
                new JTextArea();

                area.setText(
        "\n"
      + "=====================================\n"
      + "      ATM BANKING DASHBOARD\n"
      + "=====================================\n\n"
      + "Welcome "
      + account.getAccountHolder()
      + "\n\n"
      + "Choose an option below.\n\n"
      + "-Check Balance\n"
      + "-Deposit Money\n"
      + "-Withdraw Money\n"
      + "-Transfer Money\n"
      + "-Change PIN\n"
      + "-View Transaction History\n");

        area.setEditable(false);

        area.setFont(
                new Font(
                        "Consolas",
                        Font.PLAIN,
                        15));

        area.setMargin(
                new Insets(
                        15,
                        15,
                        15,
                        15));

        JScrollPane scroll =
                new JScrollPane(area);

        add(scroll,
                BorderLayout.CENTER);

        // ================= DASHBOARD =================

        JPanel dashboard =
                new JPanel();

        dashboard.setLayout(
                new GridLayout(
                        1,
                        8,
                        10,
                        10));

        dashboard.setBorder(
                new EmptyBorder(
                        20,
                        20,
                        20,
                        20));

        JButton balanceBtn =
                createCardButton(
                        "Balance");

        JButton depositBtn =
                createCardButton(
                        "Deposit");

        JButton withdrawBtn =
                createCardButton(
                        "Withdraw");

        JButton transferBtn =
                createCardButton(
                        "Transfer");

        JButton historyBtn =
                createCardButton(
                        "History");

        JButton pinBtn =
                createCardButton(
                        "Change PIN");

        JButton fastCashBtn =
                createCardButton(
                        "Fast Cash");

        JButton logoutBtn =
                createCardButton(
                        "Logout");

        dashboard.add(balanceBtn);
        dashboard.add(depositBtn);
        dashboard.add(withdrawBtn);
        dashboard.add(transferBtn);

        dashboard.add(historyBtn);
        dashboard.add(pinBtn);
        dashboard.add(fastCashBtn);
        dashboard.add(logoutBtn);

        add(dashboard,
                BorderLayout.SOUTH);

        // ================= EVENTS =================

        balanceBtn.addActionListener(
                e -> showBalance());

        depositBtn.addActionListener(
                e -> deposit());

        withdrawBtn.addActionListener(
                e -> withdraw());

        transferBtn.addActionListener(
                e -> transfer());

        historyBtn.addActionListener(
                e -> showHistory());

        pinBtn.addActionListener(
                e -> changePin());

        fastCashBtn.addActionListener(
                e -> fastCash());

        logoutBtn.addActionListener(
                e -> {

                    dispose();

                    JOptionPane.showMessageDialog(
                            null,
                            "Logged Out Successfully");
                });

        setVisible(true);
    }

        private JButton createCardButton(
            String text) {

        JButton btn =
                new JButton(text);

        btn.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18));

        btn.setBackground(
                new Color(
                        0,
                        120,
                        255));

        btn.setForeground(
                Color.WHITE);

        btn.setFocusPainted(false);

        return btn;
    }

    private void refreshBalance() {

    balanceLabel.setText(
            "Balance : Rs."
                    + df.format(
                            account.getBalance()));
}

    private void showBalance() {

        area.append(
                "\n========================================\n");

        area.append(
        "AVAILABLE BALANCE : Rs."
                + df.format(
                        account.getBalance()));

        area.append(
                "\n========================================\n");
    }

    private void deposit() {

        try {

            String input =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Deposit Amount");

            if(input == null)
                return;

            double amount =
                    Double.parseDouble(input);

            if(amount <= 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Enter a valid amount");

                return;
            }

            account.deposit(amount);

            String receipt =
                    TransactionManager.receipt(
                            "Deposit",
                            amount,
                            account.getBalance());

            account.addHistory(receipt);

            TransactionManager.saveTransaction(
                    receipt);

            area.append(receipt);

            refreshBalance();

        } catch(Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Amount");
        }
    }

    private void withdraw() {

        try {

            String input =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Withdrawal Amount");

            if(input == null)
                return;

            double amount =
                    Double.parseDouble(input);

            if(amount <= 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Enter a valid amount");

                return;
            }

            if(account.withdraw(amount)) {

                String receipt =
                        TransactionManager.receipt(
                                "Withdrawal",
                                amount,
                                account.getBalance());

                account.addHistory(receipt);

                TransactionManager.saveTransaction(
                        receipt);

                area.append(receipt);

                refreshBalance();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Insufficient Balance");
            }

        } catch(Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Amount");
        }
    }

        private void transfer() {

        try {

            String target =
                    JOptionPane.showInputDialog(
                            this,
                            "Target Account Number");

            if(target == null ||
                    target.trim().isEmpty())
                return;

            String amountText =
                    JOptionPane.showInputDialog(
                            this,
                            "Transfer Amount");

            if(amountText == null)
                return;

            double amount =
                    Double.parseDouble(
                            amountText);

            if(amount <= 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Enter a valid amount");

                return;
            }

            if(account.transfer(amount)) {

                String receipt =
                        TransactionManager.receipt(
                                "Transfer to "
                                        + target,
                                amount,
                                account.getBalance());

                account.addHistory(receipt);

                TransactionManager.saveTransaction(
                        receipt);

                area.append(receipt);

                refreshBalance();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Insufficient Balance");
            }

        } catch(Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Input");
        }
    }

    private void showHistory() {

        area.append(
                "\n\n=========== HISTORY ===========\n");

        if(account.getHistory().isEmpty()) {

            area.append(
                    "No transactions found.\n");

            return;
        }

        for(String h :
                account.getHistory()) {

            area.append(h + "\n");
        }
    }

    private void changePin() {

        try {

            String newPin =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter New 4 Digit PIN");

            if(newPin == null)
                return;

            if(newPin.length() != 4) {

                JOptionPane.showMessageDialog(
                        this,
                        "PIN must be exactly 4 digits");

                return;
            }

            Integer.parseInt(newPin);

            account.changePin(
                    Integer.parseInt(
                            newPin));

            area.append(
                    "\nPIN Changed Successfully\n");

            JOptionPane.showMessageDialog(
                    this,
                    "PIN Changed Successfully");

        } catch(Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid PIN");
        }
    }

    private void fastCash() {

        String[] options =
                {
                        "500",
                        "1000",
                        "2000",
                        "5000"
                };

        String choice =
                (String)
                        JOptionPane.showInputDialog(
                                this,
                                "Select Amount",
                                "Fast Cash",
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                options,
                                options[0]);

        if(choice == null)
            return;

        double amount =
                Double.parseDouble(choice);

        if(account.withdraw(amount)) {

            String receipt =
                    TransactionManager.receipt(
                            "Fast Cash",
                            amount,
                            account.getBalance());

            account.addHistory(receipt);

            TransactionManager.saveTransaction(
                    receipt);

            area.append(receipt);

            refreshBalance();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Insufficient Balance");
        }
    }
}