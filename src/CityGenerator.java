import java.util.Random;

public class CityGenerator {
    public int[][] hmap;

    public int[][] generateCity(int xSize, int ySize) {
        int city[][] = new int[ySize][xSize];

        Random random = new Random();

//        int rootX = random.nextInt(xSize);
//        int rootY = random.nextInt(ySize);

        int rootX = xSize / 2;
        int rootY = ySize / 2;

        int leftLength = random.nextInt(xSize / 4) + xSize / 4;
        int rightLength = random.nextInt(xSize / 4) + xSize / 4;

        int upLength = random.nextInt(ySize / 4) + ySize / 4;
        int downLength = random.nextInt(ySize / 4) + ySize / 4;

        for (int i = 0; i < leftLength; i++) {
            if (rootX - i >= 0) {
                city[rootY][rootX - i] = 2;

                if (random.nextInt(2) == 1) {
                    int branchLength = random.nextInt(ySize / 2);
                    int branchDir = random.nextInt(2);

                    for (int j = 0; j < branchLength; j++) {
                        if (branchDir == 0) {
                            if (rootY - j >= 0) {
                                city[rootY - j][rootX - i] = 2;
                            }
                        } else {
                            if (rootY + j < ySize) {
                                city[rootY + j][rootX - i] = 2;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < rightLength; i++) {
            if (rootX + i < xSize) {
                city[rootY][rootX + i] = 2;

                if (random.nextInt(2) == 1) {
                    int branchLength = random.nextInt(ySize / 2);
                    int branchDir = random.nextInt(2);

                    for (int j = 0; j < branchLength; j++) {
                        if (branchDir == 0) {
                            if (rootY - j >= 0) {
                                city[rootY - j][rootX + i] = 2;
                            }
                        } else {
                            if (rootY + j < ySize) {
                                city[rootY + j][rootX + i] = 2;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < upLength; i++) {
            if (rootY - i >= 0) {
                city[rootY - i][rootX] = 2;

                if (random.nextInt(2) == 1) {
                    int branchLength = random.nextInt(ySize / 2);
                    int branchDir = random.nextInt(2);

                    for (int j = 0; j < branchLength; j++) {
                        if (branchDir == 0) {
                            if (rootX - j >= 0) {
                                city[rootY - i][rootX - j] = 2;
                            }
                        } else {
                            if (rootX + j < xSize) {
                                city[rootY + i][rootX - j] = 2;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < downLength; i++) {
            if (rootY + i < ySize) {
                city[rootY + i][rootX] = 2;

                if (random.nextInt(2) == 1) {
                    int branchLength = random.nextInt(ySize / 2);
                    int branchDir = random.nextInt(2);

                    for (int j = 0; j < branchLength; j++) {
                        if (branchDir == 0) {
                            if (rootX - j >= 0) {
                                city[rootY + i][rootX - j] = 2;
                            }
                        } else {
                            if (rootX + j < xSize) {
                                city[rootY + i][rootX + j] = 2;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                if (i > 0 && i < ySize - 1 && j > 0 && j < xSize - 1 && city[i][j] != 2) {
                    if (city[i - 1][j] == 2 || city[i + 1][j] == 2 || city[i][j - 1] == 2 || city[i][j + 1] == 2) {
                        city[i][j] = random.nextInt(3) + 3;
                    } else {
                        if (random.nextInt(5) == 4) {
                            city[i][j] = 1;
                        }
                    }
                }
            }
        }

        return city;
    }

    public int[][] generateMaze(int xSize, int ySize) {
        int[][] maze = new int[ySize][xSize];

        hmap = new int[ySize][xSize];

        Random random = new Random();

        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                maze[i][j] = random.nextInt(2);

                if (maze[i][j] == 1) maze[i][j] = 6;
            }
        }

        for (int k = 0; k < 1; k++) {
            for (int i = 0; i < ySize; i++) {
                for (int j = 0; j < ySize; j++) {
                    int nCount = 0;

                    if (i > 0 && i < ySize - 1 && j > 0 && j < xSize - 1) {
                        if (maze[i - 1][j] == 6) {
                            nCount++;
                        }
                        if (maze[i + 1][j] == 6) {
                            nCount++;
                        }
                        if (maze[i - 1][j - 1] == 6) {
                            nCount++;
                        }
                        if (maze[i + 1][j - 1] == 6) {
                            nCount++;
                        }
                        if (maze[i - 1][j + 1] == 6) {
                            nCount++;
                        }
                        if (maze[i + 1][j + 1] == 6) {
                            nCount++;
                        }
                        if (maze[i][j - 1] == 6) {
                            nCount++;
                        }
                        if (maze[i][j + 1] == 6) {
                            nCount++;
                        }

                        if (nCount <= 4) {
                            maze[i][j] = 0;
                        } else {
                            maze[i][j] = 6;
                        }
                    } else {
                        maze[i][j] = 6;
                    }
                }
            }
        }

        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                if (i > 0 && i < ySize - 1 && j > 0 && j < xSize - 1) {
                    if ((maze[i - 1][j] == 6 || maze[i + 1][j] == 6 ||
                            maze[i][j - 1] == 6 || maze[i][j + 1] == 6)
                            && maze[i][j] != 6) {
                        maze[i][j] = 7;
                    }
                }
            }
        }

//        for (int i = 0; i < ySize; i++) {
//            for (int j = 0; j < xSize; j++) {
//                if(maze[i][j] == 6) {
//                    hmap[i][j] = 0;
//                }else if(maze[i][j] == 7) {
//                    hmap[i][j] = 1;
//                }else if(maze[i][j] == 0) {
//                    hmap[i][j] = 2;
//                }
//            }
//        }

        return maze;
    }
}
