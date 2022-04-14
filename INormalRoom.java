package pyland;

/**
 * @cons <pre>
 *     $POST$
 *         getVisitor() == null </pre>
 */
public interface INormalRoom extends IRoom {
    
    // CONSTANTES
    
    int POWER_LOSS = 1;
    
    // COMMANDES
    
    /**
     * @post <pre>
     *     Soit x ::= old v.getPowerLevel()
     *     getVisitor().getPowerLevel() == max(0, x - POWER_LOSS)
     * </pre>
     */
    void setVisitor(IPlayer v);
}
