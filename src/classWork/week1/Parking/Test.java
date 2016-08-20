package ACO15.GIT.src.ua.artcode.classWork.week1.Parking;

public class Test {

        public static void main(String[] args) {
        Parking parking = new Parking();
        parking.build(100);

        Driver driver = new Driver();
        driver.init("Oleg","DF121232323");

        Car car = new Car();
        car.init("AN2343","Audi TT",driver);

       // car = null;

        Ticket ticket = parking.acceptCar(car);

        Car myCar = parking.takeCar(ticket);

        }

}
