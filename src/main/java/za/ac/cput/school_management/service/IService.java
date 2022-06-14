package za.ac.cput.school_management.service;

import java.util.Optional;

public interface IService <T, I>{
    T save(T object);
    Optional<T> read(I employeeId);
    void delete(T employeeAddress);
}
