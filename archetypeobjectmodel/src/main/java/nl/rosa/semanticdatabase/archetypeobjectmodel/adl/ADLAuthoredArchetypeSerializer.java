package nl.rosa.semanticdatabase.archetypeobjectmodel.adl;

import com.google.common.base.Joiner;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.Archetype;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.AuthoredArchetype;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author markopi
 */
public class ADLAuthoredArchetypeSerializer<T extends AuthoredArchetype> extends ADLArchetypeSerializer<T> {

    public ADLAuthoredArchetypeSerializer(T archetype, Function<String, Archetype> flatArchetypeProvider) {
        super(archetype, flatArchetypeProvider);
    }

    @Override
    protected void appendLanguage() {
        if (archetype.getOriginalLanguage() == null) return;

        builder.newline().append("language").newIndentedLine()
                .odin(archetype.getAuthoredResourceContent())
                .unindent();
    }

    @Override
    protected void appendDescription() {
        if (archetype.getDescription() == null) {
            builder.newline().append("description");
        } else {
            builder.newline().append("description").newIndentedLine()
                    .odin(archetype.getDescription())
                    .unindent();
        }
    }

    @Override
    protected String headTag() {
        return "archetype";
    }

    @Override
    protected void appendHeaderAttributes() {
        Map<String, String> attributes = new LinkedHashMap<>();
        if (archetype.getAdlVersion() != null) {
            attributes.put("adl_version", archetype.getAdlVersion());
        }
        if (archetype.getRmRelease() != null) {
            attributes.put("rm_release", archetype.getRmRelease());
        }
        if (Boolean.TRUE.equals(archetype.getGenerated())) {
            attributes.put("generated", null);
        }
        if(archetype.getUid() != null) {
            attributes.put("uid", archetype.getUid());
        }
        if(archetype.getBuildUid() != null) {
            attributes.put("build_uid", archetype.getBuildUid());
        }

        if (!attributes.isEmpty()) {
            List<String> elements = attributes.entrySet().stream()
                    .map(e -> {
                        if (e.getValue() == null) {
                            return e.getKey();
                        } else {
                            return e.getKey() + "=" + e.getValue();
                        }
                    })
                    .collect(Collectors.toList());
            builder.append(" (").append(Joiner.on("; ").join(elements)).append(")");
        }
    }
}
