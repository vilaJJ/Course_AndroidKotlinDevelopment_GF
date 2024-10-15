package anonymous;

public class Programa {
    public void calcular(Bonus bonus) {
        bonus.calcular();
    }

    public static void main(String[] args) {
        Programa programa = new Programa();

        programa.calcular(() -> 20f);

        programa.calcular(new Bonus() {
            @Override
            public Float calcular() {
                return 0f;
            }
        });
    }
}
