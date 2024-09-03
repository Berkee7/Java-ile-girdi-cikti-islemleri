import java.io.*;
import java.util.ArrayList;

//Berke Erin
//212106206005
public class Seyehat {
    public static void main(String[] args) {
        try {
            File fileR = new File("src/seyehat.txt");
            File fileW = new File("src/seyehatRaporu.txt");
            FileReader fr = new FileReader(fileR);
            FileWriter fw = new FileWriter(fileW);
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter br2 = new BufferedWriter(fw);
            String str;
            br.readLine();
            String [][]sehir=new String[8][2];
            int[][] ikibdizi = new int[8][8];
            int s=1;
            int i=0,k=0,row=0,row2=0;
            br2.write("SEYEHAT RAPORU");
            br2.newLine();
            br2.write("ADI\tSOYADI\tNEREDEN\t\tNEREYE\tHIZ\tMESAFE\tSÜRE");
            br2.newLine();
            while ((str = br.readLine()) != null) {

                str=str.replace("\t"," ");
                str=str.trim();
                String[] parts = str.split(" ");
                if (parts.length == 2 &&!parts[0].equals("Şehir") &&!parts[0].equals("Seyehat")) {

                    for(int col2=0;col2<2;col2++){
                        sehir[row2][col2]=parts[col2];
                    }
                    row2++;
                }
                    if (parts.length == 9 && parts[0].equals(Integer.toString(s))) {
                        for (int col = 0; col < 8; col++) {
                            ikibdizi[row][col] = Integer.parseInt(parts[col + 1]);
                        }
                        row++;

                    }
                    if(parts.length==9)
                        s++;
                if(parts.length==5) {
                    if(!parts[0].equals("ADI")){
                        int t=0,q=0,mesafe=0;
                        while(!parts[2].equals(sehir[t][0])){
                            t++;
                        }
                        while(!parts[3].equals(sehir[q][0])){
                            q++;
                        }
                        mesafe=ikibdizi[t][q];
                        ForSeyehat s1=new ForSeyehat(parts[0],parts[1],parts[2],parts[3],parts[4],mesafe);
                        br2.write(parts[0]+"\t"+parts[1]+"\t"+parts[2]+"\t"+parts[3]+"\t"+parts[4]+"\t"+mesafe+"\t"+s1.goster());
                        br2.newLine();
                    }

                }


            }
            br.close();
            br2.close();
        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
