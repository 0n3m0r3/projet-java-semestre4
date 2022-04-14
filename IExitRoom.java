package pyland;

/**
 * @cons <pre>
 *     $POST$
 *         getVisitor() == null </pre>
 */
public interface IExitRoom extends INormalRoom {
    
    // COMMANDES
    
    /**
     * @post <pre>
     *     getVisitor().hasLeft()
     *     fengShuiEffect().contains("Vous �tes sorti des griffes de"
     *             + " PY le mal�fique !") </pre>
     */
    void setVisitor(IPlayer v);
}
