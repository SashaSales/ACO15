package view.swing.run;

import controller.IControllerlist;
import exceptions.AddContactException;
import exceptions.RemoveContactException;
import model.Contact;
import utils.IOutils;
import utils.IOutilsImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by work on 25.09.2016.
 */
public class ViewInfoContact extends JFrame {

    private Contact oldContact;
    private String phoneNumber;
    private IControllerlist iControllerlist;

    public ViewInfoContact(IControllerlist iControllerlist, Contact oldContact) throws HeadlessException {

        this.iControllerlist = iControllerlist;
        this.oldContact = oldContact;
        this.phoneNumber = phoneNumber;
        setMinimumSize(new Dimension(350,200));
        setMaximumSize(new Dimension(500, 350));

        setVisible(true);
        setTitle("Contact info");
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        init();

    }

    private void init() {

        GridLayout gridLayout = new GridLayout(7,1);
        setLayout(gridLayout);

        JLabel nameLabel = new JLabel("Contact name ");
        JTextField nameText = new JTextField();
        nameText.setText(oldContact.getName());
        JLabel phoneLabel = new JLabel("Contact phone");
        JTextField phoneText = new JTextField();
        phoneText.setText(oldContact.getPhoneNumber());
        JLabel emailLabel = new JLabel("Contact e-mail");
        JTextField emailText = new JTextField();
        emailText.setText(oldContact.getEmail());

        JPanel floorButtons = new JPanel(new GridLayout(1,2));
        JButton saveButton = new JButton("Save");
        JButton exitButton = new JButton("Exit");
        floorButtons.add(saveButton);
        floorButtons.add(exitButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    if (phoneText.getText().equals(oldContact.getPhoneNumber())){
                        iControllerlist.addContact(nameText.getText(), phoneText.getText(), emailText.getText());

                    } else {
                        iControllerlist.removeContact(oldContact.getName());
                        iControllerlist.addContact(nameText.getText(), phoneText.getText(), emailText.getText());

                    }

                    JOptionPane.showConfirmDialog(ViewInfoContact.this, "Contact has been successfully UpDate.", "SUCCESS", JOptionPane.DEFAULT_OPTION);
                    new ViewMainFrame(iControllerlist);

                    //todo не работает refreshInfo()

                } catch (AddContactException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (RemoveContactException e1) {
                    e1.printStackTrace();
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    iControllerlist.saveDB();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                dispose();
            }
        });

        getContentPane().add(nameLabel);
        getContentPane().add(nameText);
        getContentPane().add(phoneLabel);
        getContentPane().add(phoneText);
        getContentPane().add(emailLabel);
        getContentPane().add(emailText);
        getContentPane().add(floorButtons);

    }

}
