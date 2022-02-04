package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
 
public class Solution_D3_1873_상호의배틀필드 {
    static String str = "1\r\n" +
"3 7\r\n" + 
            "***....\r\n" + 
            "*-..#**\r\n" + 
            "#<.****\r\n" + 
            "23\r\n" + 
            "SURSSSSUSLSRSSSURRDSRDS";
    static char[] position = {'^','>','v','<'};
    static int[][] DELTAS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static String index = "URDL";
    static int H;
    static int W;
     
    static int[] get_position(char[][] map) {
        int[] ans = new int[3];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                char c = map[i][j];
                if(c == '^' || c == '>' || c == 'v' || c == '<') {
                    ans[0] = i;
                    ans[1] = j;
                    for (int k = 0; k < position.length; k++) {
                        if (c==position[k])
                            ans[2] = k;
                    }
                    break;
                }
            }
        }
        return ans;
    }
     
    static boolean is_valid(int nx, int ny) {
        return nx>=0 && nx<H && ny>=0 && ny<W;
    }
     
    static char[][] get_bomb(char[][]map, int x, int y, int p){
        int nx = x + DELTAS[p][0];
        int ny = y + DELTAS[p][1];
        while(is_valid(nx, ny)) {
            if(map[nx][ny] == '*') {
                map[nx][ny] = '.';
                break;
            }
            if(map[nx][ny] == '#')
                break;
            nx += DELTAS[p][0];
            ny += DELTAS[p][1];
        }
        return map;
    }
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //in = new BufferedReader(new StringReader(str));
        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            String s = in.readLine();
            H = Integer.parseInt(s.split(" ")[0]);
            W = Integer.parseInt(s.split(" ")[1]);
            char[][] map = new char[H][W];
            for (int i = 0; i < H; i++) {
                map[i] = in.readLine().toCharArray();
            }
            int N = Integer.parseInt(in.readLine());
            String[] func = in.readLine().split("");
             
            int[] ans = get_position(map);
            int x = ans[0];
            int y = ans[1];
            int p = ans[2];
             
            for (int i = 0; i < func.length; i++) {
                char tmp = func[i].charAt(0);
                if (tmp == 'S') {
                    map = get_bomb(map, x, y, p);
                    continue;
                }
                p = index.indexOf(tmp); 
                map[x][y] = position[p];
                int nx = x + DELTAS[p][0];
                int ny = y + DELTAS[p][1];
                if(is_valid(nx, ny) && map[nx][ny] == '.') {
                    map[nx][ny] = map[x][y];
                    map[x][y] = '.';
                    x = nx;
                    y = ny;
                }
            }
            System.out.print("#"+tc+" ");
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++){
                    System.out.print(map[i][j]);
                    }
                System.out.println();
                }       
            }
        }
}