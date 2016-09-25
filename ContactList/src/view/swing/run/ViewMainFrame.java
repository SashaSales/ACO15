package view.swing.run;

import controller.IControllerlist;
import model.Contact;
import exceptions.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.NavigableSet;

/**
 * Created by work on 17.09.2016.
 */
public class ViewMainFrame extends JFrame {

    private IControllerlist iControllerlist;

    public ViewMainFrame(IControllerlist iControllerlist) throws HeadlessException{

        this.iControllerlist = iControllerlist;

        setVisible(true);
        setTitle("MainWindow");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(600,200));
        setMaximumSize(new Dimension(500, 350));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        init();

    }

    private void init() {

        GridLayout gridLayout = new GridLayout(5,1);
        setLayout(gridLayout);

        JLabel headList = new JLabel("Contact List", JLabel.CENTER);

        JMenuBar menu = new JMenuBar();
        JMenu function = new JMenu("File");
        JMenuItem reductTheme = new JMenuItem("Choose color of theme");
        function.add(reductTheme);
        menu.add(function);



        JPanel namesRows = new JPanel(new GridLayout(1,3));
        JTextField name = new JTextField("Name");
        name.setEditable(false);
        JTextField phone = new JTextField("Phone");
        phone.setEditable(false);
        JTextField email = new JTextField("Email");
        email.setEditable(false);
        namesRows.add(name);
        namesRows.add(phone);
        namesRows.add(email);


        JPanel listOfContacts = new JPanel(new GridLayout(iControllerlist.getContactList().size(), 3));
        //JPanel panelForIcons = new JPanel(new GridLayout(1,2));
        ImageIcon deleteContactIcon = new ImageIcon("temp/iconDeleteContact.jpg");
        ImageIcon infoContactIcon = new ImageIcon("temp/iconInfoContact.png");

/*        JButton deleteContactButton = new JButton(deleteContactIcon);
        JButton infoContactButton = new JButton(infoContactIcon);
        panelForIcons.add(deleteContactButton);
        panelForIcons.add(infoContactButton);*/


        for (Contact contact : iControllerlist.getContactList()) {
                    JTextField nameContact = new JTextField(contact.getName());
                    nameContact.setEditable(false);
                    JTextField phoneContact = new JTextField(contact.getPhoneNumber());
                    phoneContact.setEditable(false);
                    JTextField emailContact = new JTextField(contact.getEmail());
                    emailContact.setEditable(false);

                    JPanel panelForIcons = new JPanel(new GridLayout(1,2));
                    JButton deleteContactButton = new JButton("Delete", deleteContactIcon);
                    deleteContactButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            try {
                                iControllerlist.removeContact(contact.getName());
                            } catch (RemoveContactException e1) {
                                e1.printStackTrace();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                            dispose();
                            new ViewMainFrame(iControllerlist);

                        }
                    });
                    JButton infoContactButton = new JButton("Info", infoContactIcon);
                    infoContactButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            new ViewInfoContact(iControllerlist, contact);
                        }
                    });

            panelForIcons.add(deleteContactButton);
            panelForIcons.add(infoContactButton);


            listOfContacts.add(nameContact);
            listOfContacts.add(phoneContact);
            listOfContacts.add(emailContact);
            listOfContacts.add(panelForIcons);
        }


        JScrollPane jScrollPane = new JScrollPane(listOfContacts);

        JPanel functionalButtons = new JPanel(new GridLayout(1,4));
        JButton addContact = new JButton("Add");
        addContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewAddContact(iControllerlist);
            }
        });

        JButton deleteContact = new JButton("Remove");
        JButton upDateContact = new JButton("Update");

        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
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

        functionalButtons.add(addContact);
        functionalButtons.add(deleteContact);
        functionalButtons.add(upDateContact);
        functionalButtons.add(exit);


        getContentPane().add(headList);
        getContentPane().add(menu);
       // getContentPane().add(panelForIcons);
        getContentPane().add(namesRows);
        getContentPane().add(jScrollPane);
        getContentPane().add(functionalButtons);

    }

}
