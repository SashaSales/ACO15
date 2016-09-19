package ua.artcode.view.swing.viewInfo.viewListUsers;

import ua.artcode.model.Worker;

import javax.swing.*;
import java.awt.*;

/**
 * Created by work on 19.09.2016.
 */
public class ViewListServicesOfWorker extends JFrame{

    private Worker worker;

    public ViewListServicesOfWorker(Worker worker) throws HeadlessException {

        setTitle("Services of Worker");
        setSize(600,600);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.worker = worker;
        init();
    }

    private void init() {

        GridLayout gridLayout = new GridLayout(worker.getService().size()*3,1);
        setLayout(gridLayout);

        JLabel [] servicesOfWorkersLabel = new JLabel [worker.getService().size()];
        JTextField [] detailedInfoServiceText = new JTextField [worker.getService().size()];

        for (int i = 0; i < worker.getService().size(); i++) {
            servicesOfWorkersLabel[i] = new JLabel((i+1) + ". Service name: " + worker.getService().get(i).getNameService());
            JTextField empty = new JTextField ("Description service:");
            detailedInfoServiceText[i] = new JTextField(worker.getService().get(i).getDescriptionService());
            getContentPane().add(servicesOfWorkersLabel[i]);
            getContentPane().add(empty);
            getContentPane().add(detailedInfoServiceText[i]);
        }

        //detailedInfoServiceText[i].setText("Detailed info Service. " + worker.getService().get(i).getDescriptionService());
       //getContentPane().add(detailedInfoServiceText[i]);
    }
}
