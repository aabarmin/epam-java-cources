package com.epam.university.java.core.task017;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task017Test {
    private Task017 instance;
    private OrgstructureBuilderFactory builderFactory;
    private VisitorFactory visitorFactory;
    private Organization organization;

    /**
     * {@inheritDoc}
     */
    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task017.class);
        builderFactory = TestHelper.getInstance(OrgstructureBuilderFactory.class);
        visitorFactory = TestHelper.getInstance(VisitorFactory.class);

        final OrgstructureBuilder builder = builderFactory.newInstance();
        organization = builder
                .addOrganization()
                        .withName("First Organization")
                        .done()
                .addDepartment()
                        .withName("Department 1")
                        .withEmployees(10)
                        .withChild(
                                builder.addDepartment()
                                        .withName("Department 1.1")
                                        .withEmployees(20)
                                        .done()
                        )
                        .withChild(
                                builder.addDepartment()
                                        .withName("Department 1.2")
                                        .withEmployees(30)
                                        .done()
                        )
                        .done()
                .addDepartment()
                        .withName("Department 2")
                        .withEmployees(5)
                        .withChild(
                                builder.addDepartment()
                                        .withName("Department 2.1")
                                        .withEmployees(15)
                                        .done()
                        )
                        .withChild(
                                builder.addDepartment()
                                        .withName("Department 2.2")
                                        .withEmployees(25)
                                        .done()
                        )
                        .done()
                .addDepartment()
                        .withName("Department 3")
                        .withEmployees(35)
                        .done()
                .build();
    }

    @Test
    public void findWithMinimalAmountOfMembers() throws Exception {
        final Visitor visitor = visitorFactory.newInstance(VisitorType.MINIMAL);
        final Department department = instance.findDepartment(organization, visitor);
        assertEquals("Incorrect department found",
                5,
                department.getEmployeeCount()
        );
    }

    @Test
    public void findWithMaximalAmountOfMembers() throws Exception {
        final Visitor visitor = visitorFactory.newInstance(VisitorType.MAXIMAL);
        final Department department = instance.findDepartment(organization, visitor);
        assertEquals("Incorrect department found",
                35,
                department.getEmployeeCount()
        );
    }
}