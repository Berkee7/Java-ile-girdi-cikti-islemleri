//Berke Erin
//212106206005
public class ForSeyehat {

    String ad,soyad,nereden,nereye;
    int mesafe=0,hiz=0;

    public ForSeyehat(String ad, String soyad, String nereden, String nereye, String hiz,int mesafe) {
        this.ad = ad;
        this.soyad = soyad;
        this.nereden = nereden;
        this.nereye = nereye;
        this.hiz = Integer.parseInt(hiz);
        this.mesafe=mesafe;
    }

    public String goster(){
        int saat=0,dakika=0;
        double toplamSure=(double)mesafe/hiz;
        saat=(int)mesafe/hiz;
        dakika=(int)Math.round((toplamSure-saat)*60);
        String str1,str2,str3,str4;

        str1=Integer.toString(saat);
        str2=Integer.toString(dakika);
        str3=saat+" SAAT"+" "+dakika+" "+" Dakika";
        if(dakika!=0){
            str3=saat+" SAAT"+" "+dakika+" "+" Dakika";
        }else{
            str3=saat+" SAAT";
        }
        //str4=this.ad+"\t"+this.soyad+"\t"+this.nereden+"\t"+this.nereye+"\t"+this.hiz+"\t"+this.mesafe+"\t"+str3;
        return str3;
    }
}
