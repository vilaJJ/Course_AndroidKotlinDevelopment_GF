public class ConsumirPlaneta {
    public static void main(String[] args) {
        Planeta planeta = new Planeta("Terra");
        Animal animal = new Animal("Cachorro");

        planeta.setGentilico("Terraqueo");

        System.out.println(planeta.getNome());
        System.out.println(planeta.getGentilico());
        System.out.println(animal.getEspecie());
    }
}
