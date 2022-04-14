package pyland;

/**
 * Mod�lise les salles du labyrinthe.
 * Les salles sont reli�es entre elles et le joueur les traverse.
 * @inv <pre>
 *     getVisitor() == p ==> p.getLocation() == this
 *     fengShuiEffect() != null
 *     getVisitor() == null ==> fengShuiEffect().equals("")
 *     getVisitor() != null
 *         ==> fengShuiEffect() refl�te l'effet feng-shui sur getVisitor()</pre>
 */
public interface IRoom {
    
    // REQUETES
    
    /**
     * Une cha�ne d�crivant l'effet feng-shui de cette salle sur son visiteur.
     */
    String fengShuiEffect();
    
    /**
     * Le joueur qui se trouve dans cette salle.
     */
    IPlayer getVisitor();
    
    // COMMANDES
    
    /**
     * Associe le joueur <code>v</code> � cette salle.
     * @pre <pre>
     *     getVisitor() == null
     *     v != null && !v.hasLeft()
     *     v.getLocation() == null || v.getLocation() == this </pre>
     * @post <pre>
     *     getVisitor() == v </pre>
     */
    void setVisitor(IPlayer v);
    
    /**
     * Dissocie <code>getVisitor()</code> de cette salle.
     * @pre <pre>
     *     getVisitor() != null
     *     !getVisitor().hasLeft() </pre>
     * @post <pre>
     *     getVisitor() == null
     *     (old getVisitor()).getLocation() == null </pre>
     */
    void unsetVisitor();
}
