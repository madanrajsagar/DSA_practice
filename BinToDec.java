class BinToDec{

    public void BinToDec(int bn){
        int last=0;
        int Dec=0;
        int mynum=bn;
        int pow1=0;

        while(mynum>0){
            last= mynum%10;

            Dec=Dec+(int)(Math.pow(2,pow1)*last);

            mynum=mynum/10;pow1++;

        }
        System.out.println("decimal of"+bn+" is ="+Dec);

    }
    public static void main(String[] args) {
        BinToDec bn= new BinToDec();

        bn.BinToDec(1111);
        
    }

}