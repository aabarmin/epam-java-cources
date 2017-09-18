package com.epam.university.java.core.task017;

/**
 * Creates OrgstructureBuilder instances.
 */
public class OrgstructureBuilderFactoryImpl implements OrgstructureBuilderFactory {

    /**
     * Create new instance of orgstructure builder.
     * @return instance
     */
    @Override
    public OrgstructureBuilder newInstance() {
        return new OrgstructureBuilderImpl();
    }

}
