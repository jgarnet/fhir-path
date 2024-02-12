package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.Definitions;
import org.hl7.fhir.r4.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ClaimResponseAdjudicationComponentDefinitionsTest extends BackboneElementDefinitionsTest {
    private final ClaimResponseAdjudicationComponentDefinitions claimResponseAdjudicationComponentDefinitions;
    private final ClaimResponse.AdjudicationComponent claimResponseAdjudicationComponent;

    public ClaimResponseAdjudicationComponentDefinitionsTest() {
        this.claimResponseAdjudicationComponentDefinitions = new ClaimResponseAdjudicationComponentDefinitions();
        this.claimResponseAdjudicationComponent = new ClaimResponse.AdjudicationComponent();
        CodeableConcept category = new CodeableConcept();
        category.setText("Test Category");
        this.claimResponseAdjudicationComponent.setCategory(category);
        CodeableConcept reason = new CodeableConcept();
        reason.setText("Test Reason");
        this.claimResponseAdjudicationComponent.setReason(reason);
        this.claimResponseAdjudicationComponent.setAmount(new Money().setValue(1));
        this.claimResponseAdjudicationComponent.setValue(1);
    }

    @Test
    public void testSuppliesCategory() {
        CodeableConcept result = this.evaluate("category", this.claimResponseAdjudicationComponent);
        Assertions.assertEquals("Test Category", result.getText());
    }

    @Test
    public void testSuppliesReason() {
        CodeableConcept result = this.evaluate("reason", this.claimResponseAdjudicationComponent);
        Assertions.assertEquals("Test Reason", result.getText());
    }

    @Test
    public void testSuppliesAmount() {
        Money result = this.evaluate("amount", this.claimResponseAdjudicationComponent);
        Assertions.assertEquals(BigDecimal.ONE, result.getValue());
    }

    @Test
    public void testSuppliesValue() {
        DecimalType result = this.evaluate("value", this.claimResponseAdjudicationComponent);
        Assertions.assertEquals(BigDecimal.ONE, result.getValue());
    }

    @Override
    protected Definitions<Base> getDefinitions() {
        return this.claimResponseAdjudicationComponentDefinitions;
    }
}
