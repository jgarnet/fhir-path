package org.fhirpath.dictionaries.r4;

import org.fhirpath.dictionaries.framework.AbstractDictionary;
import org.hl7.fhir.r4.model.Base;

public class R4FhirDictionary extends AbstractDictionary<Base> {
    @Override
    protected String getPackage() {
        return "org.fhirpath.dictionaries.r4";
    }

    @Override
    public Class<Base> getBaseClass() {
        return Base.class;
    }
}
