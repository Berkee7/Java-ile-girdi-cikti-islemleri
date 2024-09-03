public class Aile implements IAbone{
 //Berke Erin
//212106206005

    // Aile fatura hesaplama tarifesi
    // 1-10 arası her bir metreküp 15 tl
    //11-20 arası herbir metreküp 20 tl
    //21 ve üzeri herbir metreküp 30tl

    // örnek: 35 metreküp su tüketimi varsa
    // 1-10 arası tüketim 10 metreküp  tutar=10*15=150
    // 11-20 arası tüketim 10 metreküp  tutar=10*20=200
    // 21-35 arası tüketim 15 metreküp  tutar= 15*30=450
    //toplam fatura= 150+200+450=800tl
    //varsa eski borç %10 zamlı olarak faturaya eklenecek
    //eğer 60 tl eski borç varsa güncel fatura=800 +60 + (60*10)/100= 866tl
    String aboneNo, adi,soyAd, aboneTip,tuketim,eskiBorc;

    public Aile(String aboneNo, String adi, String soyAd, String aboneTip, String tuketim, String eskiBorc) {
        this.aboneNo = aboneNo;
        this.adi = adi;
        this.soyAd = soyAd;
        this.aboneTip = aboneTip;
        this.tuketim = tuketim;
        this.eskiBorc = eskiBorc;
    }

    @Override
    public double faturaHesapla() {
        int tuk=0,borc=0,toplam=0,total=0;
        if(!eskiBorc.equals("YOK")){
            borc=Integer.parseInt(eskiBorc);
        }else{

            borc=0;
        }
        tuk=Integer.parseInt(tuketim);
        if(tuk<=10){
            toplam=tuk*15;
        } else if (tuk<=20) {
            toplam=10*15+(tuk-10)*20;
        }else{
            toplam = 10 * 15 + 10 * 20 + (tuk - 20) * 30;
        }
        total=toplam+borc+((borc*10)/100);
        return total;

    }

    @Override
    public double eskiBorcMiktari() {

        double borc=0;
        if(!eskiBorc.equals("YOK")){
            borc=Double.parseDouble(eskiBorc);
        }else{

            borc=0;
        }
        return borc;
    }

    @Override
    public String aboneTuru() {
        return null;
    }
}
