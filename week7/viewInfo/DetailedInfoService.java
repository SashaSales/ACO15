package ua.artcode.view.swing.viewInfo;

import ua.artcode.model.Service;
import ua.artcode.view.swing.viewInfo.viewListUsers.ViewListCommentsOfService;
import ua.artcode.view.swing.viewInfo.viewListUsers.ViewListWorkers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by work on 18.09.2016.
 */
public class DetailedInfoService extends JFrame{

    private Service service;

    public DetailedInfoService(Service service) throws HeadlessException {

        setTitle("Detailed info Service - " + service.getNameService());
        setSize(600,200);
        this.service = service;
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        init();
    }

    private void init() {


        GridLayout gridLayout = new GridLayout(2,1);
        setLayout(gridLayout);

        JPanel firstLayout = new JPanel(new GridLayout(3,2));

        JLabel rateLabel = new JLabel("Rate");
        JTextField rateText = new JTextField();
        rateText.setEditable(false);
        rateText.setText(service.getRateService());

        JLabel countOfWorkersLabel = new JLabel("Count Workers of Service");
        JTextField countOfWorkersText = new JTextField();
        countOfWorkersText.setEditable(false);
        countOfWorkersText.setText(String.valueOf(service.getWorkers().size()));

        JPanel countWorkers = new JPanel(new GridLayout(1,2));
        countWorkers.add(countOfWorkersLabel);
        countWorkers.add(countOfWorkersText);

        JButton showWorkers = new JButton("Показать список Workers");
        showWorkers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewListWorkers(service);
            }
        });

        JPanel countComment = new JPanel(new GridLayout(1,2));
        JLabel commentsOfServiceLabel = new JLabel("Count comments of Service");
        JTextField countOfCommentsText = new JTextField();
        countOfCommentsText.setEditable(false);
        countOfCommentsText.setText(String.valueOf(service.getCommentsService().size()));
        countComment.add(commentsOfServiceLabel);
        countComment.add(countOfCommentsText);

        JButton showComments = new JButton("Показать список комментариев");
        showComments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewListCommentsOfService(service);
            }
        });


        JTextArea textArea = new JTextArea();
        textArea.setText(service.getDescriptionService());

        getContentPane().add(firstLayout);
        firstLayout.add(rateLabel);
        firstLayout.add(rateText);
        firstLayout.add(countWorkers);
        firstLayout.add(showWorkers);
        firstLayout.add(countComment);
        firstLayout.add(showComments);
        getContentPane().add(textArea);

    }
}
