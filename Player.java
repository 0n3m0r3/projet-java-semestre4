package pyland;

public class Player implements IPlayer {
    
    // ATTRIBUTS
    
    private IRoom location;
    private boolean hasLeft;
    private boolean changing;
    private int hitPoints;
    private int powerLevel;
    private Key key;
    
    // CONSTRUCTEURS
    
    public Player(int hp) {
        if (hp <= 0) {
            throw new AssertionError();
        }
        location = null;
        hasLeft = false;
        changing = false;
        hitPoints = hp;
        powerLevel = 0;
        key = null;
    }
    
    // REQUETES
    
    public IRoom getLocation() {
        return location;
    }
    
    public boolean hasLeft() {
        return hasLeft;
    }
    
    public boolean isDead() {
        return hitPoints == 0;
    }
    
    public int getHitPoints() {
        return hitPoints;
    }
    
    public int getPowerLevel() {
        return powerLevel;
    }
    
    public Key getKey() {
        return key;
    }
    
    // COMMANDES
    
    public void leave() {
        if (hasLeft) {
            throw new AssertionError("This player has already left");
        }
        hasLeft = true;
    }
    
    public void kill() {
        if (hasLeft) {
            throw new AssertionError("This player has left");
        }
        hitPoints = 0;
        hasLeft = true;
    }
        
    public void setLocation(IRoom r) {
        if (hasLeft || r == null || location != null ||
                (r.getVisitor() != null && r.getVisitor() != this)) {
            throw new AssertionError();
        }
        location = r;
        if (r.getVisitor() == null) {
            r.setVisitor(this);
        }
    }
    
    public void unsetLocation() {
        if (hasLeft || location == null) {
            throw new AssertionError();
        }
        if (!changing) {
            changing = true;
            location.unsetVisitor();
            changing = false;
        }
        location = null;
    }
    
    public void setMorePowerful(int q) {
        if (hasLeft || q < 0) {
            throw new AssertionError();
        }
        powerLevel += q;
    }
    
    public void setLessPowerful(int q) {
        if (hasLeft || q < 0 || q > powerLevel) {
            throw new AssertionError();
        }
        powerLevel -= q;
    }
    
    public void strengthen(int q) {
        if (hasLeft || q < 0) {
            throw new AssertionError();
        }    
        hitPoints += q;
    }
    
    public void pickUpKey(Key k) {
        if (hasLeft || k == null) {
            throw new AssertionError();
        }
        key = k;
    }
}