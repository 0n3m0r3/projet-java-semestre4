package pyland;

import java.util.HashMap;
import java.util.Map;

import pyland.util.Direction;

class RoomNetwork implements IRoomNetwork {
    
    // ATTRIBUTS
    
    /**
     * Map dont les clés sont de type IRoom et les valeurs de type Map.
     * Pour chaque valeur, les clés sont de type Direction et les valeurs de
     *  type IRoom.
     */
    private final Map data;
    
    // CONSTRUCTEURS

    RoomNetwork() {
        data = new HashMap();
    }
    
    // REQUETES
    
    public boolean canExit(IRoom r, Direction d) {
        if (r == null || d == null) {
            throw new AssertionError();
        }
        
        return getRoomImpl(r, d) != null &&
                (getDoorImpl(r, d) == null || !getDoorImpl(r, d).isLocked());
    }
    
    public IRoom getRoom(IRoom r, Direction d) {
        if (r == null || d == null) {
            throw new AssertionError();
        }
        return getRoomImpl(r, d);
    }
    
    public IDoor getDoor(IRoom r, Direction d) {
        if (r == null || d == null) {
            throw new AssertionError();
        }
        return getDoorImpl(r, d);
    }
    
    // COMMANDES
    
    public void clear() {
        data.clear();
    }
    
    public void connect(IRoom r1, Direction d, IRoom r2) {
        if (r1 == null || d == null || r2 == null) {
            throw new AssertionError();
        }
        
        IRoom x = getRoom(r1, d);
        if (x != r2) {
            if (x != null) {
                unsetRelationInOneWay(x, d.opposite());
            }
            setRelationInOneWay(r1, d, r2);
            IRoom y = getRoom(r2, d.opposite());
            if (y != null) {
                unsetRelationInOneWay(y, d);
            }
            setRelationInOneWay(r2, d.opposite(), r1);
        }
    }
    
    public void install(IRoom r, Direction d, IDoor door) {
        if (r == null || d == null || door == null || getRoomImpl(r, d) == null) {
            throw new AssertionError();
        }
        Pair p1 = getPair(r, d);
        Pair p2 = getPair(p1.room(), d.opposite());
        /*
         * pas besoin de vérifier si p1 != null || p2 != null car il est déjà vérifié dans
         *  les préconditions que les salles communiquent
         */
        p1.setDoor(door);
        p2.setDoor(door);
    }

    // OUTILS
    
    /**
     * La Pair à laquelle on accède à partir de r, dans la direction d.
     * @pre
     *     r != null && d != null
     */
    private Pair getPair(IRoom r, Direction d) {
        assert r != null && d != null;
        
        /*
         * m est une Map dont les clés sont de type Direction et les valeurs
         *  de type IRoom
         */
        Map m = (Map) data.get(r);
        Pair result = null;
        if (m != null) {
            result = (Pair) m.get(d);
        }
        /*
         * result peut être null : cela signifie qu'il n'y a pas de Pair
         *  associée à r dans la Direction d
         */
        return result;
    }
    
    /**
     * La porte qui sépare r de sa voisine dans la direction d.
     * @pre <pre>
     *     r != null && d != null </pre>
     */
    private IDoor getDoorImpl(IRoom r, Direction d) {
        Pair p = getPair(r, d);
        IDoor result = null;
        if (p != null) {
            result = p.door();
        }
        return result;
    }
    
    /**
     * La salle à laquelle on accède à partir de r, dans la direction d.
     * @pre
     *     r != null && d != null
     */
    private IRoom getRoomImpl(IRoom r, Direction d) {
        Pair p = getPair(r, d);
        IRoom result = null;
        if (p != null) {
            result = p.room();
        }
        return result;
    }
        
    
    /**
     * Etablit une relation entre src et dest, dans la direction d en partant
     *  de src.
     * L'invariant n'est pas requis en entrée et n'est pas respecté en sortie !
     * @pre
     *     src != null && d != null && dest != null
     *     getRoom(src, d) == null
     * @post
     *     getRoom(src, d) == dest
     */
    private void setRelationInOneWay(IRoom src, Direction d, IRoom dest) {
        assert src != null && d != null && dest != null;
        assert getRoomImpl(src, d) == null;
        
        Map m = (Map) data.get(src);
        if (m == null) {
            m = new HashMap();
            data.put(src, m);
        }
        Pair p = new Pair(dest);
        m.put(d, p);
    }
    
    /**
     * Sachant qu'il existe une relation à partir de r dans la direction d,
     *  supprime uniquement cette relation.
     * L'invariant n'est pas requis en entrée et n'est pas respecté en sortie !
     * @pre
     *     r != null && d != null
     *     getRoom(r, d) != null
     * @post
     *     getRoom(r, d) == null
     */
    private void unsetRelationInOneWay(IRoom r, Direction d) {
        assert r != null && d != null;
        assert getRoomImpl(r, d) != null;
        
        Map m = (Map) data.get(r);
        m.remove(d);
        if (m.isEmpty()) {
            data.remove(r);
        }
    }
}
