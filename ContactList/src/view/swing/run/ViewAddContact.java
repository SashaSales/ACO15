package view.swing.run;

import exceptions.AddContactException;
import controller.IControllerlist;
import model.Contact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by work on 25.09.2016.
 */
public class ViewAddContact extends JFrame {

    private IControllerlist iControllerlist;
    JList listOfContacts;

    public ViewAddContact(IControllerlist iControllerlist) throws HeadlessException {

        this.iControllerlist = iControllerlist;

        setTitle("Add contact");
        setVisible(true);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(350,200));
        setMaximumSize(new Dimension(500, 350));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        init();

    }

    private void init() {

        GridLayout gridLayout = new GridLayout(7,1);
        setLayout(gridLayout);

        JLabel nameLabel = new JLabel("Contact name ");
        JTextField nameText = new JTextField();
        JLabel phoneLabel = new JLabel("Contact phone");
        JTextField phoneText = new JTextField();
        JLabel emailLabel = new JLabel("Contact e-mail");
        JTextField emailText = new JTextField();

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    iControllerlist.addContact(nameText.getText(), phoneText.getText(), emailText.getText());
                    JOptionPane.showConfirmDialog(ViewAddContact.this, "Contact has been successfully added.", "SUCCESS", JOptionPane.DEFAULT_OPTION);
                    dispose();
                    new ViewMainFrame(iControllerlist);

                    //todo не работает refreshInfo()

                } catch (AddContactException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        getContentPane().add(nameLabel);
        getContentPane().add(nameText);
        getContentPane().add(phoneLabel);
        getContentPane().add(phoneText);
        getContentPane().add(emailLabel);
        getContentPane().add(emailText);
        getContentPane().add(saveButton);

    }

    public void refreshInfo() {

            Contact [] contacts = new Contact[iControllerlist.getContactList().size()];
            System.arraycopy(iControllerlist.getContactList().toArray(), 0, contacts, 0, iControllerlist.getContactList().size());
            listOfContacts.setListData(contacts);
    }

}
