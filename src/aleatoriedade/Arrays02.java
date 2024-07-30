package aleatoriedade;

public class Arrays02 {
    public static void main(String[] args) {
        String[] nomes = new String[4];
        nomes[0] = "Goku";
        nomes[1] = "Naruto";
        nomes[2] = "Luffy";
        nomes[3] = "Kirito";

        for (int i = 0; i < 4; i++) {
            System.out.println(nomes[i]);
        }

        for (int i = 0; i < nomes.length; i++) {
            System.out.println(nomes[i]);
        }


    }
}
