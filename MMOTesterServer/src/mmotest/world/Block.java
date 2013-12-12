package mmotest.world;

import java.util.ArrayList;

public class Block {
	int coord_x, coord_y, terrainid, blockobj_size;
	ArrayList<BlockObject> blockobjlist;
	public Block(int x, int y, int blockid, int blockterrainid, ArrayList<BlockObject> sepobj){
		coord_x = x;
		coord_y = y;
		terrainid = blockterrainid;
		blockobjlist = sepobj;
		blockobj_size = sepobj.size();
	}
	public void SetX(int x){
		coord_x = x;
	}
	public void SetY(int y){
		coord_y = y;
	}
	public int GetX(){
		return coord_x;
	}
	public int GetY(){
		return coord_y;
	}
	public int GetTerrainID(){
		return terrainid;
	}
	public void SetTerrainID(int id){
		terrainid = id;
	}
	public void AddBlockOBJ(BlockObject obj){
		blockobjlist.add(obj);
		blockobj_size++;
	}
	public BlockObject GetBlockOBJ(int point){
		return blockobjlist.get(point);
	}
	public BlockObject PopBlockOBJ(){
		return blockobjlist.get(blockobj_size);
	}
}
