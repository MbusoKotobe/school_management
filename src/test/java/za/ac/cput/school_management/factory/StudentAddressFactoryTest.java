package za.ac.cput.school_management.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.StudentAddress;

import static org.junit.jupiter.api.Assertions.*;

class StudentAddressFactoryTest {

    @Test
    void buildWithSuccess() throws IllegalArgumentException{

        StudentAddress studentAddress = StudentAddressFactory
                .build("fghj", "dfghjhgf");
        System.out.println(studentAddress);
        assertNotNull(studentAddress);
    }

    @Test
    void buildWithError() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                StudentAddressFactory
                        .build(null, "dfghjhgf"));

        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Student id is required!", exceptionMessage);
    }

}
