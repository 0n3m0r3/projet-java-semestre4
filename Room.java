package pyland;

public abstract class Room implements IRoom {
    
    // ATTRIBUTS
    
    private IPlayer visitor;
    private boolean changing;
    private String fengShui;
    
    // CONSTRUCTEURS
    
    public Room() {
        visitor = null;
        changing = false;
        fengShui = "";
    }
    
    // REQUETES
    
    public IPlayer getVisitor() {
        return visitor;
    }
    
    public String fengShuiEffect() {
        return fengShui;
    }
    
    // COMMANDES
    
    protected abstract String computeFengShuiEffect();
    
    public void setVisitor(IPlayer v) {
        if (visitor != null || v == null || v.hasLeft() ||
                (v.getLocation() != null && v.getLocation() != this)) {
            throw new AssertionError();
        }
        visitor = v;
        fengShui = computeFengShuiEffect();
        if (v.getLocation() == null) {
            v.setLocation(this);
        }
    }
    
    public void unsetVisitor() {
        if (visitor == null || visitor.hasLeft()) {
            throw new AssertionError();
        }
        if (!changing) {
            changing = true;
            visitor.unsetLocation();
            changing = false;
        }
        visitor = null;
    }
}
