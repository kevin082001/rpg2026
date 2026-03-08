package game.objects;

public class PlayerStats {
    //private String username;
    private int maxHP;
    private int hp;
    private int dmg;
    private int def;
    private int spd;
    private int critChance;
    private double critMult;

    /**
     * use empty constructor for first creation of player
     */
    //public PlayerStats(String username) {
    public PlayerStats() {
        //this.username = username;
        this.maxHP = 10;
        this.hp = 10;
        this.dmg = 2;
        this.def = 0;
        this.spd = 2;
        this.critChance = 0;
        this.critMult = 1.1;
    }

    public PlayerStats(int maxHP, int hp,
                       int dmg, int def, int spd,
                       int critChance, double critMult) {
        //this.username = username;
        this.maxHP = maxHP;
        this.hp = hp;
        this.dmg = dmg;
        this.def = def;
        this.spd = spd;
        this.critChance = critChance;
        this.critMult = critMult;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public int getCritChance() {
        return critChance;
    }

    public void setCritChance(int critChance) {
        this.critChance = critChance;
    }

    public double getCritMult() {
        return critMult;
    }

    public void setCritMult(double critMult) {
        this.critMult = critMult;
    }
}
