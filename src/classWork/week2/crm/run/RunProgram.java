package ua.artcode.classWork.week2.crm.run;
import ua.artcod.classWork.week2.crm.db.AppDB;
import ua.artcod.classWork.week2.crm.controller.ManagerControllerImpl;
import ua.artcod.classWork.week2.crm.model.Dev;
import ua.artcod.classWork.week2.crm.model.Manager;
import ua.artcod.classWork.week2.crm.model.Project;

import java.util.Scanner;
/**
 * Created by work on 14.08.2016.
 */
public class RunProgram {

        public static void main(String[] args) {
            AppDB appDB = new AppDB();
            appDB.addDev(new Dev("Ivan", "sdfsd"));
            appDB.addDev(new Dev("Yura", "2323"));
            appDB.addDev(new Dev("Rick", "234sfjjsd"));

            appDB.addManager(new Manager("Olya", "sdfsdfs"));
            appDB.addManager(new Manager("Ira", "sdfsdfs"));
            appDB.addManager(new Manager("Serafima", "sdfsdfs"));


            ManagerControllerImpl logicMethods = new ManagerControllerImpl(appDB);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Input your id");
            String ownerId = scanner.nextLine();
            System.out.println("Input project name");
            String projectName = scanner.nextLine();
            System.out.println("Input project description");
            String projectDesc = scanner.nextLine();

            Project created =
                    logicMethods.createProject(Long.parseLong(ownerId),
                            projectName, projectDesc);

                System.out.println(created.asString());


        }

}
