package pyland;

public class MagicRoom extends Room implements IMagicRoom {
    
    // CONSTRUCTEURS
    
    public MagicRoom() {
        super();
    }
    
    // COMMANDES
    
    public void setVisitor(IPlayer v) {
        super.setVisitor(v);
        v.setMorePowerful(alea(MIN, MAX));
    }
    
    protected String computeFengShuiEffect() {
        return "Vous sentez un flot d'énergie positive vous envahir.";
    }
    
    // OUTILS
    
    /**
     * Un nombre aléatoire compris entre a et b (au sens large).
     * @pre <pre>
     *     0 < a <= b </pre>
     * @post <pre>
     *     a <= result <= b </pre>
     */
    private static int alea(int a, int b) {
        assert (a > 0) && (b >= a);
        return a + (int) (Math.random() * (b - a + 1));
    }
}