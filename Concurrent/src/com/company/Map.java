package com.company;


public class Map {

    int size = 10; //---> Map size value.
    int [][] mapGrid; //--->Map grid orientation => 2 dimensional
    int mapTile = 0; //--->Map point representation.

    public int getMapSize(){
        //Return the size of the map region.
        return this.size;
    }

    public int setMapSize(int size){
        //Change the value of map size.
        this.size = size;
        return this.size;
    }

    public int [][] generateMap(){
        //Generate map points according to the size.
        mapGrid = new int [size][size];
        for(int [] i:mapGrid){
            for(int  j:i){
             j = mapTile;
            }
        }
        return mapGrid;
    }

    public void printMap(int[][] mapGrid){  
        //Print map on the screen.
        for(int [] i:mapGrid){
            for(int  j:i){
             System.out.print(j);
            }
            System.out.println();
        }
    }
}