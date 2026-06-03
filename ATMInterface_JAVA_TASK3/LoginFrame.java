import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LoginFrame extends JFrame {

    private JTextField accField;
    private JPasswordField pinField;

    private ArrayList<BankAccount> accounts;

    public LoginFrame(ArrayList<BankAccount> accounts) {

        this.accounts = accounts;

        setTitle("ATM Banking System");
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        GradientPanel mainPanel = new GradientPanel();
        mainPanel.setLayout(new BorderLayout());

        // ================= LEFT PANEL =================

        JPanel leftPanel = new JPanel();
        leftPanel.setOpaque(false);
        leftPanel.setBorder(
                new EmptyBorder(
                        40,
                        70,
                        40,
                        40));

        leftPanel.setLayout(
                new BoxLayout(
                        leftPanel,
                        BoxLayout.Y_AXIS));

        try {

            ImageIcon icon =
                    new ImageIcon("atm.png");

            Image img =
                    icon.getImage()
                            .getScaledInstance(
                                    250,
                                    250,
                                    Image.SCALE_SMOOTH);

            JLabel image =
                    new JLabel(
                            new ImageIcon(img));

            image.setAlignmentX(
                    Component.CENTER_ALIGNMENT);

            leftPanel.add(image);

        } catch(Exception ex) {

            JLabel imageMissing =
                    new JLabel("ATM");

            imageMissing.setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            60));

            imageMissing.setForeground(
                    Color.WHITE);

            leftPanel.add(imageMissing);
        }

        JLabel welcome =
                new JLabel("WELCOME");

        welcome.setForeground(
                Color.WHITE);

        welcome.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        50));

        JLabel subtitle =
                new JLabel("TO ATM SYSTEM");

        subtitle.setForeground(
                new Color(
                        80,
                        170,
                        255));

        subtitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        30));

        JLabel secure =
                new JLabel(
                        "\u2714 Secure Banking");

        secure.setForeground(
                Color.WHITE);

        secure.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        22));

        JLabel fast =
                new JLabel(
                        "\u2714 Fast Transactions");

        fast.setForeground(
                Color.WHITE);

        fast.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        22));

        JLabel support =
                new JLabel(
                        "\u2714 24/7 Availability");

        support.setForeground(
                Color.WHITE);

        support.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        22));

        JLabel reliable =
                new JLabel(
                        "\u2714 Reliable Service");

        reliable.setForeground(
                Color.WHITE);

        reliable.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        22));

        JLabel timeLabel =
                new JLabel();

        timeLabel.setForeground(
                Color.WHITE);

        timeLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16));

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(
                        "dd MMM yyyy  hh:mm:ss a");

        new Timer(
                1000,
                e -> {

                    timeLabel.setText(
                            LocalDateTime.now()
                                    .format(formatter));
                }).start();

        leftPanel.add(
                Box.createVerticalStrut(15));

        leftPanel.add(welcome);

        leftPanel.add(
                Box.createVerticalStrut(10));

        leftPanel.add(subtitle);

        leftPanel.add(
                Box.createVerticalStrut(40));

        leftPanel.add(secure);

        leftPanel.add(
                Box.createVerticalStrut(15));

        leftPanel.add(fast);

        leftPanel.add(
                Box.createVerticalStrut(15));

        leftPanel.add(support);

        leftPanel.add(
                Box.createVerticalStrut(15));

        leftPanel.add(reliable);

        leftPanel.add(
                Box.createVerticalStrut(40));

        leftPanel.add(timeLabel);

        // ================= LOGIN CARD =================

        JPanel card =
                new JPanel();

        card.setPreferredSize(
                new Dimension(
                        450,
                        560));

        card.setBackground(
                new Color(
                        15,
                        20,
                        45));

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        0,
                                        140,
                                        255),
                                2),
                        new EmptyBorder(
                                30,
                                30,
                                30,
                                30)));

        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS));

        JLabel loginTitle =
                new JLabel(
                        "Login To Your Account");

        loginTitle.setForeground(
                Color.WHITE);

        loginTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28));

        loginTitle.setAlignmentX(
                Component.CENTER_ALIGNMENT);

        JLabel desc =
                new JLabel(
                        "Enter your credentials");

        desc.setForeground(
                Color.LIGHT_GRAY);

        desc.setAlignmentX(
                Component.CENTER_ALIGNMENT);

        desc.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16));

        card.add(loginTitle);

        card.add(
                Box.createVerticalStrut(10));

        card.add(desc);

        card.add(
                Box.createVerticalStrut(40));

                        JLabel accLabel =
                new JLabel(
                        "ACCOUNT NUMBER");

        accLabel.setForeground(
                new Color(
                        70,
                        170,
                        255));

        accLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16));

        accField =
                new JTextField();

        accField.setMaximumSize(
                new Dimension(
                        350,
                        45));

        accField.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        18));

        JLabel pinLabel =
                new JLabel("PIN");

        pinLabel.setForeground(
                new Color(
                        70,
                        170,
                        255));

        pinLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16));

        pinField =
                new JPasswordField();

        pinField.setMaximumSize(
                new Dimension(
                        350,
                        45));

        pinField.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        18));

        JCheckBox showPin =
                new JCheckBox(
                        "Show PIN");

        showPin.setOpaque(false);

        showPin.setForeground(
                Color.WHITE);

        showPin.addActionListener(
                e -> {

                    if(showPin.isSelected()) {

                        pinField.setEchoChar(
                                (char)0);

                    } else {

                        pinField.setEchoChar('*');
                    }
                });

        JButton loginBtn =
                new JButton(
                        "LOGIN");

        loginBtn.setBackground(
                new Color(
                        0,
                        120,
                        255));

        loginBtn.setForeground(
                Color.WHITE);

        loginBtn.setFocusPainted(
                false);

        loginBtn.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18));

        loginBtn.setMaximumSize(
                new Dimension(
                        350,
                        50));

        loginBtn.addActionListener(
                e -> login());

        JButton registerBtn =
                new JButton(
                        "CREATE ACCOUNT");

        registerBtn.setBackground(
                new Color(
                        40,
                        180,
                        99));

        registerBtn.setForeground(
                Color.WHITE);

        registerBtn.setFocusPainted(
                false);

        registerBtn.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16));

        registerBtn.setMaximumSize(
                new Dimension(
                        350,
                        45));

        registerBtn.addActionListener(
                e -> createAccount());

        card.add(accLabel);

        card.add(
                Box.createVerticalStrut(10));

        card.add(accField);

        card.add(
                Box.createVerticalStrut(25));

        card.add(pinLabel);

        card.add(
                Box.createVerticalStrut(10));

        card.add(pinField);

        card.add(
                Box.createVerticalStrut(10));

        card.add(showPin);

        card.add(
                Box.createVerticalStrut(25));

        card.add(loginBtn);

        card.add(
                Box.createVerticalStrut(15));

        card.add(registerBtn);

        JPanel rightPanel =
                new JPanel(
                        new GridBagLayout());

        rightPanel.setOpaque(false);

        rightPanel.add(card);

        JLabel footer =
                new JLabel(
                        "Never share your PIN with anyone. Your security is our priority.",
                        SwingConstants.CENTER);

        footer.setForeground(
                Color.WHITE);

        footer.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14));

        JPanel footerPanel =
                new JPanel();

        footerPanel.setOpaque(false);

        footerPanel.add(footer);

        mainPanel.add(
                leftPanel,
                BorderLayout.WEST);

        mainPanel.add(
                rightPanel,
                BorderLayout.CENTER);

        mainPanel.add(
                footerPanel,
                BorderLayout.SOUTH);

        setContentPane(
                mainPanel);

        setVisible(true);
    }

        private void login() {

        String accNo =
                accField.getText().trim();

        if(accNo.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Enter Account Number");

            return;
        }

        int pin;

        try {

            pin =
                    Integer.parseInt(
                            String.valueOf(
                                    pinField.getPassword()));

        } catch(Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "PIN must contain numbers only");

            return;
        }

        for(BankAccount acc : accounts) {

            if(acc.getAccountNumber()
                    .equals(accNo)) {

                if(acc.isLocked()) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Account Locked\nToo many incorrect login attempts.");

                    return;
                }

                if(acc.validatePin(pin)) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Login Successful");

                    new ATMFrame(acc);

                    dispose();

                    return;
                }

                JOptionPane.showMessageDialog(
                        this,
                        "Incorrect PIN.\nOnly 3 attempts are allowed.");

                return;
            }
        }

        JOptionPane.showMessageDialog(
                this,
                "No account exists with this Account Number.");
    }

    private void createAccount() {

        String name =
                JOptionPane.showInputDialog(
                        this,
                        "Enter Your Name");

        if(name == null || name.trim().isEmpty())
            return;

        String accNo =
                JOptionPane.showInputDialog(
                        this,
                        "Create Account Number");

        if(accNo == null || accNo.trim().isEmpty())
            return;

        for(BankAccount acc : accounts) {

            if(acc.getAccountNumber()
                    .equals(accNo)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Account Number already exists.");

                return;
            }
        }

        String pinText =
                JOptionPane.showInputDialog(
                        this,
                        "Create 4 Digit PIN");

        if(pinText == null)
            return;

        if(pinText.length() != 4) {

            JOptionPane.showMessageDialog(
                    this,
                    "PIN must contain exactly 4 digits");

            return;
        }

        int pin;

        try {

            pin =
                    Integer.parseInt(
                            pinText);

        } catch(Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "PIN must contain numbers only");

            return;
        }

        String amountText =
                JOptionPane.showInputDialog(
                        this,
                        "Initial Deposit");

        if(amountText == null)
            return;

        double balance;

        try {

            balance =
                    Double.parseDouble(
                            amountText);

        } catch(Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Amount");

            return;
        }

        if(balance < 500) {

            JOptionPane.showMessageDialog(
                    this,
                    "Minimum Deposit is ₹500");

            return;
        }

        BankAccount newAccount =
                new BankAccount(
                        accNo,
                        name,
                        balance,
                        pin);

        accounts.add(
                newAccount);

        JOptionPane.showMessageDialog(
                this,
                "Account Created Successfully!\n\n"
                        + "Account Number : "
                        + accNo);
    }

    class GradientPanel extends JPanel {

        @Override
        protected void paintComponent(
                Graphics g) {

            super.paintComponent(g);

            Graphics2D g2 =
                    (Graphics2D) g;

            GradientPaint gp =
                    new GradientPaint(
                            0,
                            0,
                            new Color(
                                    0,
                                    40,
                                    100),

                            getWidth(),
                            getHeight(),

                            new Color(
                                    0,
                                    0,
                                    20));

            g2.setPaint(gp);

            g2.fillRect(
                    0,
                    0,
                    getWidth(),
                    getHeight());
        }
    }
}