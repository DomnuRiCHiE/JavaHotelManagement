package Repository.People;

import Domain.People.Admin;
import Repository.MainRepository;

public class AdminRepository extends MainRepository<Admin> {
    private static AdminRepository instance;

    private AdminRepository() {
        super();
    }

    public static AdminRepository getInstance() {
        if (instance == null) {
            instance = new AdminRepository();
        }
        return instance;
    }
}
