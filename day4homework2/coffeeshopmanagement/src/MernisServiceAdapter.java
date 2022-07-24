
import java.rmi.RemoteException;

public class MernisServiceAdapter implements ICostumerCheckService {

    public boolean checkIfRealPerson(Customer customer) throws NumberFormatException, RemoteException,Exception {
        // TODO Auto-generated method stub
        KPSPublicSoapProxy client=new KPSPublicSoapProxy();
        return client.TCKimlikNoDogrula(Long.parseLong(customer.getNationalityId()),customer.getFirstName().toUpperCase(), customer.getLastName().toUpperCase(), Integer.parseInt(customer.getDateOfBirthday()));
    }

}