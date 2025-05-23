
import java.io.FileReader;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

class Lakas {
    int kerulet;
    int terulet;
    int szobak_szama;
    int emelet;
    int ar;
    String allapot;
}

public class LakasElemzes {
    public static void main(String[] args) {
        try {
            // JSON beolvasása
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(new FileReader("hasznalt.json"), JsonObject.class);
            JsonArray lakasokJson = jsonObject.getAsJsonArray("lakasok");

            List<Lakas> lakasok = gson.fromJson(lakasokJson, new TypeToken<List<Lakas>>(){}.getType());

            // 1. feladat: Legdrágább ingatlan kerülete
            Lakas maxLakas = Collections.max(lakasok, Comparator.comparingInt(l -> l.ar));
            System.out.println("1. feladat:");
            System.out.println(maxLakas.ar + " (" + maxLakas.kerulet + " kerület)");

            // 2. feladat: Lakások száma kerületenként
            System.out.println("2. feladat:");
            Map<Integer, Integer> keruletSzam = new TreeMap<>();
            for (Lakas l : lakasok) {
                keruletSzam.put(l.kerulet, keruletSzam.getOrDefault(l.kerulet, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : keruletSzam.entrySet()) {
                System.out.println(entry.getKey() + ". kerület: " + entry.getValue());
            }

            // 3. feladat: Átlagos terület
            double atlagTerulet = lakasok.stream().mapToInt(l -> l.terulet).average().orElse(0);
            System.out.println("3. feladat:");
            System.out.printf("Átlagos terület: %.0f m2%n", atlagTerulet);

            // 4. feladat: 6. kerületi lakások átlagos négyzetméter ára
            List<Lakas> hatodikKerulet = new ArrayList<>();
            for (Lakas l : lakasok) {
                if (l.kerulet == 6) {
                    hatodikKerulet.add(l);
                }
            }

            double atlagNmAr = hatodikKerulet.stream()
                    .mapToDouble(l -> (double) l.ar / l.terulet)
                    .average().orElse(0);

            System.out.println("4. feladat:");
            System.out.printf("Átlagos négyzetméter ár a 6. kerületben: %.0f Ft/m2%n", atlagNmAr);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
