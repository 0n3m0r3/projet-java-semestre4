package pyland;

public class KeyRoom extends NormalRoom implements IKeyRoom {
    
    // ATTRIBUTS
    
    private Key key;
    
    // CONSTRUCTEUR
    
    public KeyRoom() {
        super();
        key = null;
    }
    
    // REQUETES
    
    public Key getKey() {
        return key;
    }
    
    // COMMANDES

    public void putKey(Key key) {
        if (key == null || this.key != null) {
            throw new AssertionError();
        }
        this.key = key;
    }

    public void removeKey() {
        key = null;
    }
    
    protected String computeFengShuiEffect() {
        if (key != null) {
            return "Vous trouvez une clé par terre";
        }
        return "";
    }
}
