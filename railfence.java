public class railfence{
    public static String Encode_Rail_Fence(String s, int key){
        int row = key;
        int col = s.length();
        char[][] arr = new char[row][col];
        String output="";
        int j = 0;
        boolean check = false;
        for(int i = 0; i < col; i++){
            if(j == 0 || j== key - 1){
                check = !check;
            }
            arr[j][i] = s.charAt(i);
            if(check){
                j++;
            }else{
                j--;
            }
        }
        for(int i = 0; i < row; i++){
            for(int k = 0; k < col; k++){
                if(arr[i][k] != 0){
                    output += arr[i][k];
                }
            }
        }
        return output;
    }
    public static String Decode_Rail_Fence(String s, int key){
        int row = key;
        int col = s.length();
        char[][] arr = new char[row][col];
        String output="";
        int j = 0;
        boolean check = false;
        for(int i = 0; i < col; i++){
            if(j == 0 || j== key - 1){
                check = !check;
            }
            arr[j][i] = '*';
            // System.out.println(arr[j][i]);
            if(check){
                j++;
            }else{
                j--;
            }
        }
        for(int i = 0; i < row; i++){
            for(int k = 0; k < col; k++){
                if(arr[i][k]!='*'){
                    arr[i][k] = '-';
                }
            }
        }
        int index = 0;
        for(int i = 0; i < row; i++){
            for(int k = 0; k < col; k++){
                if(arr[i][k]=='*'){
                    arr[i][k] = s.charAt(index++);
                }
            }
        }
        // for(int i = 0; i < row; i++){
        //     for(int k = 0; k < col; k++){
        //         System.out.print(arr[i][k]+" ");
        //     }
        //     System.out.println();
        // }
        j = 0;
        check = false;
        for(int i = 0; i < col; i++){
            if(j == 0 || j== key - 1){
                check = !check;
            }
            output += arr[j][i];
            if(check){
                j++;
            }else{
                j--;
            }
        }
        
        return output;
    }
    public static void main(String args[]){
        String s = "hello world";
        String encode = Encode_Rail_Fence(s, 3);
        System.out.println("encode: "+encode);
        String decode = Decode_Rail_Fence(encode, 3);
        System.out.println("decode: "+decode);
        // System.out.println(Decode_Rail_Fence("horel ollwd", 3));
        
    }
}
