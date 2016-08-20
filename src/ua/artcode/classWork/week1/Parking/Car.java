package ACO15.GIT.src.ua.artcode.classWork.week1.Parking;

public class Car {

    private String number;
    private String model;
    private Driver driver;

    public void init(String number, String model, Driver driver){
    this.number = number;
    this.model = model;
    this.driver = driver;
    }

    public String asString(){
    return String.format("number : %s, model %s, driver %s",
    number,model,driver.asString());
    }

}
