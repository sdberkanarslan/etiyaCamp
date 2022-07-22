import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Logger> loggers = new ArrayList<>();
        loggers.add(new DatabaseLogger());
        loggers.add(new ElasticLogger());
        loggers.add(new CloudLogger());


        EmployeeManager employeeManager=new EmployeeManager(loggers);
        employeeManager.add(new Employee(1, "Berkan", "Arslan", "9999999999",11111));

    }

}