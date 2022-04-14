package pyland;

/**
 * @cons <pre>
 *     $POST$
 *         getVisitor() == null </pre>
 */
public interface IMagicRoom extends IRoom {
    
    // CONSTANTES
    
    int MIN = 5;
    int MAX = 10;
    
    // COMMANDES
    
    /**
     * @post <pre>
     *     Soit x ::= old v.getPowerLevel()
     *     x + MIN <= getVisitor().getPowerLevel() <= x + MAX
     *     fengShuiEffect().contains("Vous sentez un flot d'énergie positive"
     *             + " vous envahir.") </pre>
     */
    void setVisitor(IPlayer v);
}
