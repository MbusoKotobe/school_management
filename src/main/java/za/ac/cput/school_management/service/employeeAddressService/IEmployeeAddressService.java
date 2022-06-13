package za.ac.cput.school_management.service.employeeAddressService;

import java.util.List;
import java.util.Optional;

public interface IEmployeeAddressService<T, I>{
    T save(T object);
    Optional<T> read(I employeeId);
    List<T> findAll();
    void deleteById(I employeeId);
    void delete(T employeeAddress);

}
