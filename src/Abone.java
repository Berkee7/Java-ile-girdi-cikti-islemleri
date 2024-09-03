import java.io.*;
//Berke Erin
//212106206005
public class Abone {

    public static void main(String[] args) throws IOException {
        //IAbone[] abone = new IAbone[220];
        try {
            File fileR = new File("src/tuketim.txt");
            File fileW = new File("src/tuketimRaporu.txt");
            FileReader fr = new FileReader(fileR);
            FileWriter fw = new FileWriter(fileW);
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter br2 = new BufferedWriter(fw);
            String str;
            int i=0;
            br.readLine();
            br2.write("FATURA İSTATİSTİKLERİ");
            br2.newLine();
            int faturaToplam=0,aileTop=0,emekliTop=0,ogrTop=0,ticTop=0; // Abone türlerine göre toplam faturalar
            int aS=0,eS=0,oS=0,tS=0; // Abone sayıları
            int ab=0,eb=0,ob=0,tb=0; // Borcu olan abonelerin sayısı
            double temp1=0,temp3=0,temp2=0,temp4=0;
            double tempTut1=0,tempTut2=0,tempTut3=0,tempTut4=0;// En yüksek değere sahip faturalar
            String[]atut=new String[5];
            String[]etut=new String[5];
            String[]otut=new String[5];
            String[]ttut=new String[5];
            while ((str = br.readLine()) != null) {
                str=str.trim();
                String []parts=str.split(" ");
                if(parts[3].equals("Aile")){
                    aS++;
                   IAbone ib=new Aile(parts[0],parts[1],parts[2],parts[3],parts[4],parts[5]);
                    tempTut1=ib.faturaHesapla();
                    faturaToplam+=tempTut1;
                    aileTop+=tempTut1;
                    if(ib.eskiBorcMiktari()!=0){
                        ab++;
                    }
                    if(temp1<tempTut1){
                        temp1=tempTut1;
                        atut[0]=parts[0];
                        atut[1]=parts[1];
                        atut[2]=parts[2];
                        atut[3]=parts[3];
                        atut[4]=Double.toString(temp1);
                    }
                    i++;
                }
                else if(parts[3].equals("Emekli")){
                    eS++;
                    IAbone ib=new Emekli(parts[0],parts[1],parts[2],parts[3],parts[4],parts[5]);
                    tempTut2=ib.faturaHesapla();
                    faturaToplam+=tempTut2;
                    emekliTop+=tempTut2;
                    if(ib.eskiBorcMiktari()!=0){
                        eb++;
                    }if(temp2<tempTut2){
                        temp2=tempTut2;
                        etut[0]=parts[0];
                        etut[1]=parts[1];
                        etut[2]=parts[2];
                        etut[3]=parts[3];
                        etut[4]=Double.toString(temp2);
                    }
                    i++;
                }
                else if(parts[3].equals("Öğrenci")){
                    oS++;
                    IAbone ib=new Ogrenci(parts[0],parts[1],parts[2],parts[3],parts[4],parts[5]);
                    tempTut3=ib.faturaHesapla();
                    faturaToplam+=tempTut3;
                    ogrTop+=tempTut3;
                    if(ib.eskiBorcMiktari()!=0){
                        ob++;
                    }
                    if(temp3<tempTut3){
                        temp3=tempTut3;
                        otut[0]=parts[0];
                        otut[1]=parts[1];
                        otut[2]=parts[2];
                        otut[3]=parts[3];
                        otut[4]=Double.toString(temp3);
                    }
                    i++;
                }
                else{
                    tS++;
                    IAbone ib=new Ticarethane(parts[0],parts[1],parts[2],parts[3],parts[4],parts[5]);
                    tempTut4=ib.faturaHesapla();
                    faturaToplam+=tempTut4;
                    ticTop+=tempTut4;
                    if(ib.eskiBorcMiktari()!=0){
                        tb++;
                    }
                    if(temp4<tempTut4){
                        temp4=tempTut4;
                        ttut[0]=parts[0];
                        ttut[1]=parts[1];
                        ttut[2]=parts[2];
                        ttut[3]=parts[3];
                        ttut[4]=Double.toString(temp4);
                    }
                    i++;
                }

            }
            br2.newLine();
            br2.write("1- TOPLAM FATURA TUTARI: "+faturaToplam);
            br2.newLine();
            br2.newLine();
            br2.write("2- ABONE SAYILARI");
            br2.newLine();
            br2.write("AİLE           :");
            br2.write(Integer.toString(aS));
            br2.newLine();
            br2.write("EMEKLİ         :");
            br2.write(Integer.toString(eS));
            br2.newLine();
            br2.write("ÖĞRENCİ        :");
            br2.write(Integer.toString(oS));
            br2.newLine();
            br2.write("TİCARETHANE    :");
            br2.write(Integer.toString(tS));
            br2.newLine();
            br2.newLine();
            br2.write("3- ABONE TÜRLERİNE GÖRE TOPLAM FATURA TUTARLARI");
            br2.newLine();
            br2.write("AİLE           :");
            br2.write(Integer.toString(aileTop));
            br2.newLine();
            br2.write("EMEKLİ         :");
            br2.write(Integer.toString(emekliTop));
            br2.newLine();
            br2.write("ÖĞRENCİ        :");
            br2.write(Integer.toString(ogrTop));
            br2.newLine();
            br2.write("TİCARETHANE    :");
            br2.write(Integer.toString(ticTop));
            br2.newLine();
            br2.newLine();
            br2.write("4- ABONE TÜRLERİNE GÖRE GEÇMİŞ DÖNEMDEN BORCU OLAN ABONE SAYILARI ");
            br2.newLine();
            br2.write("AİLE           :");
            br2.write(Integer.toString(ab));
            br2.newLine();
            br2.write("EMEKLİ         :");
            br2.write(Integer.toString(eb));
            br2.newLine();
            br2.write("ÖĞRENCİ        :");
            br2.write(Integer.toString(ob));
            br2.newLine();
            br2.write("TİCARETHANE    :");
            br2.write(Integer.toString(tb));
            br2.newLine();
            br2.newLine();
            br2.write("5- ABONE TÜRLERİNE GÖRE EN YÜKSEK FATURA ÖDEYEN ABONE BİLGİLERİ");
            br2.newLine();
            br2.write("ABONE NO\tADI\t\t\tSOYADI\t\tABONE TÜRÜ\t\tFATURA TUTARI");
            br2.newLine();
            br2.write(atut[0]+"\t\t"+atut[1]+"\t\t"+atut[2]+"\t\t"+atut[3]+"\t\t\t"+atut[4]);
            br2.newLine();
            br2.write(etut[0]+"\t\t"+etut[1]+"\t\t"+etut[2]+"\t\t"+etut[3]+"\t\t\t"+etut[4]);
            br2.newLine();
            br2.write(otut[0]+"\t\t"+otut[1]+"\t\t"+otut[2]+"\t\t"+otut[3]+"\t\t\t"+otut[4]);
            br2.newLine();
            br2.write(ttut[0]+"\t\t"+ttut[1]+"\t\t"+ttut[2]+"\t\t"+ttut[3]+"\t\t\t"+ttut[4]);



           // System.out.println(atut[0]+" "+atut[1]+" "+atut[2]+" "+atut[3]+" "+atut[4]);
            br.close();
            br2.close();

        } catch (IOException e) {

            e.printStackTrace();

        }





    }
}