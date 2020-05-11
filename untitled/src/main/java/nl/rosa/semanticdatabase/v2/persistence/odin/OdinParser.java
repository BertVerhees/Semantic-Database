package nl.rosa.semanticdatabase.referencemodel.v2.persistence.odin;

import nl.rosa.semanticdatabase.odin.serializer.OdinToJsonConverter;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMSchema;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.jackson.ReferenceModelJacksonUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.io.InputStream;

public class OdinParser {

    public static PRMSchema convert(odinParser.Odin_textContext odin) {
        try {
            String json = new OdinToJsonConverter().convert(odin);
            return ReferenceModelJacksonUtil.getObjectMapper().readValue(json, PRMSchema.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static PRMSchema convert(InputStream odin) throws IOException {

        odinLexer lexer = new odinLexer(CharStreams.fromStream(odin));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        odinParser parser = new odinParser(tokens);
        ANTLRParserErrors errors = new ANTLRParserErrors();
        ArchieErrorListener listener = new ArchieErrorListener(errors);
        parser.addErrorListener(listener);
        PRMSchema converted = convert(parser.odin_text());
        if (errors.hasErrors()) {
            throw new RuntimeException("errors parsing ODIN file: " + errors);
        }

        return converted;
    }

    public static PRMSchema convert(String odin) {
        odinLexer lexer = new odinLexer(CharStreams.fromString(odin));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        odinParser parser = new odinParser(tokens);
        ANTLRParserErrors errors = new ANTLRParserErrors();
        ArchieErrorListener listener = new ArchieErrorListener(errors);
        parser.addErrorListener(listener);
        PRMSchema converted = convert(parser.odin_text());
        if (errors.hasErrors()) {
            throw new RuntimeException("errors parsing ODIN file: " + errors);
        }

        return converted;
    }

}
