package nl.rosa.semanticdatabase.referencemodel.v2.persistence;


import nl.rosa.semanticdatabase.base.SemanticDatabaseBase;
import nl.rosa.semanticdatabase.bmmcontroller.persistence.util.KryoUtil;
import com.esotericsoftware.kryo.Kryo;


public class PRMBase extends SemanticDatabaseBase {

    public PRMBase clone() {
        Kryo kryo = null;
        try {
            kryo = KryoUtil.getPool().borrow();
            return kryo.copy(this);
        } finally {
            KryoUtil.getPool().release(kryo);
        }
    }
}
