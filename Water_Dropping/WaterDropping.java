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
public class WaterDropping {
    static Array filter;
    static Array data;

    WaterDropping(int x, int y) {
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

    double drainWater() {
        if (this.data != null && this.filter != null) {
            this.printFilter();
            System.out.println("");
            for(int i = 0; i < this.filter.height - 1; i++) {
                for(int j = 0; j < this.filter.width; j++) {
                    if (this.data.data[i][j] != 0) {
                        if (this.filter.data[i][j] != 0 || this.filter.data[i+1][j] != 0) {
                            if (j-1 >= 0)
                                this.data.data[i+1][j-1] += this.data.data[i][j]/2;
                            if (j+1 < this.filter.width)
                                this.data.data[i+1][j+1] += this.data.data[i][j]/2;
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
        WaterDropping myWtDropping = new WaterDropping(7,7);

        myWtDropping.removeHoles(1,3);
        myWtDropping.removeHoles(1,6);
        myWtDropping.removeHoles(2,3);
        myWtDropping.removeHoles(3,3);
        myWtDropping.removeHoles(3,5);
        myWtDropping.removeHoles(4,5);
        myWtDropping.removeHoles(5,5);
        myWtDropping.removeHoles(6,3);
        myWtDropping.removeHoles(7,2);
        myWtDropping.addWater(4);
        
        System.out.println("Initial Pattern:");
        myWtDropping.printFilter();
        System.out.println();

        System.out.println("");
        double remainingWater = myWtDropping.drainWater();
        System.out.println("");

        //output
        System.out.println("Remaining water: "+remainingWater);

    }
}
