/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code_Assigmnets;

/**
 *
 * @author AYESHA PERERA
 */
public class WaterDrop {
    
    static Array filter;
    static Array data;

    WaterDrop(int x, int y) {
        filter = new Array(x,y);
        data = new Array(x,y);
    }

    static class Array {

        double[][] data;
        int width;
        int height;

        Array(int x, int y) {
            width = x;
            height = y;
            data = new double[height][width];
        }

        void print() {
            if (this.data != null) {
                for(int i = 0; i < this.height; i++) {
                    for(int j = 0; j < this.width; j++) {
                        System.out.print(this.data[i][j] + "\t");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("No data");
            }
        }

    }

    void printFilter() {
        if (this.data != null && this.filter != null) {
            for(int i = 0; i < this.filter.height; i++) {
                System.out.print("  ");
                for(int j = 0; j < this.filter.width; j++) {
                    System.out.print((int)this.filter.data[i][j] + " ");
                }
                System.out.print("\t");
                for(int j = 0; j < this.data.width; j++) {
                    System.out.print(this.data.data[i][j] + "\t");
                }
                System.out.println();
            }
        } else {
            System.out.println("No data");
        }
    }

    void removeHoles(int x, int y) {
        if (this.data != null && this.filter != null) {
            this.filter.data[this.filter.height - y][x - 1] = 1;
        } else {
            System.out.println("No data");
        }
    }

    void addWater(int x) {
        if (this.data != null && this.filter != null) {
            this.data.data[0][x - 1] = 100;
        } else {
            System.out.println("No data");
        }
    }


    double drainWater2() {
        if (this.data != null && this.filter != null) {
            this.printFilter();
            System.out.println("");
            for(int i = 0; i < this.filter.height - 1; i++) {
                for(int j = 0; j < this.filter.width; j++) {
                    if (this.data.data[i][j] != 0) {
                        if (this.filter.data[i][j] != 0 || this.filter.data[i+1][j] != 0) {
                            if (j-1 >= 0) {
                                for (int k = j - 1; k >=0 ; k--) {
                                    if (this.filter.data[i+1][k] == 0) {
                                        this.data.data[i+1][k] += this.data.data[i][j]/2;
                                        break;
                                    }
                                }
                            }
                            if (j+1 < this.filter.width) {
                                for (int k = j + 1; k < this.filter.width ; k++) {
                                    if (this.filter.data[i+1][k] == 0) {
                                        this.data.data[i+1][k] += this.data.data[i][j]/2;
                                        break;
                                    }
                                }
                            }
                        } else {
                            this.data.data[i+1][j] += this.data.data[i][j];
                        }
                        this.data.data[i][j] = 0;
                    }
                }
                this.printFilter();
                System.out.println("");
            }

            double sum = 0;
            for(int j = 0; j < this.filter.width; j++) {
                if (this.data.data[this.filter.height - 1][j] != 0) {
                    if (this.filter.data[this.filter.height - 1][j] != 0) {
                        if (j-1 >= 0)
                            sum += this.data.data[this.filter.height - 1][j]/2;
                        if (j+1 < this.filter.width)
                            sum += this.data.data[this.filter.height - 1][j]/2;
                    } else {
                        sum += this.data.data[this.filter.height - 1][j];
                    }
                }
            }
            return sum;

        } else {
            System.out.println("No data");
            return 0;
        }
    }
        
    public static void main(String[] args) {
        WaterDrop myWaterDrop = new WaterDrop(7,7);

        // Configure filter
        myWaterDrop.removeHoles(1,3);
        myWaterDrop.removeHoles(1,6);
        myWaterDrop.removeHoles(2,3);
        myWaterDrop.removeHoles(3,3);
        myWaterDrop.removeHoles(3,5);
        myWaterDrop.removeHoles(4,5);
        myWaterDrop.removeHoles(5,5);
        myWaterDrop.removeHoles(6,3);
        myWaterDrop.removeHoles(7,2);
        myWaterDrop.addWater(4);
        
        // Print configurations
        System.out.println("Initial Pattern:");
        myWaterDrop.printFilter();
        System.out.println();

        // Calculate
        System.out.println("");
        double remainingWater = myWaterDrop.drainWater2();
        System.out.println("");

        // Print final output
        System.out.println("Remaining water: "+remainingWater);

    }
}
