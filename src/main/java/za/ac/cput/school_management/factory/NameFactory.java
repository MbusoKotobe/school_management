/* NameFactory.java
Factory for the Name
Author: Jody Kearns (209023651)
Date: 11 June 2022 */

package za.ac.cput.school_management.factory;

import za.ac.cput.school_management.domain.Name;
import za.ac.cput.school_management.helper.Helper;

public class NameFactory {

    public static Name build(String firstName, String middleName, String lastName){

        Helper.checkStringParam("First Name", firstName);
        Helper.checkStringParam("Last Name", lastName);
        middleName = Helper.setEmptyIfNull(middleName);

        return new Name.Builder().firstName(firstName).middleName(middleName).lastName(lastName).build();
    }
}
