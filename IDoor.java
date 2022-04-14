package pyland;

/**
 * Mod�lise la notion de porte.
 * @inv <pre>
 *     exists key:IKey : keyholeMatchWith(key)
 *     keyholeMatchWith(k1) && keyholeMatchWith(k2) ==> k1 == k2 </pre>
 * @cons <pre>
 *     $DESC$ Une porte (ouverte) adapt�e � la cl� k.
 *     $ARGS$ Key k
 *     $PRE$ k != null
 *     $POST$
 *         keyholeMatchWith(k)
 *         !isLocked() </pre>
 */
public interface IDoor {
    
    // REQUETES
    
    /**
     * Indique si <code>key</code> est bien adapt�e � cette porte.
     * @pre <pre>
     *     key != null </pre>
     */
    boolean keyholeMatchWith(Key key);
    
    /**
     * Indique si la porte est ferm�e ou non.
     */
    boolean isLocked();

    // COMMANDES
    
    /**
     * Ferme cette porte avec <code>key</code>.
     * @pre <pre>
     *     key != null </pre>
     * @post <pre>
     *     keyholeMatchWith(key) ==> isLocked()
     *     !keyholeMatchWith(key) ==> isLocked() == old isLocked() </pre>
     */
    void lock(Key key);
    
    /**
     * Ouvre cette porte avec <code>key</code>.
     * @pre <pre>
     *     key != null </pre>
     * @post <pre>
     *     keyholeMatchWith(key) ==> !isLocked()
     *     !keyholeMatchWith(key) ==> isLocked() == old isLocked() </pre>
     */
    void unlock(Key key);
}
