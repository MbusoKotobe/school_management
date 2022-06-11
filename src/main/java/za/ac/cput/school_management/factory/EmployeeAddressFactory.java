package za.ac.cput.school_management.factory;

import za.ac.cput.school_management.domain.Address;
import za.ac.cput.school_management.domain.EmployeeAddress;
import za.ac.cput.school_management.helper.Helper;

public class EmployeeAddressFactory {
    public static EmployeeAddress createEmployeeAddress(String employeeId, Address address) throws IllegalArgumentException
    {
        validateAttributes(employeeId, address);
        return new EmployeeAddress.Builder()
                                  .setStaffId(employeeId)
                                  .setAddress(address).build();
    }

    private static void validateAttributes(String employeeId, Address address) throws IllegalArgumentException
    {
        Helper.checkStringParam("EmployeeId", employeeId);
        Helper.checkObjectParams(address);
    }
}
