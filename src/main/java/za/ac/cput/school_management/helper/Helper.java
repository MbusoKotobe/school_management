package za.ac.cput.school_management.helper;

import org.apache.commons.lang3.StringUtils;
import za.ac.cput.school_management.domain.*;

public class Helper {

    public static boolean isEmptyOrNull(String str){
        return StringUtils.isEmpty(str);
    }

    public static String setEmptyIfNull(String str){ //Method to make null values have empty Strings instead
        if (isEmptyOrNull(str)) return StringUtils.EMPTY;
        return str;
    }

    public static void checkStringParam(String paramName, String paramValue){ //Ensure that value cannot have null or empty value
        if (isEmptyOrNull(paramValue))
            throw new IllegalArgumentException(String.format("Invalid value for: %s", paramName));
    }
    
    public static void checkObjectParams(Object object) throws IllegalArgumentException
    {
        if(object instanceof Address)
        {
            checkStringParam("unitNumber", ((Address) object).getUnitNumber());
            checkStringParam("complexName", ((Address) object).getComplexName());
            checkStringParam("streetNumber", ((Address) object).getStreetNumber());
            checkStringParam("streetName", ((Address) object).getStreetName());
            checkStringParam("streetName", ((Address) object).getPostalCode());
            checkObjectParams(((Address) object).getCity());
        }
        else if(object instanceof City)
        {
            checkStringParam("id", ((City) object).getId());
            checkStringParam("name", ((City) object).getName());
            checkObjectParams(((City) object).getCountry());
        }
        else if(object instanceof Country)
        {
            checkStringParam("countryId", ((Country) object).getCountryId());
            checkStringParam("countryName", ((Country) object).getCountryName());
        }
        else if(object instanceof Employee)
        {
            checkStringParam("staffId", ((Employee) object).getStaffId());
            checkStringParam("email", ((Employee) object).getEmail());
            checkObjectParams(((Employee) object).getName());
        }
        else if(object instanceof EmployeeAddress)
        {
            checkStringParam("staffId", ((EmployeeAddress) object).getStaffId());
            checkObjectParams(((EmployeeAddress) object).getAddress());
        }
        else if(object instanceof Name)
        {
            checkStringParam("firstName", ((Name) object).getFirstName());
            checkStringParam("middleName", ((Name) object).getMiddleName());
            checkStringParam("lastName", ((Name) object).getLastName());
        }
        else if(object instanceof Student)
        {
            checkStringParam("studentId", ((Student) object).getStudentId());
            checkStringParam("email", ((Student) object).getEmail());
            checkObjectParams(((Student) object).getName());
        }
        else if(object instanceof StudentAddress)
        {
            checkStringParam("studentId", ((StudentAddress) object).getStudentId());
            checkObjectParams(((StudentAddress) object).getAddress());
        }
    }
}
