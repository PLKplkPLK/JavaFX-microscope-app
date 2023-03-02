package zdjclass;

import java.io.Serializable;


public class Zdjecie implements Serializable{
        public byte[] buffer;
        public String data;
        public String opis;
        public String kolor_dom;
        
        public Zdjecie(byte[] buf, String dat)
        {
            buffer = buf;
            data   = dat;
            opis   = "";
            kolor_dom = "None";
        }
        
        public Zdjecie(byte[] buf, String dat, String ops, String kol)
        {
            buffer = buf;
            data   = dat;
            opis   = ops;
            kolor_dom = kol;
        }
    };