package nl.rosa.semanticdatabase.archetypeobjectmodel.adlparser.treewalkers;

import com.nedap.archie.adlparser.antlr.AdlParser.*;
import com.nedap.archie.antlr.errors.ANTLRParserErrors;
import com.nedap.archie.aom.terminology.ArchetypeTerminology;
import com.nedap.archie.serializer.odin.OdinObjectParser;

/**
 * Parser for the terminology section of an archetype
 *
 * Created by pieter.bos on 19/10/15.
 */
public class TerminologyParser extends BaseTreeWalker {

    public TerminologyParser(ANTLRParserErrors errors) {
        super(errors);
    }

    public ArchetypeTerminology parseTerminology(Terminology_sectionContext context) {
        ArchetypeTerminology terminology = OdinObjectParser.convert(context.odin_text(), ArchetypeTerminology.class);
        return terminology;
    }

}
