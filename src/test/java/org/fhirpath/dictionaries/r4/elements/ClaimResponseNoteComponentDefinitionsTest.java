package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.Definitions;
import org.hl7.fhir.r4.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClaimResponseNoteComponentDefinitionsTest extends BackboneElementDefinitionsTest {
    private final ClaimResponseNoteComponentDefinitions claimResponseNoteComponentDefinitions;
    private final ClaimResponse.NoteComponent note;

    public ClaimResponseNoteComponentDefinitionsTest() {
        this.claimResponseNoteComponentDefinitions = new ClaimResponseNoteComponentDefinitions();
        this.note = new ClaimResponse.NoteComponent();
        this.note.setNumber(1);
        this.note.setType(Enumerations.NoteType.DISPLAY);
        this.note.setText("Test Note");
        CodeableConcept language = new CodeableConcept();
        language.setText("Test Language");
        this.note.setLanguage(language);
    }

    @Test
    public void testSuppliesNumber() {
        PositiveIntType result = this.evaluate("number", this.note);
        Assertions.assertEquals(1, result.getValue());
    }

    @Test
    public void testSuppliesType() {
        Enumerations.NoteType result = this.evaluate("type", this.note);
        Assertions.assertEquals(Enumerations.NoteType.DISPLAY, result);
    }

    @Test
    public void testSuppliesText() {
        StringType result = this.evaluate("text", this.note);
        Assertions.assertEquals("Test Note", result.getValue());
    }

    @Test
    public void testSuppliesLanguage() {
        CodeableConcept result = this.evaluate("language", this.note);
        Assertions.assertEquals("Test Language", result.getText());
    }

    @Override
    protected Definitions<Base> getDefinitions() {
        return this.claimResponseNoteComponentDefinitions;
    }
}
