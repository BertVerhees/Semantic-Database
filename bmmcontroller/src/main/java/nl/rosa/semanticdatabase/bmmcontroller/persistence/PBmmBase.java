package nl.rosa.semanticdatabase.bmmcontroller.persistence;

import com.esotericsoftware.kryo.Kryo;
import nl.rosa.semanticdatabase.bmmcontroller.persistence.util.KryoUtil;

public class PBmmBase {

    public PBmmBase clone() {
        Kryo kryo = null;
        try {
            kryo = KryoUtil.getPool().borrow();
            return kryo.copy(this);
        } finally {
            KryoUtil.getPool().release(kryo);
        }
    }
}
