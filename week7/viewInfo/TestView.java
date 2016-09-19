package ua.artcode.view.swing.viewInfo;

import ua.artcode.exceptions.AppDbException;
import ua.artcode.model.*;
import ua.artcode.utils.Constants;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by work on 18.09.2016.
 */
public class TestView {

    public static void main(String[] args) throws AppDbException {

        List<Service> services = new ArrayList<>();

        Service service1 = new Service("Development Soft", "Create application for your bussiness");
        services.add(service1);
        service1.setRateService(Rate.Rate1);

        List<Worker> workers = new ArrayList<>();
        Worker worker1 = new Worker("Sergey", "sergey@gmail.com", "0930930939", "12345678", Constants.statusClientRole.WORKER);
        Worker worker2 = new Worker("Ivan", "ivan@gmail.com", "0930930939", "12345678", Constants.statusClientRole.WORKER);
        Worker worker3 = new Worker("Elena", "elena@gmail.com", "0930930939", "12345678", Constants.statusClientRole.WORKER);
        worker1.setService(services);
        worker2.setService(services);
        worker3.setService(services);

        workers.add(worker1);
        workers.add(worker2);
        workers.add(worker3);

        Moderator moderator1 = new Moderator("Fedir", "fedir@gmail.com", "0930999999", "12345678", Constants.statusClientRole.MODERATOR, workers);
        moderator1.setServices(services);

        service1.setWorkers(workers);


        List<Client> clients = new ArrayList<>();
        Client client1 = new Client("Galina", "galina@gmail.com", "0930930939", "12345678", Constants.statusClientRole.CLIENT);
        Client client2 = new Client("Anya", "anya@gmail.com", "0930930939", "12345678", Constants.statusClientRole.CLIENT);
        Client client3 = new Client("Roman", "roman@gmail.com", "0930930939", "12345678", Constants.statusClientRole.CLIENT);
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);


        List<Comment> comments = new ArrayList<>();
        Comment comment1 = new Comment("Bad Worker Ivan", "Ivan done bad work", client1, new Date());
        Comment comment2 = new Comment("Bad Worker Elena", "I recomend don`t treat to Company WEST_HOLDING", client2, new Date());
        Comment comment3 = new Comment("Good Worker Sergey", "Sergey done work well", client3, new Date());
        comments.add(comment1);
        comments.add(comment2);
        comments.add(comment3);

        service1.setCommentsService(comments);

        new DetailedInfoService(service1);

    }
}
