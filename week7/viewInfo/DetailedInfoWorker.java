package ua.artcode.view.swing.viewInfo;

import ua.artcode.model.Worker;
import ua.artcode.view.swing.viewInfo.viewListUsers.ViewListServicesOfWorker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by work on 18.09.2016.
 */
public class DetailedInfoWorker extends JFrame {

    Worker worker;

    public DetailedInfoWorker(Worker worker) throws HeadlessException {

        setTitle("Detailed info Worker - " + worker.getFullname());
        setSize(600,200);
        this.worker = worker;
        init();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void init() {

        GridLayout gridLayout = new GridLayout(5,2);
        setLayout(gridLayout);

        JLabel rateLabel = new JLabel("Rate");
        JTextField rateText = new JTextField();
        rateText.setEditable(false);
        rateText.setText("****");

        JLabel nameLabel = new JLabel("Name");
        JTextField nameText = new JTextField();
        nameText.setEditable(false);
        nameText.setText(worker.getFullname());

        JLabel phoneLabel = new JLabel("Phone number");
        JTextField phoneText = new JTextField();
        phoneText.setEditable(false);
        phoneText.setText(worker.getPhone());

        JLabel emailLabel = new JLabel("E-mail");
        JTextField emailText = new JTextField();
        emailText.setEditable(false);
        emailText.setText(worker.getEmail());

        JLabel servicesLabel = new JLabel("Services worker");
        JButton servicesButton = new JButton("Показать сервисы Worker");
        servicesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewListServicesOfWorker(worker);
            }
        });

        getContentPane().add(rateLabel);
        getContentPane().add(rateText);
        getContentPane().add(nameLabel);
        getContentPane().add(nameText);
        getContentPane().add(phoneLabel);
        getContentPane().add(phoneText);
        getContentPane().add(emailLabel);
        getContentPane().add(emailText);
        getContentPane().add(servicesLabel);
        getContentPane().add(servicesButton);

    }


}
