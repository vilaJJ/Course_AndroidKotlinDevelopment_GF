public class ExemploStatic {
    static int valor = 0;
    int value = 0;

    public ExemploStatic() {
        valor++;
        value++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new ExemploStatic();
        }

        ExemploStatic ex = new ExemploStatic();

        System.out.println(ex.value);
        System.out.println(ExemploStatic.valor);
    }
}
