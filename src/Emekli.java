public class Emekli implements IAbone{
//Berke Erin
//212106206005
    // Emekli fatura hesaplama tarifesi
    // 1-10 arası her bir metreküp 10 tl
    //11-20 arası herbir metreküp 15 tl
    //21 ve üzeri herbir metreküp 20tl

    // örnek: 28 metreküp su tüketimi varsa
    // 1-10 arası tüketim 10 metreküp  tutar=10*10=100
    // 11-20 arası tüketim 10 metreküp  tutar=10*15=150
    // 21-28 arası tüketim 8 metreküp  tutar= 8*20=160
    //toplam fatura= 100+150+160=410tl
    //varsa eski borç %10 zamlı olarak faturaya eklenecek
    //eğer 60 tl eski borç varsa güncel fatura= 410 +60 + (60*10)/100= 476tl

    String aboneNo, adi,soyAd, aboneTip,tuketim,eskiBorc;

    public Emekli(String aboneNo, String adi, String soyAd, String aboneTip, String tuketim, String eskiBorc) {
        this.aboneNo = aboneNo;
        this.adi = adi;
        this.soyAd = soyAd;
        this.aboneTip = aboneTip;
        this.tuketim = tuketim;
        this.eskiBorc = eskiBorc;
    }

    public double faturaHesapla() {
        int tuk=0,borc=0,toplam=0,total=0;
        if(!eskiBorc.equals("YOK")){
            borc=Integer.parseInt(eskiBorc);
        }else{

            borc=0;
        }
        tuk=Integer.parseInt(tuketim);
        if(tuk<=10){
            toplam=tuk*10;
        } else if (tuk<=20) {
            toplam=10*10+(tuk-10)*15;
        }else{
            toplam = 10 * 10 + 10 * 15 + (tuk - 20) * 20;
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
