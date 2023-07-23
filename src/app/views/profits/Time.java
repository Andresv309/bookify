package app.views.profits;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;


public class Time extends Thread{

    private final JLabel hour; 
    private final JLabel date;  
    
    
    public Time(JLabel hour, JLabel date ) {
        this.hour = hour;
        this.date = date;
    }
    
    @Override
    public void run() {
        
        while(true) {
            Date hoy = new Date();
            SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
            SimpleDateFormat day = new SimpleDateFormat("dd-MM-yyyy");
            
            hour.setText(time.format(hoy));
            date.setText(day.format(hoy));
            
        }
       
    }

  
    
    
}
