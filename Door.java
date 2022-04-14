package pyland;

public class Door implements IDoor {
    
    // ATTRIBUTS
    
    private boolean isLocked;
    private Key key;
    
    // CONSTRUCTEUR
    
    public Door(Key key) {
        if (key == null) {
            throw new AssertionError();
        }
        this.key = key;
        isLocked = false;
    }
    
    // REQUETES

    public boolean keyholeMatchWith(Key key) {
        if (key == null) {
            throw new AssertionError();
        }
        return this.key == key;
    }

    public boolean isLocked() {
        return isLocked;
    }

    // COMMANDES

    public void lock(Key key) {
        if (key == null) {
            throw new AssertionError();
        }
        if (this.key == key) {
            isLocked = true;
        }
    }

    public void unlock(Key key) {
        if (key == null) {
            throw new AssertionError();
        }
        if (this.key == key) {
            isLocked = false;
        }
    }
}
