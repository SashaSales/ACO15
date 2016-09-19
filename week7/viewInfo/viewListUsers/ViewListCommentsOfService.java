package ua.artcode.view.swing.viewInfo.viewListUsers;

import ua.artcode.model.Service;

import javax.swing.*;
import java.awt.*;

/**
 * Created by work on 19.09.2016.
 */
public class ViewListCommentsOfService extends JFrame{

    private Service service;

    public ViewListCommentsOfService(Service service) throws HeadlessException {

        setTitle("Comments to the Service");
        setSize(600,600);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.service = service;
        init();

    }

    private void init() {

        GridLayout gridLayout = new GridLayout(service.getCommentsService().size()*3, 1);
        setLayout(gridLayout);

        JLabel [] commentTitleLabel = new JLabel[service.getCommentsService().size()];
        JTextArea [] commentBodyText = new JTextArea [service.getCommentsService().size()];
        JTextField [] commentCreatorText = new JTextField[service.getCommentsService().size()];
        JTextField [] commentTimeText = new JTextField[service.getCommentsService().size()];

        JPanel [] commentCreatorTime = new JPanel[service.getCommentsService().size()];

        for (int i = 0; i < service.getCommentsService().size(); i++) {
            commentTitleLabel[i] = new JLabel((i+1) + ". " + service.getCommentsService().get(i).getTitle());
            commentBodyText [i] = new JTextArea(service.getCommentsService().get(i).getBody());
            commentBodyText [i].setEditable(false);
            commentCreatorText[i] = new JTextField(service.getCommentsService().get(i).getOwner().getFullname());
            commentCreatorText[i].setEditable(false);
            commentTimeText[i] = new JTextField(service.getCommentsService().get(i).getCreatedTime().toString());
            commentTimeText[i].setEditable(false);
            commentCreatorTime [i] = new JPanel (new GridLayout(1, 2));
            commentCreatorTime[i].add(commentTimeText[i]);
            commentCreatorTime[i].add(commentCreatorText[i]);
            getContentPane().add(commentTitleLabel[i]);
            getContentPane().add(commentCreatorTime [i]);
            getContentPane().add(commentBodyText[i]);

        }


    }


}
