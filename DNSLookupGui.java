

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class DNSLookupGui {
    

    public static void main(String[] args) {

        JFrame frame = new JFrame("DNSLookup Tool");
        
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        
        placeComponents(panel);
        frame.setVisible(true);

    }

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        // Host label
        JLabel hostLabel = new JLabel("Host:");
        hostLabel.setBounds(10,30,80,25);
        panel.add(hostLabel);

        // hostText
        JTextField hostText = new JTextField(20);
        hostText.setBounds(100,30,165,25);
        panel.add(hostText);

        // Address label
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(10,60,80,25);
        panel.add(addressLabel);


        // addressText
        JTextField addressText = new JTextField(20);
        addressText.setBounds(100,60,165,25);
        panel.add(addressText);


        // look up button
        JButton lookupButton = new JButton("LookUp");
        lookupButton.setBounds(10, 100, 80, 25);
        panel.add(lookupButton);

        // clear button
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(100, 100, 80, 25);
        panel.add(clearButton);


        lookupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String hostname = hostText.getText();
                try {
                    InetAddress host = InetAddress.getByName(hostname);
                    addressText.setText(host.getHostAddress());

                } catch (UnknownHostException err) {
                    JOptionPane.showMessageDialog(panel,"Please enter the normal host name");
                    err.printStackTrace();
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hostText.setText(null);
                addressText.setText(null);
            }
        });
    }


}
