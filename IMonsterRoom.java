package pyland;

/**
 * @inv <pre>
 *     monstersNb() >= 0 </pre>
 *
 * @cons <pre>
 *     $ARGS$ int n
 *     $PRE$  n > 0
 *     $POST$
 *         getVisitor() == null
 *         monstersNb() == n </pre>
 */
public interface IMonsterRoom extends INormalRoom {
    
    // REQUETES
    
    /**
     * Le nombre de monstres pr�sents dans cette salle.
     */
    int monstersNb();
    
    // COMMANDES
    
    /**
     * @post <pre>
     *     Soit x ::= old monstersNb()
     *     Soit y ::= old v.getHitPoints()
     *     x <= y
     *        ==> monstersNb() == 0
     *            getVisitor().getHitPoints() == y + x / 2
     *            fengShuiEffect().contains("Vous combattez victorieusement !")
     *     x > y
     *        ==> monstersNb() == x + y / 2
     *            getVisitor().isDead()
     *            fengShuiEffect().contains("Vous succombez"
     *                    + " dans un r�le affreux...") </pre>
     */
    void setVisitor(IPlayer v);
    
    /**
     * @post <pre>
     *     monstersNb() == old monstersNb() </pre>
     */
    void unsetVisitor();
}
