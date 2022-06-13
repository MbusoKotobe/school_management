/* EmployeeFactory.java
Factory for the Employee
Author: Jody Kearns (209023651)
Date: 11 June 2022 */

package za.ac.cput.school_management.factory;

import za.ac.cput.school_management.domain.Employee;
import za.ac.cput.school_management.domain.Name;
import za.ac.cput.school_management.helper.Helper;


public class EmployeeFactory {
    public static Employee build(String staffId, String email, Name name) {

        Helper.checkStringParam("Staff Id", staffId);
        Helper.checkStringParam("Email", email);
        Helper.checkEmail(email);
        Helper.checkIfObjectNull("Name",name);

        return new Employee.Builder().staffId(staffId).email(email).name(name).build();
    }
}