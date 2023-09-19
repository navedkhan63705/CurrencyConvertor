package currencyconvertorjjava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter extends JFrame {
    private JComboBox<String> fromCurrencyComboBox;
    private JComboBox<String> toCurrencyComboBox;
    private JTextField amountTextField;
    private JTextField resultTextField;

    private String[] currencyUnits = {
            "Choose One...",
            "US Dollar",
            "Nigerian Naira",
            "Brazilian Real",
            "Canadian Dollar",
            "Kenyan Shilling",
            "Indian Rupee",
            "Philippine Peso",
            "Pakistan Rupee"
    };

    private double[] exchangeRates = {
            0.0,     // Placeholder for "Choose One..."
            1.34,    // US Dollar
            952.31,  // Nigerian Naira
            6.23,    // Brazilian Real
            1.71,    // Canadian Dollar
            183.28,  // Kenyan Shilling
            95.21,   // Indian Rupee
            71.16,   // Philippine Peso
            384.56   // Pakistan Rupee
    };

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new GridLayout(5, 2, 10, 10));

        JLabel fromCurrencyLabel = new JLabel("From Currency:");
        fromCurrencyComboBox = new JComboBox<>(currencyUnits);
        JLabel toCurrencyLabel = new JLabel("To Currency:");
        toCurrencyComboBox = new JComboBox<>(currencyUnits);
        JLabel amountLabel = new JLabel("Amount:");
        amountTextField = new JTextField();
        JLabel resultLabel = new JLabel("Result:");
        resultTextField = new JTextField();
        resultTextField.setEditable(false);

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        add(fromCurrencyLabel);
        add(fromCurrencyComboBox);
        add(toCurrencyLabel);
        add(toCurrencyComboBox);
        add(amountLabel);
        add(amountTextField);
        add(resultLabel);
        add(resultTextField);
        add(new JLabel()); // Empty label for spacing
        add(convertButton);

        setLocationRelativeTo(null); // Center the window
    }

    private void convertCurrency() {
        int fromCurrencyIndex = fromCurrencyComboBox.getSelectedIndex();
        int toCurrencyIndex = toCurrencyComboBox.getSelectedIndex();

        if (fromCurrencyIndex != 0 && toCurrencyIndex != 0) {
            double amountToChange = Double.parseDouble(amountTextField.getText());
            double exchangeRate = exchangeRates[toCurrencyIndex] / exchangeRates[fromCurrencyIndex];
            double amountChanged = amountToChange * exchangeRate;
            resultTextField.setText(String.format("%.2f", amountChanged));
        } else {
            resultTextField.setText("Invalid selection");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CurrencyConverter converter = new CurrencyConverter();
                converter.setVisible(true);
            }
        });
    }
}
