import java.util.Random;

public class Main {
    public static void main(String[] args) {
        CityGenerator generator = new CityGenerator();

        int[][] maze = generator.generateMaze(50, 50);
        int[][] city = generator.generateCity(50, 50);

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                city[i][j] = Math.max(city[i][j], maze[i][j]);
            }
        }

        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (city[i][j] > 2) {
                    if (city[i][j] == 5) {
                        generator.hmap[i][j] += random.nextInt(20) + 3;
                    } else if (city[i][j] == 3) {
                        generator.hmap[i][j] += random.nextInt(5) + 3;
                    } else if (city[i][j] == 4) {
                        generator.hmap[i][j] += random.nextInt(10) + 3;
                    } else if (city[i][j] == 1) {
                        generator.hmap[i][j] += 23;
                    }
                }
            }
        }

        Window window = new Window();
        window.city = city;
        window.hmap = generator.hmap;
    }
}
