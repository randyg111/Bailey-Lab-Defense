package characters;

public interface Traits {
    String getName();
    int getHp();
    void loseHp(int lose);
    int getDamage();
    double getRate();
    String getImageName();
}
