public class gorevli extends entity {
    private String  soyisim;
    gorevli(String isim, String soyisim)
    {

        super(isim);
        this.soyisim=soyisim;
    }

    String getIsim()
    {
        return super.isim;
    }

    String getSoyisim()
    {
        return soyisim;
    }
}
