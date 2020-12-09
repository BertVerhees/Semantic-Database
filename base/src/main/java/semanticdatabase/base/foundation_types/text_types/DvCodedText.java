package semanticdatabase.base.foundation_types.text_types;

import com.google.common.base.MoreObjects;
import java.util.Objects;

/**
 * Created by pieter.bos on 04/11/15.
 */
public class DvCodedText extends DvText {

    private CodePhrase definingCode;


    public DvCodedText() {
    }

    public DvCodedText(String value, CodePhrase definingCode) {
        super(value);
        this.definingCode = definingCode;
    }

    public DvCodedText(String value, CodePhrase language, CodePhrase encoding, CodePhrase definingCode) {
        super(value, language, encoding);
        this.definingCode = definingCode;
    }

    public CodePhrase getDefiningCode() {
        return definingCode;
    }

    public void setDefiningCode(CodePhrase definingCode) {
        this.definingCode = definingCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DvCodedText that = (DvCodedText) o;
        return Objects.equals(definingCode, that.definingCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), definingCode);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("defining_code", definingCode)
                .add("value", getValue())
                .toString();
    }
}
