import jdk.swing.interop.SwingInterOpUtils;

public class Main {
    public static void main(String[] args){
        System.out.println("Çıplak class Kalmasın");

    }

}

//inheritance veya implementasyon olmadığı için bir if suitimali ortaya çıkmış.
//bir projede enum varsa kullanılıyorsa suistimal varmı yokmu diye code review yapmak incelemek gerekiyor.

//---------------------------------------------------------------
public class  CustomerDal implements ICustomerDal{
    DatabaseType databaseType;
    public CustomerDal(DatabaseType databaseType) {
        this.databaseType = databaseType;
    }

    public void add(Customer customer) {
        if(databaseType = DatabaseType.Oracle){
            System.out.println("Nhibernate kullanarak veitabanına eklendi.");
        }
        else {
            System.out.println("Entitiy Framework kullanarak veritabanına eklendi.");
        }

    }
}

//---------------------------------------------------------------


public class EFCustomerDal implements ICostumerDal{           //EF:EntityFramework
public void add(Customer customer) {
    //throw new NotImplementedException();
    System.out.println("Entitiy Framework kullanrak veeritabanıa eklendi.");
}
public boolean CustomerExists(Customer customer) {            //NH:NHibernate
    //throw new NotImplementedException();
    return true;
}
}



public class NHCustomerDal implements ICostumerDal     {

    @Override
    public void add(Customer customer) {

    }

    @Override
    public boolean CustomerExists(Customer customer) {
        return false;
    }
}

//----------------------------------------------------------------
class Customer {
    private int id;
    private String firstName;

    public Customer() {
    }

    public Customer(int id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}

/*enum DatabaseType {
    Oracle, SqlServer*/
}



