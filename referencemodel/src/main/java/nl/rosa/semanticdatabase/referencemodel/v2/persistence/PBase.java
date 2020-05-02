package nl.rosa.semanticdatabase.referencemodel.v2.persistence;


import nl.rosa.semanticdatabase.base.SemanticDatabaseBase;
import nl.rosa.semanticdatabase.util.KryoUtil;
import com.esotericsoftware.kryo.Kryo;


public class PBase extends SemanticDatabaseBase {

    public PBase clone() {
        Kryo kryo = null;
        try {
            kryo = KryoUtil.getPool().borrow();
            return kryo.copy(this);
        } finally {
            KryoUtil.getPool().release(kryo);
        }
    }
}
