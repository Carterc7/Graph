package app;

// Carter Campbell
public class Graph 
{
	static int[][] edges = new int[15][15]; // assigning edges of vertices based on slides
	static String[] vertices = new String[15]; // creating 15 vertices
	public static void main(String[] args) 
	{
		vertices[0] = "Kansas City";
		vertices[1] = "Lawson";
		vertices[2] = "Overland Park";
		vertices[3] = "Liberty";
		vertices[4] = "Excelsior Springs";
		vertices[5] = "Kearney";
		vertices[6] = "Lathrop";
		vertices[7] = "Grandview";
		vertices[8] = "Lenexa";
		vertices[9] = "St. Joseph";
		vertices[10] = "Higginsville";
		vertices[11] = "North Platte";
		vertices[12] = "Weston";
		vertices[13] = "Plattsburg";
		vertices[14] = "Mid Buchanan";
		
		edges[0][1] = 4;
		edges[0][11] = 14;
		edges[0][12] = 12;
		
		edges[1][0] = 14;
		edges[1][2] = 9;
		edges[1][10] = 17;
		edges[1][11] = 9;
		
		edges[2][1] = 9;
		edges[2][3] = 5;
		edges[2][9] = 20;
		edges[2][10] = 13;
		
		edges[3][2] = 5;
		edges[3][4] = 17;
		edges[3][9] = 19;
		
		edges[4][3] = 17;
		edges[4][5] = 16;
		edges[4][9] = 4;
		
		edges[5][4] = 16;
		edges[5][6] = 8;
		edges[5][7] = 9;
		edges[5][9] = 12;
		
		edges[6][5] = 8;
		edges[6][7] = 6;
		
		edges[7][5] = 9;
		edges[7][6] = 6;
		edges[7][8] = 7;
		edges[7][9] = 12;
		edges[7][13] = 23;
		edges[7][14] = 10;
		
		edges[8][7] = 7;
		edges[8][9] = 13;
		edges[8][10] = 5;
		edges[8][14] = 6;
		
		edges[9][2] = 20;
		edges[9][3] = 19;
		edges[9][4] = 4;
		edges[9][5] = 12;
		edges[9][7] = 12;
		edges[9][8] = 13;
		edges[9][10] = 7;
		
		edges[10][1] = 17;
		edges[10][2] = 13;
		edges[10][8] = 5;
		edges[10][9] = 7;
		edges[10][11] = 18;
		edges[10][14] = 8;
		
		edges[11][0] = 14;
		edges[11][1] = 9;
		edges[11][10] = 18;
		edges[11][12] = 15;
		edges[11][14] = 9;
		
		edges[12][0] = 9;
		edges[12][11] = 15;
		edges[12][13] = 11;
		edges[12][14] = 15;
		
		edges[13][7] = 23;
		edges[13][12] = 11;
		edges[13][14] = 18;
		
		edges[14][7] = 10;
		edges[14][8] = 6;
		edges[14][10] = 8;
		edges[14][11] = 9;
		edges[14][12] = 15;
		edges[14][13] = 18;
		
		
		for(int i = 0; i < 15; i++) // double for-loop to print out edges 2D array
		{
			for(int j = 0; j < 15; j++)
			{
				System.out.print(edges[i][j] + " "); // print each element
			}
			System.out.println("");
		}
		
		Graph graph = new Graph();
		graph.getNeighbors(0);
		graph.getNeighbors(1);
		System.out.println("");
		System.out.println("");
		System.out.println("Distances: ");
		System.out.println(graph.getDistance(0, 2));
		System.out.println(graph.getDistance(0, 7));
	}
	
	// Method to find the neighbors at a specific index
	public void getNeighbors(int index)
	{
		System.out.println("\nNeighbors at index " + index + ": ");
		for(int i = 0; i < 15; i++) // iterate through each row
		{
			if(edges[index][i] > 0) // search each row and check if > 0
			{
				System.out.print(i + " "); // print if > 0
			}
		}
	}
	
	// Method to find the distance from a start point to an end point
	public int getDistance(int start, int end)
	{
		int total = 0;
		int temp = end;
		if(edges[start][temp] > 0) // if there is a direct path
		{
			return edges[start][temp];
		}
		while(edges[start][temp] == 0) // iterate unitl we reach a value
		{
			if(temp == 14) // check out of bounds
			{
				temp = -1;
			}
			temp += 1; // increment temp
			if(edges[start][temp] == 0) // check if still 0
			{
				temp += 1; // increment
			}
			total += edges[start][temp]; // add to the total
			start = temp; // flip start and end
			temp = end;
			if(edges[start][temp] > 0) // check if grater than 0
			{
				total += edges[start][end]; // add to total
			}
		}
		return total;
	}

}
